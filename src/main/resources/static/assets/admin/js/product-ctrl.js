app.controller("product-ctrl", function ($rootScope, $http, $routeParams) {
    if ($routeParams.id != null) {
        $http.get("/rest/products/" + $routeParams.id).then(resp => {
            $rootScope.formProductP = resp.data;
            console.log($rootScope.formProductP);
            $rootScope.formProduct = angular.copy($rootScope.formProductP);
            console.log($rootScope.formProduct);
            $http.get("/rest/colordetail/" + $rootScope.formProductP.id).then(resp => {
                $rootScope.colorlist = resp.data;
                console.log($rootScope.colorlist);
            });
            $http.get("/rest/dimensionDetail/" + $rootScope.formProductP.id).then(resp => {
                $rootScope.dimensionlist = resp.data;
            });
        }).catch(error => {
            alert("Lỗi");
            console.log("Error", error);
        });
    }
    $rootScope.nameFile = '';
    // upload ảnh
    var form = new FormData();
    $rootScope.imageChanged = function (files) {
        form.append('file', files[0]);
        $rootScope.nameFile = angular.copy(files[0].name);
    }
    
    $rootScope.removeColorlist = function (index) {
        if ($rootScope.formProduct.id == '') {
            $rootScope.colorlist.splice(index, 1);
            console.log($rootScope.colorlist);
        } else {
            if ($rootScope.colorlist[index].id == '') {
                $rootScope.colorlist.splice(index, 1);
                console.log($rootScope.colorlist);
            } else {
                $http.delete('/rest/colordetail/' + $rootScope.colorlist[index].id).then(resp => {
                    $rootScope.colorlist.splice(index, 1);
                    // $scope.reset();
                    // alert("Thêm mới loại sản phẩm thành công!");
                }).catch(error => {
                    alert("Lỗi xóa chi tiết màu!");
                    console.log("Error", error);
                });
            }

        }

    }
    //add list color tam thời
    $rootScope.addcolorlist = function () {
        if ($rootScope.formProduct.id == '') {
            $rootScope.colorlist.splice(0, $rootScope.colorlist.length);
            $rootScope.colors.forEach(element => {
                if (element.Selected) {
                    $rootScope.coloritemlist.color = angular.copy(element);
                    var item = angular.copy($rootScope.coloritemlist);
                    $rootScope.colorlist.push(item);
                    console.log($rootScope.colorlist);
                };
            });
        } else {
            $rootScope.colors.forEach(element => {
                if (element.Selected) {
                    $rootScope.coloritemlist.color = angular.copy(element);
                    var item = angular.copy($rootScope.coloritemlist);
                    var count = 0;
                    $rootScope.colorlist.forEach(element => {
                        if (element.color.id == item.color.id) {
                            return
                        }
                        count++;
                    })
                    if (count < $rootScope.colorlist.length) {

                    } else {
                        $rootScope.colorlist.push(item);
                        console.log($rootScope.colorlist);
                    }

                };
            });
        }
    }
    //    Thêm mới sản phẩm
    $rootScope.create = function (event) {
        $rootScope.formProduct.img = angular.copy($rootScope.nameFile);
        var item = angular.copy($rootScope.formProduct);
        var itemColor = angular.copy($rootScope.colorlist);
        var itemdimension = angular.copy($rootScope.dimensionlist);
        $http.post('/rest/upload/images', form, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {

            $http.post(`/rest/products`, {
                product: item,
                colorDetailList: itemColor,
                dimensionDetailList: itemdimension,
            }).then(resp => {
                $rootScope.products.push(resp.data);
                alert("Thêm mới sản phẩm thành công!");
            }).catch(error => {
                alert("Lỗi thêm mới sản phẩm!");
                console.log("Error", error);
            });
        }).catch(error => {
            alert("Lỗi upload hình ảnh");
            console.log("Error", error);
        })
    }

    $rootScope.editProduct = function (index) {
        $rootScope.formProduct = angular.copy($rootScope.products[index]);
        var item = angular.copy($rootScope.products[index]);
        console.log($rootScope.formProduct);
        console.log($rootScope.nameFile);
        $http.get("/rest/colordetail/" + item.id).then(resp => {
            $rootScope.colorlist = resp.data;
            console.log($rootScope.colorlist);
        });
        $http.get("/rest/dimensionDetail/" + item.id).then(resp => {
            $rootScope.dimensionlist = resp.data;
        });
    }

    $rootScope.update = function () {
        $rootScope.formProduct.status = angular.copy($rootScope.status);
        var item = angular.copy($rootScope.formProduct);
        var itemColor = angular.copy($rootScope.colorlist);
        var itemdimension = angular.copy($rootScope.dimensionlist);
        if ($rootScope.nameFile == '') {
            $http.put(`/rest/products`, {
                product: item,
                colorDetailList: itemColor,
                dimensionDetailList: itemdimension,
            }).then(resp => {
                $rootScope.products.push(resp.data);
                alert("Thêm mới sản phẩm thành công!");
            }).catch(error => {
                alert("Lỗi thêm mới sản phẩm!");
                console.log("Error", error);
            });
        } else {
            $rootScope.formProduct.img = angular.copy($rootScope.nameFile);
            $http.put('/rest/upload/images', form, {
                transformRequest: angular.identity,
                headers: { 'Content-Type': undefined }
            }).then(resp => {
                $http.post(`/rest/products`, {
                    product: item,
                    colorDetailList: itemColor,
                    dimensionDetailList: itemdimension,
                }).then(resp => {
                    $rootScope.products.push(resp.data);
                    alert("Thêm mới sản phẩm thành công!");
                }).catch(error => {
                    alert("Lỗi thêm mới sản phẩm!");
                    console.log("Error", error);
                });
            }).catch(error => {
                alert("Lỗi upload hình ảnh");
                console.log("Error", error);
            })
        }

    }
    
    $rootScope.removedimensionlist = function (index) {
        if ($rootScope.formProduct.id == '') {
            $rootScope.dimensionlist.splice(index, 1);
            console.log($rootScope.dimensionlist);
        } else {
            if ($rootScope.dimensionlist[index].id == '') {
                $rootScope.dimensionlist.splice(index, 1);
                console.log($rootScope.dimensionlist);
            } else {
                $http.delete('/rest/dimensionDetail/' + $rootScope.dimensionlist[index].id).then(resp => {
                    $rootScope.dimensionlist.splice(index, 1);
                    // $scope.reset();
                    // alert("Thêm mới loại sản phẩm thành công!");
                }).catch(error => {
                    alert("Error!");
                    console.log("Error", error);
                });
            }

        }

    }
    // add list dimension tạm thời
    $rootScope.adddimensionslist = function () {
        if ($rootScope.formProduct.id == '') {
            $rootScope.dimensionlist.splice(0, $rootScope.dimensionlist.length);
            if (element.Selected) {
                $rootScope.dimensionitemlist.dimension = angular.copy(element);
                var item = angular.copy($rootScope.dimensionitemlist);

                $rootScope.dimensionlist.push(item);
                console.log($rootScope.dimensionlist);

            };
        } else {
            $rootScope.dimensions.forEach(element => {
                if (element.Selected) {
                    var count = 0;
                    $rootScope.dimensionitemlist.dimension = angular.copy(element);
                    var item = angular.copy($rootScope.dimensionitemlist);
                    $rootScope.dimensionlist.forEach(element => {
                        if (element.dimension.id == item.dimension.id) {
                            return
                        }
                        count++;
                        console.log(count);
                    });
                    if (count < $rootScope.dimensionlist.length) {

                    } else {
                        $rootScope.dimensionlist.push(item);
                        console.log($rootScope.dimensionlist);
                    }

                };
            });

        }
    }

})