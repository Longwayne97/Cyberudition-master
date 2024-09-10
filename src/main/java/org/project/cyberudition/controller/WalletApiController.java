package org.project.cyberudition.controller;

import org.p2p.solanaj.rpc.Cluster;
import org.p2p.solanaj.rpc.RpcClient;
import org.p2p.solanaj.core.PublicKey;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class WalletApiController {

    @PostMapping("/api/send-public-key")
    public String handlePublicKey(@RequestBody Map<String, String> payload) {
        String publicKeyStr = payload.get("publicKey");
        PublicKey publicKey = new PublicKey(publicKeyStr);

        // Kết nối tới Solana Devnet
        RpcClient client = new RpcClient(Cluster.DEVNET);

        // Kiểm tra số dư của tài khoản
        try {
            long balance = client.getApi().getBalance(publicKey);
            System.out.println(balance);
            return "{\"balance\": " + balance + "}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"" + e.getMessage() + "\"}";
        }
    }
}
