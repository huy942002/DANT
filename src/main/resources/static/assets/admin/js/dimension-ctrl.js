app.controller("dimension-ctrl",function ($http,$rootScope) {
    //    Thêm mới kích thước
    $rootScope.createdimension = function (event) {
        let dimension = angular.copy($rootScope.dimensionform);
        $http.post(`/rest/dimension`, dimension).then(resp => {
            $rootScope.dimensions.push(resp.data);
            alert("Thêm mới kích thước thành công!");
        }).catch(error => {
            alert("Lỗi thêm mới kích thước!");
            console.log("Error", error);
        });
    }
})