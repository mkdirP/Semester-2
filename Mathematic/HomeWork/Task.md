<head>
  <script src="https://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML" type="text/javascript"></script>
  <script type="text/x-mathjax-config">
    MathJax.Hub.Config({
      tex2jax: {
      skipTags: ['script', 'noscript', 'style', 'textarea', 'pre'],
      inlineMath: [['$','$']]
      }
    });
  </script>
</head>

## [MainPage](../index.md)/[Mathematics](README.md)/HomeWork

## Задание 1

Необходимо вычислить произведения матриц с помощью кода, которого вы напишите. Более того , попробуйте написать код для вычисления определителя с использованием одного из способов, которых мы рассмотрели ( будем рассматривать) на занятии.

<div align=center><img src="../pic/Task-1.png"></div>

- Matrix Multiply

```c++
#include <iostream>

using namespace std;

class Matrix {
public:
    int c, r;
    double matrix [100][100];
    
    void inputSize() {
    	printf("Program: Please input the size of matrix:(in form\"r c\")\n");
    	scanf("%d %d",&r,&c);
	}
    void inputMatrix() {
    	inputSize();
	    printf("Program: You input r=%d, c=%d, now input the matrix:\n",r,c);
	
	    for (int i = 0; i < r; i++) {
	        for (int j = 0; j < c; j++) {
	            scanf("%lf", &matrix[i][j]);
	        }
	    }
	}
    void printMatrix() {
    	
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				printf("%8.2lf ", matrix[i][j]);
			}
			printf("\n");
		}
	}
    Matrix multiply(Matrix matrix) {
    	Matrix result;
		result.r = this->r;
		result.c = matrix.c;
		if (this->c == matrix.r) {
			for (int i = 0; i < result.r; i++) {
				for (int j = 0; j < result.c; j++) {
					result.matrix[i][j] = 0;
					for (int k = 0; k < matrix.r; k++) {
						result.matrix[i][j] += this->matrix[i][k] * matrix.matrix[k][j];
					}
				}
			}
		} else {
			printf("Error\n");
		}
		return result;
	}
	
};

void run() {
	Matrix matrix1;
    Matrix matrix2;

    matrix1.inputMatrix();
    matrix2.inputMatrix();
    
    Matrix matrix3;
	matrix3 = matrix1.multiply(matrix2);
	
    printf("Program: The product of matrix1 and matrix2 is:\n");
    matrix3.printMatrix();
    
    printf("\n");
    system("pause");
}
int main() {

    printf("Matrix Multiply version 1.0\n");
    printf("By: Zhou HongXiang P32131\n\n");
    
    while (true) {
    	run();
	}

    return 0;
}
```

- Determinant Calculate

```c++
#include <iostream>

using namespace std;

class Determinant {
public:
	int n;
	double det[100][100];
	double value;
	int sign = 1;
	
	void inputSize() {
    	printf("Program: Please input the size of determinant:\n");
    	scanf("%d",&n);
	}
    void inputDet() {
    	inputSize();
	    printf("Program: You input n=%d, now input the determinant:\n",n);
	
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            scanf("%lf", &det[i][j]);
	        }
	    }
	}
    void printDet() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				printf("%6.2lf ", det[i][j]);
			}
			printf("\n");
		}
	}
	void swabCol(int r, int c) {
		for (int i = 0; i < n; i++)	{
			det[i][r] += det[i][c];
			det[i][c] = det[i][r] - det[i][c];
			det[i][r] -= det[i][c];
		}
		sign = -sign;
	}
	void calValue() {
		for (int i = 0; i < n-1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (det[i][j] != 0) {
					if (det[i][i] == 0) {
						swabCol(i,j);
					}
					double div = det[i][j]/det[i][i];
					for (int k = i; k < n; k++) {
						det[k][j] = det[k][j] - div * det[k][i];
					}
				}
			}
		}
		
		value = sign * det[0][0];
		for (int i = 1; i < n; i++) {
			value *= det[i][i];
		}
	}
};

void run() {
	Determinant det;

    det.inputDet();
    printf("Program: The original determinant:\n");
    det.printDet();
    det.calValue();
    printf("Program: The triangle determinant:\n");
    det.printDet();
	
    printf("Program: The value of determinant is: %.2lf\n", det.value);
    
    printf("\n");
    system("pause");
}

int main() {
	printf("Determinant Calculator version 1.0\n");
    printf("By: Zhou HongXiang P32131\n\n");
	
	while (true) {
		run();
	}
	return 0;
}
```

## Задание 2

### 3.91

Найти значеник многочлена $f(A)$ от матртиц $A$:

$$f(x)=x^2-3x+1, A=
\begin{pmatrix}
    2 & 1\\
    0 & 3\\
\end{pmatrix}$$

**Решение**

$$x^2=\begin{pmatrix}
    2 & 1\\
    0 & 3\\
\end{pmatrix}\cdot
\begin{pmatrix}
    2 & 1\\
    0 & 3\\
\end{pmatrix}=
\begin{pmatrix}
    4 & 5\\
    0 & 9\\
\end{pmatrix}$$

$$-3x=\begin{pmatrix}
    -6 & -3\\
    0 & -9\\
\end{pmatrix}$$

$$1=E=\begin{pmatrix}
    1 & 0\\
    0 & 1\\
\end{pmatrix}$$

$$f(A)=x^2-3x+1=
\begin{pmatrix}
    -1 & 2\\
    0 & 1\\
\end{pmatrix}$$

### 3.14

Вычислить определители 3-го порядка:

$$\begin{vmatrix}
    a+x & x & x\\
    x & b+x & x\\
    x & x & c+x\\
\end{vmatrix}$$

**Решение**

$$\det =（a+x)(b+x)(c+x)+x^3+x^3-(b+x)x^2-(a+x)x^2-(c+x)x^2$$

### 3.109

Методом присоединенной матрицы найти абратные для следующих матриц:

$$A=\begin{pmatrix}
    2 & 5 & 7\\
    6 & 3 & 4\\
    5 & -2 & -3\\
\end{pmatrix}$$

**Решение**

$$\begin{vmatrix}
    A
\end{vmatrix}=-1$$

$$A_{11}=\begin{pmatrix}
    3 & 4\\
    -2 & -3\\
\end{pmatrix}=-1\quad
A_{12}\begin{pmatrix}
    6 & 4\\
    5 & -3\\
\end{pmatrix}=-38\quad
A_{13}=\begin{pmatrix}
    6 & 3\\
    5 & -2\\
\end{pmatrix}=-27$$

$$A_{21}=\begin{pmatrix}
    5 & 7\\
    -2 & -3\\
\end{pmatrix}=-1\quad
A_{22}\begin{pmatrix}
    2 & 7\\
    5 & -3\\
\end{pmatrix}=-41\quad
A_{23}=\begin{pmatrix}
    2 & 5\\
    5 & -2
\end{pmatrix}=-29$$

$$A_{31}=\begin{pmatrix}
    5 & 7\\
    3 & 4\\
\end{pmatrix}=-1\quad
A_{32}\begin{pmatrix}
    2 & 7\\
    6 & 4\\
\end{pmatrix}=-34\quad
A_{33}=\begin{pmatrix}
    2 & 5\\
    6 & 3\\
\end{pmatrix}=-24$$

$$A^*=\begin{pmatrix}
    A_{11} & A_{12} & A_{13}\\
    A_{21} & A_{22} & A_{23}\\
    A_{31} & A_{32} & A_{33}\\
\end{pmatrix}\\
=\begin{pmatrix}
    -1 & -1 & -1\\
    -38 & -41 & -34\\
    -27 & -29 & -24\\
\end{pmatrix}$$

$$A^{-1}=\frac{1}{\lvert A\rvert}A^*=
\begin{pmatrix}
    1 & 1 & 1\\
    38 & 41 & 34\\
    27 & 29 & 24\\
\end{pmatrix}$$

### 3.116

Методом элементных преобразований найти абратные для следующих матриц:

$$A=\begin{pmatrix}
    1 & 1 & 1 & 1\\
    1 & 1 & -1 & -1\\
    1 & -1 & 1 & -1\\
    1 & -1 & -1 & 1\\
\end{pmatrix}$$

**Решение**

$$\begin{pmatrix}
    1 & 1 & 1 & 1 & \vert & 1 & 0 & 0 & 0\\
    1 & 1 & -1 & -1 & \vert & 0 & 1 & 0 & 0\\
    1 & -1 & 1 & -1 & \vert & 0 & 0 & 1 & 0\\
    1 & -1 & -1 & 1 & \vert & 0 & 0 & 0 & 1\\
\end{pmatrix}=\\
\begin{pmatrix}
    1 & 0 & 0 & 0 & \vert & \frac{1}{4} & \frac{1}{4} & \frac{1}{4} & \frac{1}{4}\\
    0 & 1 & 0 & 0 & \vert & \frac{1}{4} & \frac{1}{4} & -\frac{1}{4} & -\frac{1}{4}\\
    0 & 0 & 1 & 0 & \vert & \frac{1}{4} & -\frac{1}{4} & \frac{1}{4} & -\frac{1}{4}\\
    0 & 0 & 0 & 1 & \vert & \frac{1}{4} & -\frac{1}{4} & -\frac{1}{4} & \frac{1}{4}\\
\end{pmatrix}$$

$$A^T=\begin{pmatrix}
    \frac{1}{4} & \frac{1}{4} & \frac{1}{4} & \frac{1}{4}\\
    \frac{1}{4} & \frac{1}{4} & -\frac{1}{4} & -\frac{1}{4}\\
    \frac{1}{4} & -\frac{1}{4} & \frac{1}{4} & -\frac{1}{4}\\
    \frac{1}{4} & -\frac{1}{4} & -\frac{1}{4} & \frac{1}{4}\\
\end{pmatrix}$$

### 3.123

Решить матричные уравнения:

$$\begin{pmatrix}
    3 & -1\\
    5 & -2\\
\end{pmatrix}\cdot X\cdot
\begin{pmatrix}
    5 & 6\\
    7 & 8\\
\end{pmatrix}=
\begin{pmatrix}
    14 & 16\\
    9 & 10\\
\end{pmatrix}$$

**Решение**

$$X=\begin{pmatrix}
    14 & 16\\
    9 & 10\\
\end{pmatrix}\cdot
\begin{pmatrix}
    3 & -1\\
    5 & -2\\
\end{pmatrix}^{-1}\cdot
\begin{pmatrix}
    5 & 6\\
    7 & 8\\
\end{pmatrix}^{-1}\\
=\begin{pmatrix}
    14 & 16\\
    9 & 10\\
\end{pmatrix}\cdot
\begin{pmatrix}
    2 & -1\\
    5 & -3\\
\end{pmatrix}\cdot
\begin{pmatrix}
    -4 & 3\\
    \frac{7}{2} & -\frac{5}{2}\\
\end{pmatrix}\\
=\begin{pmatrix}
    -649 & 479\\
    -\frac{817}{2} & \frac{603}{2}
\end{pmatrix}$$

## Задание 3

### 3.156

Чему равен ранг матрицы $A$ при различных значениях $\lambda$?

$$A=\begin{pmatrix}
    3 & 1 & 1 & 4\\
    \lambda & 4 & 10 & 1\\
    1 & 7 & 17 & 3\\
    2 & 2 & 4 & 3\\
\end{pmatrix}$$

**Решение**

$$\begin{pmatrix}
    3 & 1 & 1 & 4\\
    \lambda & 4 & 10 & 1\\
    1 & 7 & 17 & 3\\
    2 & 2 & 4 & 3\\
\end{pmatrix}\sim
\begin{pmatrix}
    1 & 7 & 17 & 3\\
    \lambda & 4 & 10 & 1\\
    3 & 1 & 1 & 4\\
    2 & 2 & 4 & 3\\
\end{pmatrix}\\
\sim\begin{pmatrix}
    1 & 7 & 17 & 3\\
    0 & 4-7\lambda & 10-17\lambda & 1-3\lambda\\
    0 & -20 & -50 & -5\\
    0 & -12 & -30 &-3\\
\end{pmatrix}\\
\sim\begin{pmatrix}
    1 & 7 & 17 & 3\\
    0 & -20 & -50 & -5\\
    0 & 4-7\lambda & 10-17\lambda & 1-3\lambda\\
    0 & -12 & -30 &-3\\
\end{pmatrix}\\
\sim\begin{pmatrix}
    1 & 7 & 17 & 3\\
    0 & -20 & -50 & -5\\
    0 & 0 & \frac{\lambda}{2} & -\frac{5\lambda}{4}\\
    0 & -12 & -30 &-3\\
\end{pmatrix}\\
\sim\begin{pmatrix}
    1 & 7 & 17 & 3\\
    0 & -20 & -50 & -5\\
    0 & 0 & \frac{\lambda}{2} & -\frac{5\lambda}{4}\\
    0 & 0 & 0 & 0\\
\end{pmatrix}$$

если $\lambda=0$, то $rank(A)=2$

если $\lambda\neq0$, то $rank(A)=3$

### 3.157

Чему равен ранг матрицы $A$ при различных значениях $\lambda$?

$$A=\begin{pmatrix}
    1 & \lambda & -1 & 2\\
    2 & -1 & \lambda & 5\\
    1 & 10 & -6 & \lambda\\
\end{pmatrix}$$

**Решение**

$$\begin{pmatrix}
    1 & \lambda & -1 & 2\\
    2 & -1 & \lambda & 5\\
    1 & 10 & -6 & \lambda\\
\end{pmatrix}\sim
\begin{pmatrix}
    1 & \lambda & -1 & 2\\
    0 & -1-2\lambda & 2+\lambda & 1\\
    0 & 10-\lambda & -5 & -2+\lambda\\
\end{pmatrix}\\
\sim\begin{pmatrix}
    1 & \lambda & -1 & 2\\
    0 & -1-2\lambda & 2+\lambda & 1\\
    0 & 0 & -\frac{\lambda^2+2\lambda-15}{2\lambda+1} & 2\frac{\lambda^2-2\lambda+4}{2\lambda+1}\\
\end{pmatrix}$$

$rank(A)=3$

### 3.161

Вычислить ранг матрицы методом элементарных преоброзаваний:

$$\begin{pmatrix}
    24 & 19 & 36 & 72 & -38\\
    49 & 40 & 73 & 147 & -80\\
    73 & 59 & 98 & 219 & -118\\
    47 & 36 & 71 & 141 & -72\\
\end{pmatrix}$$

**Решение**

$$\begin{pmatrix}
    24 & 19 & 36 & 72 & -38\\
    49 & 40 & 73 & 147 & -80\\
    73 & 59 & 98 & 219 & -118\\
    47 & 36 & 71 & 141 & -72\\
\end{pmatrix}\sim
\begin{pmatrix}
    73 & 59 & 98 & 219 & -118\\
    49 & 40 & 73 & 147 & -80\\
    24 & 19 & 36 & 72 & -38\\
    47 & 36 & 71 & 141 & -72\\
\end{pmatrix}\\
\sim\begin{pmatrix}
    73 & 59 & 98 & 219 & -118\\
    0 & \frac{29}{73} & \frac{527}{73} & 0 & -\frac{58}{73}\\
    0 & -\frac{29}{73} & \frac{276}{73} & 0 & \frac{58}{73}\\
    0 & -\frac{145}{73} & \frac{577}{73} & 0 & \frac{290}{73}\\
\end{pmatrix}\sim
\begin{pmatrix}
    73 & 59 & 98 & 219 & -118\\
    0 & -\frac{145}{73} & \frac{577}{73} & 0 & \frac{290}{73}\\
    0 & 0 & \frac{44}{5} & 0 & 0\\
    0 & 0 & \frac{11}{5} & 0 & 0\\
\end{pmatrix}\\
\sim\begin{pmatrix}
    73 & 59 & 98 & 219 & -118\\
    0 & -\frac{145}{73} & \frac{577}{73} & 0 & \frac{290}{73}\\
    0 & 0 & \frac{44}{5} & 0 & 0\\
    0 & 0 & 0 & 0 & 0\\
\end{pmatrix}\\
rank\begin{pmatrix}
    24 & 19 & 36 & 72 & -38\\
    49 & 40 & 73 & 147 & -80\\
    73 & 59 & 98 & 219 & -118\\
    47 & 36 & 71 & 141 & -72\\
\end{pmatrix}=rank
\begin{pmatrix}
    73 & 59 & 98 & 219 & -118\\
    0 & -\frac{145}{73} & \frac{577}{73} & 0 & \frac{290}{73}\\
    0 & 0 & \frac{44}{5} & 0 & 0\\
    0 & 0 & 0 & 0 & 0\\
\end{pmatrix}=3$$

### 3.180

Найти все значения $\lambda$, при которых вектор $x$ линейно выражается через векторы $a_1,a_2,a_3$

$$a_1=(3,2,6)\\
a_2=(7,3,9)\\
a_3=(5,1,3)\\
x=(\lambda,2,5)$$

**Решение**

$$A=\begin{pmatrix}
    3 & 7 & 5 & \lambda\\
    2 & 3 & 1 & 2\\
    6 & 9 & 3 & 5\\
\end{pmatrix}\sim
\begin{pmatrix}
    6 & 9 & 3 & 5\\
    0 & \frac{5}{2} & \frac{7}{2} & \lambda-\frac{5}{2}\\
    0 & 0 & 0 & \frac{1}{3}\\
\end{pmatrix}
$$

то есть,

$$\begin{cases}
    6x_1+9x_2+3x_3=5\\
    \frac{5}{2}x_2+\frac{7}{2}x_3=\lambda-\frac{5}{2}\\
    0=\frac{1}{3}\\
\end{cases}$$

нет решения

### 3.209

Исследовать совместность и найти общее решение следуюших систем:

$$\begin{cases}
    x_1+x_2-6x_3-4x_4=6\\
    3x_1-x_2-6x_3-4x_4=2\\
    2x_1+3x_2+9x_3+2x_4=6\\
    3x_1+2x_2+3x_3+8x_4=-7\\
\end{cases}$$

**Решение**

$$\begin{pmatrix}
    1 & 1 & -6 & -4 & 6\\
    3 & -1 & -6 & -4 & 2\\
    2 & 3 & 9 & 2 & 6\\
    3 & 2 & 3 & 8 & -7\\
\end{pmatrix}\sim
\begin{pmatrix}
    1 & 1 & -6 & -4 & 6\\
    0 & 1 & 21 & 10 & -6\\
    0 & 0 & 96 & 48 & -40\\
    0 & 0 & 0 & 9 & -\frac{27}{2}\\
\end{pmatrix}\\
\begin{cases}
    x_1+x_2-6x_3-4x_4=6\\
    x_2+21x_3+10x_4=-6\\
    96x_3+48x_4=-40\\
    9x_4=-\frac{27}{2}
\end{cases}\Rightarrow
\begin{cases}
    x_1=0\\
    x_2=2\\
    x_3=\frac{1}{3}\\
    x_4=-\frac{3}{2}
\end{cases}$$

### 3.197*

$$f_j(x_i)=\delta_{ij},i,j=1,2,3, \delta_{ij}=\begin{cases}
    1,\ i=j\\
    0,\ i\neq j\\
\end{cases}$$