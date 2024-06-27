package org.David.factory;

import org.David.service.Impl.CartServiceImpl;

public final class CartFactory {
    private CartServiceImpl instance;

    public CartFactory() {
        instance = CartServiceImpl.getInstance();
    }
}
