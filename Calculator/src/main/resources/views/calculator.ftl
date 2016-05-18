<html>
    <head>
        <link rel="stylesheet" href="/css/main.css" />
        <script>
            function addValue(value) {
                var result = document.getElementById("expression");
                result.value += value;
            }

            function removeValue() {
                var result = document.getElementById("expression");
                var newValue = result.value.substring(0, result.value.length - 1);
                result.value = newValue;
            }
            function equal() {
                var result = document.getElementById("expression").value;
                var xhr = new XMLHttpRequest();
                var params = 'expression=' + encodeURIComponent(result);
                xhr.open('POST', 'Calculator?'+params, true);
                xhr.send();

                xhr.onreadystatechange = function() {
                    if (xhr.readyState != 4) return;
                    if (xhr.status != 200) {
                        alert(xhr.status + ': ' + xhr.statusText);
                        console.log(xhr.status + ': ' + xhr.statusText);
                    } else {
                        console.log(xhr.responseText);
                        var response = JSON.parse(xhr.responseText);
                        var resultInput = document.getElementById("expression");
                        resultInput.value = response.result;
                    }
                };

                console.log(result);
            }

        </script>
    </head>
    <body>
        <h1 style="text-align: center;">Calculator</h1>

            <form>
            <p align="center"><b><input id="expression" maxlength="200" name="expression" size="50" type="text" ></b>&nbsp;
            </form>

        <table border="1" align="center">
            <tr>
                <th><input name="btn_8" type="submit" value=" 7 " onclick="addValue(7)"></th>
                <th><input name="btn_8" type="submit" value=" 8 " onclick="addValue(8)"></th>
                <th><input name="btn_9" type="submit" value=" 9 " onclick="addValue(9)"></th>
                <th><input name="btn_power" type="submit" value=" ^ " onclick="addValue('^')"></th>
                <th><input name="btn_del" type="submit" value=" Del " onclick="removeValue()"></th>
            </tr>
            <tr>
                <th><input name="btn_4" type="submit" value=" 4 " onclick="addValue(4)"></th>
                <th><input name="btn_5" type="submit" value=" 5 " onclick="addValue(5)"></th>
                <th><input name="btn_6" type="submit" value=" 6 " onclick="addValue(6)"></th>
                <th><input name="btn_multiply" type="submit" value=" * " onclick="addValue('*')"></th>
                <th><input name="btn_divide" type="submit" value=" / " onclick="addValue(' / ')"></th>
            </tr>
            <tr>
                <th><input name="btn_1" type="submit" value=" 1 " onclick="addValue(1)"></th>
                <th><input name="btn_2" type="submit" value=" 2 " onclick="addValue(2)"></th>
                <th><input name="btn_3" type="submit" value=" 3 " onclick="addValue(3)"></th>
                <th><input name="btn_add" type="submit" value=" + " onclick="addValue('+')"></th>
                <th><input name="btn_sub" type="submit" value=" - " onclick="addValue(' - ')">
                </th>
            </tr>
            <tr>
                <th><input name="btn_point" type="submit" value=" . " onclick="addValue('.')"></th>
                <th><input name="btn_0" type="submit" value=" 0 " onclick="addValue(0)"></th>
                <th><input name="btn_result" type="submit" value=" = " onclick="equal()"></th>
                <th><input name="btn_open" type="submit" value=" ( " onclick="addValue('(')"></th>
                <th><input name="btn_close" type="submit" value=" ) " onclick="addValue(')')"></th>
            </tr>
        </table>

    </body>
</html>