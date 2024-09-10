package org.project.cyberudition.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "SolanaWallets")
public class SolanaWallet {

    @Transient
    public static final String SEQUENCE_NAME = "solanawallets_sequence";

    @Id
    private long id;

    private String name;

    private String publickey;

    private long amounts;


}
