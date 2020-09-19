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
        val expected = AnyAddress("star1gfpfk3s8xnupdce7pgt3z7mf79clvkw6px89ne", CoinType.IOV)

        assertEquals(publicKey.data().toHex(), "starpub1addwnpepq2svqq4xaxq4jxey3nx69zznxjuhke02fm2q0a45lt5h2uw78n9qq2jpw7g")
        assertEquals(address.description(), expected.description())
    }
}