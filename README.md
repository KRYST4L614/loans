
<img src="https://github.com/user-attachments/assets/2227660a-9a9b-498c-a281-aad01b974650" width="40" height="40" />
![register](https://github.com/user-attachments/assets/fc2cc672-299c-4a7b-b474-76791f4960aa)
![login_error](https://github.com/user-attachments/assets/e1b0227b-0f9e-45f1-9b02-5605229dc2d6)
![register_error](https://github.com/user-attachments/assets/78bcdf30-e656-4565-8471-6cc4cc4b584b)
![host_error](https://github.com/user-attachments/assets/08d36877-4790-48f4-822e-e72af5f366da)


Приложение для оформления микрозаймов.
Типичный сценарий: Пользователь регистрируется в приложении, после чего осуществляет вход. 
Видит информацию, поясняющую что ему делать далее. 
Поняв, как все работает, пользователь оформляет заявку на займ, указав необходимые данные. Если 
заявка оформлена успешно, пользователь видит экран с успехом и пояснение что ему делать дальше.
Зайдя в приложение повторно пользователь видит список оформленных займов и их статусы. Он 
может перейти в каждую конкретную заявку и посмотреть подробную информацию о ней.

Неавторизованный пользователь имеет возможность:
  Зарегистрироваться с уникальным именем и любым паролем
  Авторизоваться
Авторизованный пользователь имеет возможность:
  Посмотреть инструкцию как оформить займ
  Оформить займ, ознакомившись с текущими условиями и указав необходимые данные
  Увидеть информацию о том, что займ успешно оформлен
  Видеть историю оформленных займов с актуальным статусом займа
  Обновлять историю оформленных займов
  При выборе займа в истории видеть детальную информацию о нём, а также инструкцию как его 
    получить в банке / оформить на карту
  Видеть необходимую информацию о произошедших ошибках
  Не вводить заново логин и пароль при повторном открытии приложения

Стек использованных технологий:
  Clean Architecture
  MVVM
  Вертикальная многомодульность (по feature)
  Dagger2
  Retrofit2
  Facebook Shimmer
  Coroutines
  LiveData
  Views
