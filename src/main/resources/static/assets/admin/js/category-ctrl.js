app.controller("category-ctrl", function ($rootScope, $http) {
    $rootScope.createctgl = function (event) {
        var category = angular.copy($rootScope.ctg);
        $http.post(`/rest/category`, category).then(resp => {
            $rootScope.categories.push(resp.data);
            // $scope.reset();
            alert("Thêm mới loại sản phẩm thành công!");
        }).catch(error => {
            alert("Lỗi thêm mới loại sản phẩm!");
            console.log("Error", error);
        });
    }

    $rootScope.delete = function () {
        
    }
})

