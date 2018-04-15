angular.module('myPropsApp', [])
    .controller('propsController', function($scope, $http) {
        _refreshPageData();
        $scope.add = function () {
            $http({
                url: '/props/add',
                method: "GET",
                params: {propName: $scope.form["propName"],
                    propDesc: $scope.form["propDesc"],
                    type: $scope.form["type"]}
            }).then( _success, _error );
        }

        function _refreshPageData() {
            $http.get('/props/all').success(function(data) {
                $scope.properties = data;
            });
        }

        function _success(response) {
            _refreshPageData();
            $scope.propAddResponse = "Saved";
        }

        function _error(response) {
            console.log(response.statusText);
            $scope.propAddResponse = "Error: " + response.data;
        }
    });