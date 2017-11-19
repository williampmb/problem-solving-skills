/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uri.accepted;

/**
 *
 * @author willi
 */
public class FibonacciHowManyCalls_1029 {
    /*
    c++
    #include <iostream>
    #include <string>
    #include <vector>
    #include <stdio.h>

    using namespace std;

    int counter, call;

    int fibonacci(int n)
    {
            if (n == 0) return 0;
            if (n == 1) return 1;
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    int fibonacciCount(int n)
    {
            if (n == 0) return 1;
            if (n == 1) return 1;
            return fibonacciCount(n - 1) + fibonacciCount(n - 2) + 1;
    }

    int* fibonacciIterativelly(int n) {

            if (n == 1) {
                    int r[2];
                    r[0] = 1;
                    r[1] = 0;
                    return r;
            }

            if (n == 2) {
                    int r[2];
                    r[0] = 1;
                    r[1] = 2;
                    return r;
            }
            int n0 = 0, n1 = 1, next= 0;
            int call0=1, call1=1, callNext = 0;
            next = n0 + n1;
            callNext = call0 + call1+1;

            for(int i = 3 ; i <=n;i++)
            {
                    n0 = n1;
                    n1 = next;
                    next = n0 + n1;

                    call0 = call1;
                    call1 = callNext;
                    callNext = call0 + call1 + 1;
            }
            callNext--;

            int r[2];
            r[0] = next;
            r[1] = callNext;
            return r;
    }


    int fib(int n)

    {

            if (n == 0) {

                    call++;

                    return 0;

            }
            else if (n == 1) {

                    call++;

                    counter++;

                    return 1;

            }
            else {

                    call++;

                    return fib(n - 1) + fib(n - 2);//call recursively

            }

    }

    int main()

    {

            int n, i, x, res;

            scanf_s("%d", &n);



            for (i = 0; i < n; ++i)

            {

                    counter = 0;

                    call = 0;

                    scanf_s("%d", &x);

                    res = fib(x);

                    printf("fib(%d) = %d calls = %d\n", x, call - 1, counter);

            }


            getchar();
            getchar();
            return 0;

    }
    int main()
    {
            int times;
            int n;
            cin >> times;
            vector <string> results;

            while (times) {
                    cin >> n;

                    int* p;
                    p = fibonacciIterativelly(n);
                    int num_calls = *(p + 1);
                    int calls = *p;
                    printf("fib(%d) = %d calls = %d\n", n, num_calls, calls);
                    //string build = "fib("+to_string(n)+") = "+ to_string(num_calls)+" calls = "+ to_string(calls);
                    //results.push_back(build);
                    times--;

            }

            //for (int i = 0; i < results.size(); i++) {
            //	cout << results[i] <<endl;
            //}
            getchar();
            getchar();
            return 0;
    }


    int main()
    {
            int times;
            int n;
            cin >> times;

            while (times) {
                    cin >> n;

                    int calls = fibonacci(n);
                    int num_calls = fibonacciCount(n);
                    num_calls--;
                    printf("fib(%d) = %d calls = %d\n", n, num_calls, calls);

                    times--;

            }

            getchar();
            getchar();
            return 0;
    }
    
    */
}
