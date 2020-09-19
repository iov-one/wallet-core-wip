// Copyright © 2017-2020 Trust Wallet.
//
// This file is part of Trust. The full Trust copyright notice, including
// terms governing use, modification, and redistribution, is contained in the
// file LICENSE at the root of the source code distribution tree.

package com.trustwallet.core.app.blockchains.iov

import com.trustwallet.core.app.utils.toHex
import com.trustwallet.core.app.utils.toHexByteArray
import org.junit.Assert.assertEquals
import org.junit.Test
import wallet.core.jni.*

class TestIOVAddress {

    init {
        System.loadLibrary("TrustWalletCore")
    }

    @Test
    fun testAddress() {

        val key = PrivateKey("1037f828ca313f4c9e120316e8e9ff25e17f07fe66ba557d5bc5e2eeb7cba8f6".toHexByteArray())
        val publicKey = key.getPublicKeySecp256k1(true)
        val address = AnyAddress(publicKey, CoinType.IOV)

        assertEquals(publicKey.data().toHex(), "0x035df185566521d6a7802319ee06e1a28e97b7772dfb5fdd13ca6f0575518968e4")
        assertEquals(address.description(), "star1gfpfk3s8xnupdce7pgt3z7mf79clvkw6px89ne")
    }
}