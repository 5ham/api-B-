package util;

public class PagingUtil {

	private int nowPage; // ����������
	private int startPage; //����������
	private int endPage; //ȭ�鿡�� �� ��������ȣ
	private int total; //�Խñ� �Ѱ���
	private int perPage; //ȭ��� �۰���
	private int lastPage; //����������
	private int start; //�������� ����� ȭ��� �� ���۹�ȣ
	private int end; // �������� ����� ȭ��� �� �����ȣ
	private int cntPage=10; //ȭ�鿡�� ������ ����¡ ����
	
	public PagingUtil() {
		
	}
	
	public PagingUtil(int total,int nowPage, int perPage) {
		//����������,�Խñ� ����,ȭ��� �Խñ� ���� �ʱ�ȭ
		setNowPage(nowPage);
		setPerPage(perPage);
		setTotal(total);
		
		//��ü�� ���� ��������ȣ ��� lastpage ���
		calcLastPage(total,perPage);
		
		//�� ȭ�鿡�� ������ ���� �������� ���� ������ ���ϱ�
		calcStartEndPage(nowPage,cntPage);
		
		//�������� ����� �� ���� ��ȣ�� ���� ��ȣ ���ϱ�
		calcStartEnd(nowPage,perPage);
	}
	
	public void calcStartEnd(int nowPage,int perPage) {
		//�� ȭ���� �Խñ� ���� ��ȣ
		int end = nowPage*perPage;
		//�� ȭ���� �Խñ� ���� ��ȣ 
		int start = end-perPage+1;
		
		setEnd(end);
		setStart(start);
		
	}
	
	public void calcStartEndPage(int nowPage, int cntPage) {
		//�� ȭ�鿡�� �������� ������ ������ ���
		int endPage = (((int)Math.ceil((double)nowPage/cntPage))*cntPage);
		
		// ���� �������� endPage���� ���� ��� endpage�� ���� ��������
		// ���� �������� ->23 �϶� ���� ���������� 30���� ��� �ǹǷ�
		// �� �������� ���� �������� ����
		if(getLastPage()<endPage) {
			setEndPage(getLastPage());
		}else {
			setEndPage(endPage);
		}
		
		//���� ������ ����ϱ�
		int startPage = (endPage-cntPage+1);
		
		if(startPage<1) {
			startPage = 1;
		}
		setStartPage(startPage);
	}
	
	public void calcLastPage(int total,int perPage) {
		//(����)�Ҽ��� �ø�(��ü �Խñ�/�� �������� �۰���)
		int lastPage = (int)Math.ceil((double)total/perPage);
		setLastPage(lastPage);
		
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
