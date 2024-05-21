const app = angular.module("app", []);

app.run(function ($http, $rootScope) {
    var $productHome = $rootScope.productHome = {
        productsfilter: [],
        productprices:[],
        LoadHome(){
            $http.get("/products/all").then(resp => {
                $rootScope.products = resp.data;
                console.log($rootScope.products.length)
                this.productsfilter[0] = angular.copy($rootScope.products[$rootScope.products.length - 1]);
                this.productsfilter[1] = angular.copy($rootScope.products[$rootScope.products.length - 2]);
                this.productsfilter[2] = angular.copy($rootScope.products[$rootScope.products.length - 3]);
                this.productsfilter[3] = angular.copy($rootScope.products[$rootScope.products.length - 4]);
                this.productsfilter[4] = angular.copy($rootScope.products[$rootScope.products.length - 5]);
                this.productsfilter[5] = angular.copy($rootScope.products[$rootScope.products.length - 6]);
                console.log(this.productsfilter)
                this.productsfilter.forEach(element => {
                    $http.get("/products/"+ element.id).then(resp => {
                        this.productprices.push(resp.data);
                        console.log(this.productprices);
                    })
                });
            });
        }
    }

    $productHome.LoadHome();
})