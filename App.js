// single state store
class Store {
    // these are the key name you can use in Store


    constructor(storage) {
        this.storage = storage; // assuming local storage will be passed in as storage
        this.CART_KEY = 'CART';
        this.QUEUE_KEY = 'QUEUE';
        this.FOODS_KEY = 'FOODS';
    }

    // you can get item by store.cartItems
    get cartItems() {
        return JSON.parse(this.storage.getItem(this.CART_KEY));
    }

    // to call setter, simply "assign" like store.cartItems = something
    set cartItems(cartItems) {
        this.storage.setItem(this.CART_KEY, JSON.stringify(cartItems));
    }

    get queue() {
        return JSON.parse(this.storage.getItem(this.QUEUE_KEY));
    }

    set queue(queue) {
        this.storage.setItem(this.QUEUE_KEY, JSON.stringify(queue));
    }

    get foods() {
        return JSON.parse(this.storage.getItem(this.FOODS_KEY));
    }

    set foods(foods) {
        this.storage.setItem(this.FOODS_KEY, JSON.stringify(foods));
    }
}

class Cart {
    // take dom element into JavaScript class to attachment events
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.items = this.store.cartItems;
        this.init();
    }

    init() {
        // Render a list of items under root element
        this.render();
        // TODO: attach all necessary events
    }

    destroy() {
        // TODO: remove all the events attached from init
        //   tbody.innerHTML = ``;
    }

    // remove an item from shopping cart
    removeItem(item) {
        // TODO: logic to remove an item from cart
        // call render method when the item is removed to update view
        //Tried Using Splice but failed REPEATEDLY!!!
        var fill = this.items;
        fill = fill.filter(a => a !== fill[item]);
        this.store.cartItems = fill;

        console.log(this.store.cartItems);
        location.reload(false);
        this.render();
    }

    placeOrder() {
        // add item to statuses in store as status "in progress"
    }

    // render a list of item under root element
    render() {
        console.log(this.store.cartItems);
        let tbody = this.root.querySelector('tbody');
        // using innerHTML to render a list of table row item under tbody


        var dataset = this.store.cartItems;

        tbody.innerHTML = ``;
        for (var i = 0; i < dataset.length; i++) {

            tbody.innerHTML += `<tr class="item">
            <td>${dataset[i].name}</td>
            <td>${dataset[i].price}</td>
            <td img src=${dataset[i].img}>${dataset[i].name}</td>
            <td><button class="delete-button" data-index="${i}" >Remove</button></td>
        <tr>`
        }



        let deletebutton = document.querySelectorAll('.delete-button');
        deletebutton.forEach(btn => {
            btn.addEventListener('click', () => {


                this.removeItem(btn.dataset.index);
            });
        });


    }
}

class CheckoutButton {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.onClick = () => this.addItemToCart();
        this.init();
    }

    init() {
        this.root.addEventListener('click', this.onClick);
    }

    destroy() {

    }

    addItemToCart() {
        // hint: you can use `dataset` to access data attributes
        // See passing data from HTML to JavaScript from course note
        let cartItems = this.store.cartItems || [];
        // TODO: replace with actual item
        console.log(this.root.dataset);
        cartItems.push({
            name: this.root.dataset.name,
            price: this.root.dataset.price,
            img: this.root.dataset.img

        });
        console.log(cartItems);
        this.store.cartItems = cartItems;
    }
}



class StatusTable {
    // take dom element into JavaScript class to attachment events
    constructor(root, store) {
        this.root = root;
        this.store = store;
        init();
    }

    init() {
        // attach click event listener to table header row on each column
        render();
    }

    destroy() {
        // remove all the events attached from init
    }

    sort(columnName) {
        // after sorting the array of statuses, re render item to update view
        render();
    }

    // render rows of items under table using root.innerHTML
    render() {

        console.log(this.store.cartItems);
        let tbody = this.root.querySelector('status');
        // using innerHTML to render a list of table row item under tbody
        var dataset = this.store.cartItems;



    }



}

class CreateFood {
    constructor(root, store) {
        this.root = root; // root should be the container of the form itself
        this.store = store;
        this.init();
    }

    init() {
        // attach click event to create button
        let createFoodButton = document.getElementById('create_food_button');
        if (createFoodButton) {
            createFoodButton.addEventListener("click", () => {
                this.createFood();
            });
        }

    }

    createFood() {
        let storeFoods = this.store.foods || [];


        var item_name = document.getElementById('item_name').value;
        var item_image = document.getElementById("item_image").value;
        var item_description = document.getElementById('item_description').value;
        var item_price = document.getElementById('item_price').value;
        var to_push = { name: item_name, image: item_image, description: item_description, price: item_price };





        storeFoods.push(to_push);
        this.store.foods = storeFoods;


        console.log(storeFoods);


        // addfooditems()
        // {
        //      var newFood=this.store.foods || [];
        //      var foodName= document.querySelector('#foodName').value;
        // }
    }
}

class Inventory {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.init();
    }

    init() {
        this.render();
        // TODO: attach event listeners like click to remove items after rendering
    }

    destroy() {
        // TODO: remove event listeners added from the init above

        let removeInventoryButtons = document.querySelectorAll('.removebutton');
        for (var i = 0; i < removeInventoryButtons.length; i++) {
            let btn = removeInventoryButtons[i];
            btn.removeEventListener('click', () => {
                let item = this.store.foods[parseInt(btn.dataset.index)];
                //console.log(item);
                //debugger;
                this.removeItem(item);
            });
        }



    }

    removeItem(itemName) {
        // TODO: function to remove item given item name from store
        if (this.store.foods !== null) {
            var updatedlist = [];
            var compare = itemName.name;
            for (var i = 0; i < this.store.foods.length; i++) {
                if (this.store.foods[i].name !== compare) {
                    updatedlist.push(this.store.foods[i]);
                }
            }
            this.store.foods = updatedlist;
           // console.log(updatedlist);
        }
        this.render();
    }



    render() {

        let tbody = this.root.querySelector('tbody');

        tbody.innerHTML = ``;


        if (this.store.foods === null) {
            this.store.foods = [];
        }

        for (var i = 0; i < this.store.foods.length; i++) {

            var item_name = this.store.foods[i].name;
            var item_image = this.store.foods[i].image;
            var item_description = this.store.foods[i].description;
            var item_price = this.store.foods[i].price;

            tbody.innerHTML +=
                `<tr >
                     <td>${item_name}</td>
                        <td>
                            <img class="item1"src=${item_image}>
                        </td>
                        <td>${item_description}
                        </td>
                        <td>
                        ${item_price}
                        </td>
                        <td>
                            <button class="deletebutton" data-index=${i}>Remove From Inventory</button>
                         </td>
                      </tr>`;
        }

        let deleteButtons = document.querySelectorAll('.deletebutton');
        for (var i = 0; i < deleteButtons.length; i++) {
            let btn = deleteButtons[i];
            btn.addEventListener('click', () => {
                alert("Are you Sure?")
                let item = this.store.foods[parseInt(btn.dataset.index)];
                this.removeItem(item);
            });
        }
    }
}







// DOMContentLoaded event will allow us to run the following function when
// everything is ready. Think of the following code will only be executed by
// the end of document
document.addEventListener('DOMContentLoaded', () => {
    // use querySelector to find the table element (preferably by id selector)
    let statusTable = document.querySelector('.status-table');
    // use querySelector to find the cart element (preferably by id selector)
    let cart = document.querySelector('.cart-table');
    let checkoutButtons = document.querySelectorAll('.button1');
    // let DeleteButton=document.querySelectorAll('.delete-button');

    let createFood = document.querySelector('#create_food_form');

    let inventory = document.querySelector('#inventory_table');
    let menu = document.querySelector('#menu_table');




    let store = new Store(window.localStorage);


    //let createFood=document.querySelector('.create_food_button');









    // if (table) {
    //     new StatusTable(table, store);
    // }
    if (cart) {
        new Cart(cart, store);
    }
    if (checkoutButtons && checkoutButtons.length) {
        for (var i = 0; i < checkoutButtons.length; i++) {
            new CheckoutButton(checkoutButtons[i], store);
        }
    }
    if (createFood) {
        new CreateFood(createFood, store);
    }

    if (inventory) {
        new Inventory(inventory, store);
    }
    if (menu) {
        new Menu(menu, store, cartVar);
    }
});