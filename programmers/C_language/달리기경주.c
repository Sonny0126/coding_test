#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

#define HASH_SIZE 100003

typedef struct Node {
    char name[11];
    int idx;
    struct Node* next;
} Node;

Node* hashTable[HASH_SIZE];

// 해시 함수
unsigned int hash(const char* str) {

    unsigned int h = 5381;

    while(*str) {
        h = ((h << 5) + h) + (*str);
        str++;
    }

    return h % HASH_SIZE;
}

// 이름 저장
void insert(const char* name, int idx) {

    unsigned int h = hash(name);

    Node* newNode = (Node*)malloc(sizeof(Node));

    strcpy(newNode->name, name);

    newNode->idx = idx;

    newNode->next = hashTable[h];

    hashTable[h] = newNode;
}

// 인덱스 찾기
Node* find(const char* name) {

    unsigned int h = hash(name);

    Node* cur = hashTable[h];

    while(cur) {

        if(strcmp(cur->name, name) == 0) {
            return cur;
        }

        cur = cur->next;
    }

    return NULL;
}

// players_len은 배열 players의 길이입니다.
// callings_len은 배열 callings의 길이입니다.
char** solution(
    const char* players[],
    size_t players_len,
    const char* callings[],
    size_t callings_len
) {

    // 결과 배열
    char** answer = (char**)malloc(sizeof(char*) * players_len);

    // 초기화
    for(int i = 0; i < HASH_SIZE; i++) {
        hashTable[i] = NULL;
    }

    // 선수 복사 + 해시 저장
    for(int i = 0; i < players_len; i++) {

        answer[i] = (char*)malloc(strlen(players[i]) + 1);

        strcpy(answer[i], players[i]);

        insert(players[i], i);
    }

    for(int i = 0; i < callings_len; i++) {

        const char* called = callings[i];

        // 현재 선수 정보
        Node* curPlayer = find(called);

        int idx = curPlayer->idx;

        // 앞 선수
        char* frontPlayer = answer[idx - 1];

        Node* frontNode = find(frontPlayer);

        // swap
        answer[idx - 1] = answer[idx];

        answer[idx] = frontPlayer;

        // 인덱스 갱신
        curPlayer->idx--;

        frontNode->idx++;
    }

    return answer;
}