package pl.gregorymartin.view;

import pl.gregorymartin.view.dto.HeaderReadModel;
import pl.gregorymartin.view.dto.HeaderWriteModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ViewFactory {
    public static List<pl.gregorymartin.view.HeaderItem> toHeaderItem(List<HeaderWriteModel> headerWriteModels) {
        return headerWriteModels.stream()
                .map(ViewFactory::toHeaderItem)
                .collect(Collectors.toList());
    }

    public static pl.gregorymartin.view.HeaderItem toHeaderItem(HeaderWriteModel headerWriteModels) {
        pl.gregorymartin.view.HeaderItem headerItem = new pl.gregorymartin.view.HeaderItem();
        headerItem.setProjectId(headerWriteModels.getProjectId());
        headerItem.setPriority(headerWriteModels.getPriority());
        headerItem.setBackground(headerWriteModels.getBackground());
        headerItem.setStyle(headerWriteModels.getStyle());

        return headerItem;
    }

    public static List<HeaderReadModel> headerItemToDto(List<pl.gregorymartin.view.HeaderItem> projects) {
        if (projects != null) {
            return projects.stream()
                    .map(ViewFactory::headerItemToDto)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public static HeaderReadModel headerItemToDto(pl.gregorymartin.view.HeaderItem headerItem) {
        return HeaderReadModel.builder()
                .id(headerItem.getId())
                .background(headerItem.getBackground())
                .projectId(headerItem.getProjectId())
                .priority(headerItem.getPriority())
                .style(headerItem.getStyle())
                .build();
    }
}
