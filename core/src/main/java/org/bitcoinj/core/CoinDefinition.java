package org.bitcoinj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "Quebecoin";
    public static final String coinTicker = "QBC";
    public static final String coinURIScheme = "quebecoin";
    public static final String cryptsyMarketId = "26";
    public static final String cryptsyMarketCurrency = "QBC";
    public static final String PATTERN_PRIVATE_KEY_START_UNCOMPRESSED = "[7]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[X]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;

    public static final String UNSPENT_API_URL = "https://chainz.cryptoid.info/dash/api.dws?q=unspent";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Cryptoid;

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://http://cryptexplorer.com/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    public static final String DONATION_ADDRESS = "QRskHZbxrkXTThMJRa1v3rapsLWFfa9EPD";  //Hash Engineering donation DASH address

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(24 * 60 * 60);  // 24 hours per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(2.5 * 60);  // 2.5 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //57 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static final long MAX_COINS = 42000000;                 //main.h:  MAX_MONEY


    public static final long DEFAULT_MIN_TX_FEE = 10000;   // MIN_TX_FEE
    public static final long DUST_LIMIT = 100000; //Transaction.h CTransaction::GetDustThreshold for 10000 MIN_TX_FEE
    public static final long INSTANTX_FEE = 100000; //0.001 DASH (updated for 12.1)
    public static final boolean feeCanBeRaised = false;

    //
    // Dash 0.12.1.x
    //
    public static final int PROTOCOL_VERSION = 70020;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70010;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 56790;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 46790;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 58;             //before == 76 base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 5;             //base58.h before == 16 CBitcoinAddress::SCRIPT_ADDRESS
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long oldPacketMagic = 0xfbc0b6db;      //0xfb, 0xc0, 0xb6, 0xdb
    public static final long PacketMagic = 0xd3edc9f1; //0xbf0c6bbd;

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget =  (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1395522490L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (884876);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "00000948015ca05a2197f8f676476c9dbc11de07c87e1a46f2331ea10f33087d"; //main.cpp: hashGenesisBlock
    static public String genesisMerkleRoot = "024e91919c99f8bec2cd0c8876983d5e9da3a2b43f3db7c1d9b8131eaad27c18";
    static public int genesisBlockValue = 26;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "04ffff001d01044c554c615072657373652032322f4d61722f32303134204c65205175c3a96265632061206c6573206d6f79656e7320646520646576656e697220756e20706179732c207265636f6e6e61c3ae7420436f75696c6c617264";   //"limecoin se convertira en una de las monedas mas segura del mercado, checa nuestros avances"
    static public String genesisTxOutBytes = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "dnsseed.service-crypto.com",
            "qbcseed.service-crypto.com"
    };


    public static int minBroadcastConnections = 0;   //0 for default; Using 3 like BreadWallet.

    //
    // TestNet - DASH
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 140;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 19;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xcee2caff;      //
    public static final String testnetGenesisHash = "00000bafbc94add76cb75e2ec92894837288a481e5c005f6563d91623bf8bc2c";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1390666206L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (3861367235L);                         //main.cpp: LoadBlockIndex




    //main.cpp GetBlockValue(height, fee)  //still to do
    public static final Coin GetBlockReward(int height)
    {
        int COIN = 1;
        Coin nSubsidy = Coin.valueOf(26, 0);
        if (height == 1)
            nSubsidy = Coin.valueOf(21000000, 0);
	if (height  < 25)
            nSubsidy = Coin.valueOf(0, 0);  // 0 Reward blocks to allow DarkGravityWave to start before distributing QBC.
	if (height  < 49)
            nSubsidy = Coin.valueOf(1, 0);  // 1 Hour timeframe with 1 QBC block reward to allow miners to set up and be more fair to all.
	if (height  < 73)
            nSubsidy = Coin.valueOf(4, 0);  // 1 Hour timeframe with small block reward to allow miners to set up and be more fair to all.
	if (height  < 97)
            nSubsidy = Coin.valueOf(13, 0);  // 1 Hour timeframe with half block reward to allow miners to set up and be more fair to all.


	// Subsidy is cut in half every 420480 blocks, which will occur approximately every 4 years
	nSubsidy.shiftRight(height / 420480);  //  Quebecoin: 420480 blocks in ~2 years

        return nSubsidy;
}
    //main.cpp GetBlockValue(height, fee)
 //   public static final Coin GetBlockReward(int height)
 //   {
 //       int COIN = 1;
 //       Coin nSubsidy = Coin.valueOf(100, 0);
 //       if (height == 1)
 //           nSubsidy = Coin.valueOf(420000, 0);
 //       return nSubsidy;
 //   }

    public static int subsidyDecreaseBlockCount = 4730400;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(504365055); //0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
            "testnet-seed.dashdot.io",
            "test.dnsseed.masternode.io",
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "04a9cfd81af5d53310be45e6326e706a542b1028df85d2819d5de496d8816c83129ce874fe5e3a23b03544bff35458833779dab7a6ff687525a4e23ca59f1e2b94";
    public static final String TESTNET_SATOSHI_KEY = "04a9cfd81af5d53310be45e6326e706a542b1028df85d2819d5de496d8816c83129ce874fe5e3a23b03544bff35458833779dab7a6ff687525a4e23ca59f1e2b94";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.quebecoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.darkcoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.darkcoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put( 5,   new Sha256Hash("00000abcc55a9231f53e7c3cc4de43720139097aa2a72916a0ad725765038916"));
        checkpoints.put( 405, new Sha256Hash("00000000010a5becc2de4e7af1f48209383924342ed7bbbc822a63df311dc72a"));
        checkpoints.put( 700, new Sha256Hash("0000000000d448d3f99ff853f56ebab921586e7b4de66dafdeeed0b4a4f75485"));
        checkpoints.put( 800, new Sha256Hash("0000000000c2d5be6c8eebc3f395db1f934773db0a882fb629f6a43568c56714"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "XgxQxd6B8iYgEEryemnJrpvoWZ3149MCkK";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "XDtvHyDHk4S3WJvwjxSANCpZiLLkKzoDnjrcRhca2iLQRtGEz1JZ";

}
