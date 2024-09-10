const connectButton = document.getElementById('connect-button');
const walletAddressDisplay = document.getElementById('wallet-address');
const walletBalanceDisplay = document.getElementById('wallet-balance');

// Kiểm tra Phantom Wallet có được cài đặt hay không
const getProvider = () => {
    if ("solana" in window) {
        const provider = window.solana;
        if (provider.isPhantom) {
            return provider;
        }
    }
    window.open("https://phantom.app/", "_blank");
};

// Kết nối với Phantom Wallet
const connectPhantomWallet = async () => {
    const provider = getProvider();
    if (provider) {
        try {
            // Yêu cầu kết nối ví
            const response = await provider.connect();
            const publicKey = response.publicKey.toString();

            // Hiển thị địa chỉ ví
            walletAddressDisplay.textContent = "Đã kết nối với ví: " + publicKey;

            // Gửi public key về backend để lấy số dư
            await sendPublicKeyToBackend(publicKey);
        } catch (err) {
            console.error("Lỗi khi kết nối Phantom Wallet:", err);
        }
    }
};

// Gửi public key về backend và hiển thị số dư
const sendPublicKeyToBackend = async (publicKey) => {
    try {
        const response = await fetch('/api/send-public-key', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ publicKey }),
        });

        const result = await response.json();

        if (result.error) {
            walletBalanceDisplay.textContent = "Lỗi: " + result.error;
        } else {
            // Chuyển đổi lamports thành SOL (1 SOL = 1,000,000,000 lamports)
            const balanceInSOL = result.balance / 1_000_000_000;
            walletBalanceDisplay.textContent = "Số dư: " + balanceInSOL + " SOL";
        }
    } catch (err) {
        console.error('Lỗi khi gửi public key về backend:', err);
    }
};

connectButton.addEventListener('click', connectPhantomWallet);