angular.module('myPropsApp', [])
    .controller('propsController', function($scope, $http) {
        $scope.strategies =  [
            { label: 'by name', value: 0 },
            { label: 'by type', value: 1 },
            { label: 'by description', value: 2 },
            { label: 'by ID', value: 3 }
        ];
        _refreshPageData();
        $scope.add = function () {
            $http({
                url: '/props/add',
                method: "GET",
                params: {propName: $scope.form["propName"],
                    description: $scope.form["description"],
                    type: $scope.form["type"]}
            }).then( _success, _error );
        }

        $scope.search = function () {
            _refreshPageData();
        }

        function _refreshPageData() {
            $url = '/props/all';
            $param = '';
            if ($scope.selectedStrategy == $scope.strategies[0].value) {
                $url = '/props/searchbypropname';
                $param = {propName: $scope.search["propName"]};
            } else if ($scope.selectedStrategy == $scope.strategies[1].value) {
                $url = '/props/searchbytype';
                $param = {type: $scope.search["type"]};
            } else if ($scope.selectedStrategy == $scope.strategies[2].value) {
                $url = '/props/searchbydescription';
                $param = {description: $scope.search["description"]};
            } else if ($scope.selectedStrategy == $scope.strategies[3].value) {
                $url = '/props/searchbyid';
                $param = {id: $scope.search["id"]};
            }
            $http({
                url: $url,
                method: "GET",
                params: $param
            }).then( _success, _error );
        }


        function _success(response) {
            $scope.properties = response;
            $scope.propAddResponse = "Saved";
        }

        function _error(response) {
            console.log(response.statusText);
            $scope.propAddResponse = "Error: " + response.data;
        }
    });