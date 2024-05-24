const app = angular.module("Myapp", ["ngRoute"]);
const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))

app.run(function ($http, $rootScope) {
    $http.get(`/rest/security/authentication`).then(resp => {
        if (resp.data) {
            $auth = $rootScope.$auth = resp.data;
            $http.defaults.headers.common["Authorization"] = $auth.token;
        }
    });

    $rootScope.formProduct = {
        id: '',
        name: '',
        img: '',
        status: 1,
        material: {},
        productCategory: {}
    };
    $rootScope.ctg = {
    };
    $rootScope.total_ctg = {
        id: '',
        name :''
    }
    $rootScope.mtrlctg = {
        id: '',
        materialCategoryName: ''
    };
    $rootScope.mtrl = {
    };
    $rootScope.colorform = {
        id: 0,
        colorName: '',
        img: ''
    };
    $rootScope.dimensionform = {
        id: 0,
        size: ''
    };

    $rootScope.coloritemlist = {
        id: '',
        product: {},
        color: {}
    };
    $rootScope.dimensionitemlist = {
        id: '',
        price: '',
        product: {},
        dimension: {}
    };
    $rootScope.colorlist = [];
    $rootScope.dimensionlist = [];
    // $rootScope.status = 0;
    $rootScope.reset = function () {
        $rootScope.colorlist = [];
        $rootScope.dimensionlist = [];
        $rootScope.formProduct = {
            id: '',
            name: '',
            img: '',
            status: 1,
            material: {},
            productCategory: {}
        };
    };

    $rootScope.bannerform = {
        id: 0,
        title: '',
        imgage: '',
        url: '',
        state: ''
    };


    $rootScope.initialize = function () {
        // load totalCategory
        $http.get("/rest/totalCategory").then(resp => {
            $rootScope.totalcategories = resp.data;
        });
        // load category
        $http.get("/rest/category").then(resp => {
            $rootScope.categories = resp.data;
        });
        // load Vật liệu
        $http.get("/rest/material").then(resp => {
            $rootScope.materials = resp.data;
        });
        // load thể loại vật liệu
        $http.get("/rest/materialCategory").then(resp => {
            $rootScope.materialCategorys = resp.data;
        });
        // load product
        $http.get("/rest/products").then(resp => {
            $rootScope.products = resp.data;
        });
        // load color
        $http.get("/rest/color").then(resp => {
            $rootScope.colors = resp.data;
        });
        // load kích thước
        $http.get("/rest/dimension").then(resp => {
            $rootScope.dimensions = resp.data;
        });
        $http.get("/rest/banner").then(resp => {
            $rootScope.banner = resp.data;
        });
        // $rootScope.reset();
    }

    $rootScope.initialize();
})
app.config(function ($routeProvider, $locationProvider, $qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
    $locationProvider.hashPrefix('');
    $routeProvider
        .when("/", {
            templateUrl: "/assets/admin/product/product.html",
            controller: "color-ctrl"
        },{
            templateUrl: "/assets/admin/product/product.html",
            controller: "category-ctrl"
        },{
            templateUrl: "/assets/admin/product/product.html",
            controller: "dimension-ctrl"
        },{
            templateUrl: "/assets/admin/product/product.html",
            controller: "material-ctrl"
        },{
            templateUrl: "/assets/admin/product/product.html",
            controller: "product-ctrl"
        }
    )
        .when("/create", {
            templateUrl: "/assets/admin/product/_form.html",
            controller: "color-ctrl"
        },{
            templateUrl: "/assets/admin/product/_form.html",
            controller: "category-ctrl"
        },{
            templateUrl: "/assets/admin/product/_form.html",
            controller: "dimension-ctrl"
        },{
            templateUrl: "/assets/admin/product/_form.html",
            controller: "material-ctrl"
        },{
            templateUrl: "/assets/admin/product/_form.html",
            controller: "product-ctrl"
        }
    )
        .when("/update/:id", {
            templateUrl: "/assets/admin/product/Update_form.html",
            controller: "product-ctrl"
        })
        .when("/unauthorized", {
            templateUrl: "/assets/admin/authority/unauthorized.html",
            controller: "authority-ctrl"
        })
});