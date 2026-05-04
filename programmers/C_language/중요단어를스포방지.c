#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

int solution(const char* message, int** spoiler_ranges, size_t spoiler_ranges_rows, size_t spoiler_ranges_cols) {
    int i = 0;

    // 스포 아닌 구간에서 등장한 단어
    char normal_words[20000][21];
    int normal_count = 0;

    // 이미 중요 단어로 인정된 단어
    char important_words[20000][21];
    int important_count = 0;

    // 1차 루프: normal_words 수집

    while (message[i] != '\0') {

        if (message[i] == ' ') {
            i++;
            continue;
        }

        int start = i;

        while (message[i] != ' ' && message[i] != '\0') {
            i++;
        }

        int end = i - 1;

        char word[21];
        int len = end - start + 1;
        strncpy(word, message + start, len);
        word[len] = '\0';

        bool isSpoiler = false;

        for (int j = 0; j < spoiler_ranges_rows; j++) {
            int s = spoiler_ranges[j][0];
            int e = spoiler_ranges[j][1];

            if (!(end < s || start > e)) {
                isSpoiler = true;
                break;
            }
        }

        if (!isSpoiler) {
            strcpy(normal_words[normal_count++], word);
        }
    }


    //  2차 루프: 중요 단어 판별

    int answer = 0;
    i = 0;

    while (message[i] != '\0') {

        if (message[i] == ' ') {
            i++;
            continue;
        }

        int start = i;

        while (message[i] != ' ' && message[i] != '\0') {
            i++;
        }

        int end = i - 1;

        char word[21];
        int len = end - start + 1;
        strncpy(word, message + start, len);
        word[len] = '\0';

        // 스포 여부
        bool isSpoiler = false;

        for (int j = 0; j < spoiler_ranges_rows; j++) {
            int s = spoiler_ranges[j][0];
            int e = spoiler_ranges[j][1];

            if (!(end < s || start > e)) {
                isSpoiler = true;
                break;
            }
        }

        if (!isSpoiler) continue;

        // ❗ normal_words에 있으면 탈락
        bool appeared_normal = false;

        for (int k = 0; k < normal_count; k++) {
            if (strcmp(normal_words[k], word) == 0) {
                appeared_normal = true;
                break;
            }
        }

        if (appeared_normal) continue;

        // ❗ 이미 중요한 단어면 제외
        bool already_important = false;

        for (int k = 0; k < important_count; k++) {
            if (strcmp(important_words[k], word) == 0) {
                already_important = true;
                break;
            }
        }

        if (already_important) continue;

        // ✅ 중요 단어
        strcpy(important_words[important_count++], word);
        answer++;
    }

    return answer;
}