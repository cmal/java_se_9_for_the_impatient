package geeksforgeeks;
// Java Program to find
// covariance of two set.
import java.io.*;

class Cov {

// Function to find mean.
static float mean(float arr[], int n)
{
    float sum = 0;

    for(int i = 0; i < n; i++)
        sum = sum + arr[i];

    return sum / n;
}

// Function to find covariance.
static float covariance(float arr1[],
                    float arr2[], int n)
{
    float sum = 0;

    for(int i = 0; i < n; i++)
        sum = sum + (arr1[i] - mean(arr1, n)) *
                        (arr2[i] - mean(arr2, n));
    return sum / (n - 1);
}

// Driver code
    public static void main (String[] args) {

    // float arr1[] = {65.21f, 64.75f,
    //                 65.26f, 65.76f, 65.96f};
    float arr1[] = {5, 20, 40, 80, 100};
    int n = arr1.length;

    // float arr2[] = {67.25f, 66.39f,
    //                 66.12f, 65.70f, 66.64f};
    float arr2[] = {10, 24, 33, 54, 10};

    int m = arr2.length;

    if (m == n)
        System.out.println(covariance(arr1, arr2, m));

    }
}

// This code is contributed by Gitanjali.
