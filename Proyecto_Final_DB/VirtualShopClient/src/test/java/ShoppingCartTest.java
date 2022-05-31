import models.Product;
import models.ShoppingCart;
import models.ShoppingCartProduct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    ShoppingCart cart = new ShoppingCart();

    ShoppingCartProduct product = new ShoppingCartProduct(new Product("1", "Patata", 2, 29.99,25), 2);
    ShoppingCartProduct product2 = new ShoppingCartProduct(new Product("2", "Pera", 2, 29.99,25), 2);


    @Test
    void addProductToCart() {
        cart.addProductToCart(product);

        assertFalse(cart.addProductToCart(product));
        assertTrue(cart.addProductToCart(product2));
    }

    @Test
    void modifyProductQuantity() {
        cart.addProductToCart(product);
        cart.modifyProductQuantity("Patata", 5);

        assertEquals(5, cart.getAllProducts().get(0).getQuantity());
    }

    @Test
    void getAllProducts() {
        cart.addProductToCart(product);
        cart.addProductToCart(product2);

        assertEquals(2, cart.getAllProducts().size());
        assertEquals("Patata", cart.getAllProducts().get(0).getProduct().getName());
    }
}