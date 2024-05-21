app.controller("color-ctrl", function ($rootScope, $http) {
    $rootScope.createcolor = function (event) {
        $rootScope.colorform.img = angular.copy($rootScope.nameFile);
        var color = angular.copy($rootScope.colorform);
        $http.post('/rest/upload/images', form, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {
            $http.post(`/rest/color`, color)
                .then(resp => {
                    $rootScope.colors.push(resp.data);
                    // $scope.reset();
                    alert("Thêm mới màu thành công!");
                }).catch(error => {
                    alert("Lỗi thêm mới màu!");
                    console.log("Error", error);
                });
        }).catch(error => {
            alert("Lỗi upload hình ảnh");
            console.log("Error", error);
        })
    }

    $rootScope.deletecolor = function (item) {
        $http.delete('/rest/color/' + item.id).then(resp => {
            var index = $scope.colors.findIndex(c => c.id == item.id);
            $rootScope.colors.splice(index, 1);
            // $scope.reset();
            // alert("Thêm mới loại sản phẩm thành công!");
        }).catch(error => {
            alert("Error!");
            console.log("Error", error);
        });
    }
})

