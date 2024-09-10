package org.project.cyberudition.repo;

import org.project.cyberudition.entity.SolanaWallet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SolanaWalletRepo extends MongoRepository<SolanaWallet,Long>{
}
