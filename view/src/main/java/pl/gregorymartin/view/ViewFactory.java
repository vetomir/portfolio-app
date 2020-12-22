package pl.gregorymartin.view;

import pl.gregorymartin.view.dto.HeaderReadModel;
import pl.gregorymartin.view.dto.HeaderWriteModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ViewFactory {
    public static List<HeaderItem> toHeaderItem(List<HeaderWriteModel> headerWriteModels) {
        return headerWriteModels.stream()
                .map(ViewFactory::toHeaderItem)
                .collect(Collectors.toList());
    }

    public static HeaderItem toHeaderItem(HeaderWriteModel headerWriteModels) {
        HeaderItem headerItem = new HeaderItem();
        headerItem.setProjectId(headerWriteModels.getProjectId());
        headerItem.setPriority(headerWriteModels.getPriority());
        headerItem.setBackground(headerWriteModels.getBackground());
        headerItem.setStyle(headerWriteModels.getStyle());

        return headerItem;
    }

    public static List<HeaderReadModel> headerItemToDto(List<HeaderItem> projects) {
        if (projects != null) {
            return projects.stream()
                    .map(ViewFactory::headerItemToDto)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public static HeaderReadModel headerItemToDto(HeaderItem headerItem) {
        return HeaderReadModel.builder()
                .id(headerItem.getId())
                .background(headerItem.getBackground())
                .projectId(headerItem.getProjectId())
                .priority(headerItem.getPriority())
                .style(headerItem.getStyle())
                .build();
    }
}
