  app.directive('checkRepeat', ['$log', function($log) {
      return {
          restrict: 'A',
          require: 'ngModel',
          link: function($scope, $element, $attrs, $ngModelCtrl) {
              var verifyRule = [/^\d+$/, /^[a-z]+$/, /^[A-Z]+$/];
              var verify = function(input) {
                  return !(verifyRule[0].test(input) || 
                           verifyRule[1].test(input) || 
                           verifyRule[2].test(input));
              };
              $ngModelCtrl.$parsers.push(function(input) {
                  var validity = verify(input);
                  $ngModelCtrl.$setValidity('defined', validity);
                  return validity ? input : false;
              });
              $ngModelCtrl.$formatters.push(function(input) {
                  var validity = verify(input);
                  $ngModelCtrl.$setValidity('defined', validity);
                  return validity ? input : false;
              })
          }
      }
    }]);