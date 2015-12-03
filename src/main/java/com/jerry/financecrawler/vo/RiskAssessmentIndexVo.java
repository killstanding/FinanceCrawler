package com.jerry.financecrawler.vo;

/**
 * Created by Jerry on 15/11/24.
 * 风险评估指标
 */
public class RiskAssessmentIndexVo {
    private AnnualizedReturnRateVo annualizedReturnRateVo;//年化收益率
    private AnnualFluctuationRateVo annualFluctuationRateVo;//年化波动率
    private MaximumReturnVo maximumReturnVo; //最大回撤
    private SharpRatioVo sharpRatioVo;//夏普比率
    private CalmarRatioVo calmarRatioVo;//CALMAR比率
    private SterlingRatioVo sterlingRatioVo;//Sterling比率

    public AnnualizedReturnRateVo getAnnualizedReturnRateVo() {
        return annualizedReturnRateVo;
    }

    public void setAnnualizedReturnRateVo(AnnualizedReturnRateVo annualizedReturnRateVo) {
        this.annualizedReturnRateVo = annualizedReturnRateVo;
    }

    public AnnualFluctuationRateVo getAnnualFluctuationRateVo() {
        return annualFluctuationRateVo;
    }

    public void setAnnualFluctuationRateVo(AnnualFluctuationRateVo annualFluctuationRateVo) {
        this.annualFluctuationRateVo = annualFluctuationRateVo;
    }

    public MaximumReturnVo getMaximumReturnVo() {
        return maximumReturnVo;
    }

    public void setMaximumReturnVo(MaximumReturnVo maximumReturnVo) {
        this.maximumReturnVo = maximumReturnVo;
    }

    public SharpRatioVo getSharpRatioVo() {
        return sharpRatioVo;
    }

    public void setSharpRatioVo(SharpRatioVo sharpRatioVo) {
        this.sharpRatioVo = sharpRatioVo;
    }

    public CalmarRatioVo getCalmarRatioVo() {
        return calmarRatioVo;
    }

    public void setCalmarRatioVo(CalmarRatioVo calmarRatioVo) {
        this.calmarRatioVo = calmarRatioVo;
    }

    public SterlingRatioVo getSterlingRatioVo() {
        return sterlingRatioVo;
    }

    public void setSterlingRatioVo(SterlingRatioVo sterlingRatioVo) {
        this.sterlingRatioVo = sterlingRatioVo;
    }

    @Override
    public String toString() {
        return "RiskAssessmentIndexVo{" +
                "annualizedReturnRateVo=" + annualizedReturnRateVo +
                ", annualFluctuationRateVo=" + annualFluctuationRateVo +
                ", maximumReturnVo=" + maximumReturnVo +
                ", sharpRatioVo=" + sharpRatioVo +
                ", calmarRatioVo=" + calmarRatioVo +
                ", sterlingRatioVo=" + sterlingRatioVo +
                '}';
    }
}
