# coding:utf-8


class TestClass(object):
    def hello(self, list):
        self.list = list
        return self.change(list)

    def change(self, list):
        self.list[3] = 4
        return self.list


if __name__ == '__main__':
    print TestClass().hello([2,3,4,3,2,2])
