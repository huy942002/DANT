app.controller("material-ctrl",function ($http,$rootScope) {
     //    Thêm mới vật liệu
     $rootScope.creatematerial = function (event) {
        let material = angular.copy($rootScope.mtrl);
        $http.post(`/rest/material`, material).then(resp => {
            $rootScope.materials.push(resp.data);
            // $scope.reset();
            alert("Thêm mới vật liệu thành công!");
        }).catch(error => {
            alert("Lỗi thêm mới vật liệu!");
            console.log("Error", error);
        });
    }
    //    Thêm mới thể loại vật liệu
    $rootScope.creatematerialCategorys = function () {
        let materialCategory = angular.copy($rootScope.mtrlctg);
        $http.post(`/rest/materialCategory`, materialCategory).then(resp => {
            $rootScope.materialCategorys.push(resp.data);
            // $rootScope.reset();
            alert("Thêm mới thể loại vật liệu thành công!");
        }).catch(error => {
            alert("Lỗi thêm mới thể loại vật liệu!");
            console.log("Error", error);
        });
    }
    
})