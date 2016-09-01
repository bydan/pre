/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.cartera.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.cartera.util.RadioVenciProveConstantesFunciones;
import com.bydan.erp.cartera.util.RadioVenciProveParameterReturnGeneral;
//import com.bydan.erp.cartera.util.RadioVenciProveParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RadioVenciProveConstantesFunciones extends RadioVenciProveConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="RadioVenciProve";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RadioVenciProve"+RadioVenciProveConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RadioVenciProveHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RadioVenciProveHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RadioVenciProveConstantesFunciones.SCHEMA+"_"+RadioVenciProveConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RadioVenciProveHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RadioVenciProveConstantesFunciones.SCHEMA+"_"+RadioVenciProveConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RadioVenciProveConstantesFunciones.SCHEMA+"_"+RadioVenciProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RadioVenciProveHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RadioVenciProveConstantesFunciones.SCHEMA+"_"+RadioVenciProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RadioVenciProveConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RadioVenciProveHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RadioVenciProveConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RadioVenciProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RadioVenciProveHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RadioVenciProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RadioVenciProveConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RadioVenciProveConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RadioVenciProveConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RadioVenciProveConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Dias Vencidoss";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Dias Vencidos";
	public static final String SCLASSWEBTITULO_LOWER="Radio Venci Prove";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RadioVenciProve";
	public static final String OBJECTNAME="radiovenciprove";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="radio_venci_prove";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select radiovenciprove from "+RadioVenciProveConstantesFunciones.SPERSISTENCENAME+" radiovenciprove";
	public static String QUERYSELECTNATIVE="select "+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+".id,"+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+".version_row,"+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+".id_empresa,"+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+".id_tipo_radio_venci,"+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+".dia_desde,"+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+".dia_hasta from "+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME;//+" as "+RadioVenciProveConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RadioVenciProveConstantesFuncionesAdditional radiovenciproveConstantesFuncionesAdditional=null;
	
	public RadioVenciProveConstantesFuncionesAdditional getRadioVenciProveConstantesFuncionesAdditional() {
		return this.radiovenciproveConstantesFuncionesAdditional;
	}
	
	public void setRadioVenciProveConstantesFuncionesAdditional(RadioVenciProveConstantesFuncionesAdditional radiovenciproveConstantesFuncionesAdditional) {
		try {
			this.radiovenciproveConstantesFuncionesAdditional=radiovenciproveConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPORADIOVENCI= "id_tipo_radio_venci";
    public static final String DIADESDE= "dia_desde";
    public static final String DIAHASTA= "dia_hasta";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPORADIOVENCI= "Tipo Radio Vencimiento";
		public static final String LABEL_IDTIPORADIOVENCI_LOWER= "Tipo Radio Venci";
    	public static final String LABEL_DIADESDE= "Dia Desde";
		public static final String LABEL_DIADESDE_LOWER= "Dia Desde";
    	public static final String LABEL_DIAHASTA= "Dia Hasta";
		public static final String LABEL_DIAHASTA_LOWER= "Dia Hasta";
	
		
		
		
		
		
		
	
	public static String getRadioVenciProveLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RadioVenciProveConstantesFunciones.IDEMPRESA)) {sLabelColumna=RadioVenciProveConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RadioVenciProveConstantesFunciones.IDTIPORADIOVENCI)) {sLabelColumna=RadioVenciProveConstantesFunciones.LABEL_IDTIPORADIOVENCI;}
		if(sNombreColumna.equals(RadioVenciProveConstantesFunciones.DIADESDE)) {sLabelColumna=RadioVenciProveConstantesFunciones.LABEL_DIADESDE;}
		if(sNombreColumna.equals(RadioVenciProveConstantesFunciones.DIAHASTA)) {sLabelColumna=RadioVenciProveConstantesFunciones.LABEL_DIAHASTA;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
	
	public static String getRadioVenciProveDescripcion(RadioVenciProve radiovenciprove) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(radiovenciprove !=null/* && radiovenciprove.getId()!=0*/) {
			if(radiovenciprove.getId()!=null) {
				sDescripcion=radiovenciprove.getId().toString();
			}//radiovenciproveradiovenciprove.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRadioVenciProveDescripcionDetallado(RadioVenciProve radiovenciprove) {
		String sDescripcion="";
			
		sDescripcion+=RadioVenciProveConstantesFunciones.ID+"=";
		sDescripcion+=radiovenciprove.getId().toString()+",";
		sDescripcion+=RadioVenciProveConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=radiovenciprove.getVersionRow().toString()+",";
		sDescripcion+=RadioVenciProveConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=radiovenciprove.getid_empresa().toString()+",";
		sDescripcion+=RadioVenciProveConstantesFunciones.IDTIPORADIOVENCI+"=";
		sDescripcion+=radiovenciprove.getid_tipo_radio_venci().toString()+",";
		sDescripcion+=RadioVenciProveConstantesFunciones.DIADESDE+"=";
		sDescripcion+=radiovenciprove.getdia_desde().toString()+",";
		sDescripcion+=RadioVenciProveConstantesFunciones.DIAHASTA+"=";
		sDescripcion+=radiovenciprove.getdia_hasta().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRadioVenciProveDescripcion(RadioVenciProve radiovenciprove,String sValor) throws Exception {			
		if(radiovenciprove !=null) {
			//radiovenciproveradiovenciprove.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoRadioVenciDescripcion(TipoRadioVenci tiporadiovenci) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporadiovenci!=null/*&&tiporadiovenci.getId()>0*/) {
			sDescripcion=TipoRadioVenciConstantesFunciones.getTipoRadioVenciDescripcion(tiporadiovenci);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoRadioVenci")) {
			sNombreIndice="Tipo=  Por Tipo Radio Vencimiento";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRadioVenci(Long id_tipo_radio_venci) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_radio_venci!=null) {sDetalleIndice+=" Codigo Unico De Tipo Radio Vencimiento="+id_tipo_radio_venci.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRadioVenciProve(RadioVenciProve radiovenciprove,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosRadioVenciProves(List<RadioVenciProve> radiovenciproves,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RadioVenciProve radiovenciprove: radiovenciproves) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRadioVenciProve(RadioVenciProve radiovenciprove,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && radiovenciprove.getConCambioAuxiliar()) {
			radiovenciprove.setIsDeleted(radiovenciprove.getIsDeletedAuxiliar());	
			radiovenciprove.setIsNew(radiovenciprove.getIsNewAuxiliar());	
			radiovenciprove.setIsChanged(radiovenciprove.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			radiovenciprove.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			radiovenciprove.setIsDeletedAuxiliar(false);	
			radiovenciprove.setIsNewAuxiliar(false);	
			radiovenciprove.setIsChangedAuxiliar(false);
			
			radiovenciprove.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRadioVenciProves(List<RadioVenciProve> radiovenciproves,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RadioVenciProve radiovenciprove : radiovenciproves) {
			if(conAsignarBase && radiovenciprove.getConCambioAuxiliar()) {
				radiovenciprove.setIsDeleted(radiovenciprove.getIsDeletedAuxiliar());	
				radiovenciprove.setIsNew(radiovenciprove.getIsNewAuxiliar());	
				radiovenciprove.setIsChanged(radiovenciprove.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				radiovenciprove.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				radiovenciprove.setIsDeletedAuxiliar(false);	
				radiovenciprove.setIsNewAuxiliar(false);	
				radiovenciprove.setIsChangedAuxiliar(false);
				
				radiovenciprove.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRadioVenciProve(RadioVenciProve radiovenciprove,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			radiovenciprove.setdia_desde(0);
			radiovenciprove.setdia_hasta(0);
		}
	}		
	
	public static void InicializarValoresRadioVenciProves(List<RadioVenciProve> radiovenciproves,Boolean conEnteros) throws Exception  {
		
		for(RadioVenciProve radiovenciprove: radiovenciproves) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				radiovenciprove.setdia_desde(0);
				radiovenciprove.setdia_hasta(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaRadioVenciProve(List<RadioVenciProve> radiovenciproves,RadioVenciProve radiovenciproveAux) throws Exception  {
		RadioVenciProveConstantesFunciones.InicializarValoresRadioVenciProve(radiovenciproveAux,true);
		
		for(RadioVenciProve radiovenciprove: radiovenciproves) {
			if(radiovenciprove.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			radiovenciproveAux.setdia_desde(radiovenciproveAux.getdia_desde()+radiovenciprove.getdia_desde());			
			radiovenciproveAux.setdia_hasta(radiovenciproveAux.getdia_hasta()+radiovenciprove.getdia_hasta());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRadioVenciProve(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RadioVenciProveConstantesFunciones.getArrayColumnasGlobalesRadioVenciProve(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRadioVenciProve(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RadioVenciProveConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RadioVenciProveConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRadioVenciProve(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RadioVenciProve> radiovenciproves,RadioVenciProve radiovenciprove,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RadioVenciProve radiovenciproveAux: radiovenciproves) {
			if(radiovenciproveAux!=null && radiovenciprove!=null) {
				if((radiovenciproveAux.getId()==null && radiovenciprove.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(radiovenciproveAux.getId()!=null && radiovenciprove.getId()!=null){
					if(radiovenciproveAux.getId().equals(radiovenciprove.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRadioVenciProve(List<RadioVenciProve> radiovenciproves) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(RadioVenciProve radiovenciprove: radiovenciproves) {			
			if(radiovenciprove.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRadioVenciProve() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RadioVenciProveConstantesFunciones.LABEL_ID, RadioVenciProveConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RadioVenciProveConstantesFunciones.LABEL_VERSIONROW, RadioVenciProveConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RadioVenciProveConstantesFunciones.LABEL_IDEMPRESA, RadioVenciProveConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RadioVenciProveConstantesFunciones.LABEL_IDTIPORADIOVENCI, RadioVenciProveConstantesFunciones.IDTIPORADIOVENCI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RadioVenciProveConstantesFunciones.LABEL_DIADESDE, RadioVenciProveConstantesFunciones.DIADESDE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RadioVenciProveConstantesFunciones.LABEL_DIAHASTA, RadioVenciProveConstantesFunciones.DIAHASTA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRadioVenciProve() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RadioVenciProveConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RadioVenciProveConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RadioVenciProveConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RadioVenciProveConstantesFunciones.IDTIPORADIOVENCI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RadioVenciProveConstantesFunciones.DIADESDE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RadioVenciProveConstantesFunciones.DIAHASTA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRadioVenciProve() throws Exception  {
		return RadioVenciProveConstantesFunciones.getTiposSeleccionarRadioVenciProve(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRadioVenciProve(Boolean conFk) throws Exception  {
		return RadioVenciProveConstantesFunciones.getTiposSeleccionarRadioVenciProve(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRadioVenciProve(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RadioVenciProveConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RadioVenciProveConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RadioVenciProveConstantesFunciones.LABEL_IDTIPORADIOVENCI);
			reporte.setsDescripcion(RadioVenciProveConstantesFunciones.LABEL_IDTIPORADIOVENCI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RadioVenciProveConstantesFunciones.LABEL_DIADESDE);
			reporte.setsDescripcion(RadioVenciProveConstantesFunciones.LABEL_DIADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RadioVenciProveConstantesFunciones.LABEL_DIAHASTA);
			reporte.setsDescripcion(RadioVenciProveConstantesFunciones.LABEL_DIAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRadioVenciProve(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRadioVenciProve(RadioVenciProve radiovenciproveAux) throws Exception {
		
			radiovenciproveAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(radiovenciproveAux.getEmpresa()));
			radiovenciproveAux.settiporadiovenci_descripcion(TipoRadioVenciConstantesFunciones.getTipoRadioVenciDescripcion(radiovenciproveAux.getTipoRadioVenci()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRadioVenciProve(List<RadioVenciProve> radiovenciprovesTemp) throws Exception {
		for(RadioVenciProve radiovenciproveAux:radiovenciprovesTemp) {
			
			radiovenciproveAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(radiovenciproveAux.getEmpresa()));
			radiovenciproveAux.settiporadiovenci_descripcion(TipoRadioVenciConstantesFunciones.getTipoRadioVenciDescripcion(radiovenciproveAux.getTipoRadioVenci()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRadioVenciProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoRadioVenci.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRadioVenci.class)) {
						classes.add(new Classe(TipoRadioVenci.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRadioVenciProve(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoRadioVenci.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRadioVenci.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoRadioVenci.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRadioVenci.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRadioVenciProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RadioVenciProveConstantesFunciones.getClassesRelationshipsOfRadioVenciProve(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRadioVenciProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRadioVenciProve(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RadioVenciProveConstantesFunciones.getClassesRelationshipsFromStringsOfRadioVenciProve(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRadioVenciProve(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(RadioVenciProve radiovenciprove,List<RadioVenciProve> radiovenciproves,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RadioVenciProve radiovenciproveEncontrado=null;
			
			for(RadioVenciProve radiovenciproveLocal:radiovenciproves) {
				if(radiovenciproveLocal.getId().equals(radiovenciprove.getId())) {
					radiovenciproveEncontrado=radiovenciproveLocal;
					
					radiovenciproveLocal.setIsChanged(radiovenciprove.getIsChanged());
					radiovenciproveLocal.setIsNew(radiovenciprove.getIsNew());
					radiovenciproveLocal.setIsDeleted(radiovenciprove.getIsDeleted());
					
					radiovenciproveLocal.setGeneralEntityOriginal(radiovenciprove.getGeneralEntityOriginal());
					
					radiovenciproveLocal.setId(radiovenciprove.getId());	
					radiovenciproveLocal.setVersionRow(radiovenciprove.getVersionRow());	
					radiovenciproveLocal.setid_empresa(radiovenciprove.getid_empresa());	
					radiovenciproveLocal.setid_tipo_radio_venci(radiovenciprove.getid_tipo_radio_venci());	
					radiovenciproveLocal.setdia_desde(radiovenciprove.getdia_desde());	
					radiovenciproveLocal.setdia_hasta(radiovenciprove.getdia_hasta());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!radiovenciprove.getIsDeleted()) {
				if(!existe) {
					radiovenciproves.add(radiovenciprove);
				}
			} else {
				if(radiovenciproveEncontrado!=null && permiteQuitar)  {
					radiovenciproves.remove(radiovenciproveEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RadioVenciProve radiovenciprove,List<RadioVenciProve> radiovenciproves) throws Exception {
		try	{			
			for(RadioVenciProve radiovenciproveLocal:radiovenciproves) {
				if(radiovenciproveLocal.getId().equals(radiovenciprove.getId())) {
					radiovenciproveLocal.setIsSelected(radiovenciprove.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRadioVenciProve(List<RadioVenciProve> radiovenciprovesAux) throws Exception {
		//this.radiovenciprovesAux=radiovenciprovesAux;
		
		for(RadioVenciProve radiovenciproveAux:radiovenciprovesAux) {
			if(radiovenciproveAux.getIsChanged()) {
				radiovenciproveAux.setIsChanged(false);
			}		
			
			if(radiovenciproveAux.getIsNew()) {
				radiovenciproveAux.setIsNew(false);
			}	
			
			if(radiovenciproveAux.getIsDeleted()) {
				radiovenciproveAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRadioVenciProve(RadioVenciProve radiovenciproveAux) throws Exception {
		//this.radiovenciproveAux=radiovenciproveAux;
		
			if(radiovenciproveAux.getIsChanged()) {
				radiovenciproveAux.setIsChanged(false);
			}		
			
			if(radiovenciproveAux.getIsNew()) {
				radiovenciproveAux.setIsNew(false);
			}	
			
			if(radiovenciproveAux.getIsDeleted()) {
				radiovenciproveAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RadioVenciProve radiovenciproveAsignar,RadioVenciProve radiovenciprove) throws Exception {
		radiovenciproveAsignar.setId(radiovenciprove.getId());	
		radiovenciproveAsignar.setVersionRow(radiovenciprove.getVersionRow());	
		radiovenciproveAsignar.setid_empresa(radiovenciprove.getid_empresa());
		radiovenciproveAsignar.setempresa_descripcion(radiovenciprove.getempresa_descripcion());	
		radiovenciproveAsignar.setid_tipo_radio_venci(radiovenciprove.getid_tipo_radio_venci());
		radiovenciproveAsignar.settiporadiovenci_descripcion(radiovenciprove.gettiporadiovenci_descripcion());	
		radiovenciproveAsignar.setdia_desde(radiovenciprove.getdia_desde());	
		radiovenciproveAsignar.setdia_hasta(radiovenciprove.getdia_hasta());	
	}
	
	public static void inicializarRadioVenciProve(RadioVenciProve radiovenciprove) throws Exception {
		try {
				radiovenciprove.setId(0L);	
					
				radiovenciprove.setid_empresa(-1L);	
				radiovenciprove.setid_tipo_radio_venci(-1L);	
				radiovenciprove.setdia_desde(0);	
				radiovenciprove.setdia_hasta(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRadioVenciProve(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RadioVenciProveConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RadioVenciProveConstantesFunciones.LABEL_IDTIPORADIOVENCI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RadioVenciProveConstantesFunciones.LABEL_DIADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RadioVenciProveConstantesFunciones.LABEL_DIAHASTA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRadioVenciProve(String sTipo,Row row,Workbook workbook,RadioVenciProve radiovenciprove,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(radiovenciprove.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(radiovenciprove.gettiporadiovenci_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(radiovenciprove.getdia_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(radiovenciprove.getdia_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRadioVenciProve=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRadioVenciProve() {
		return this.sFinalQueryRadioVenciProve;
	}
	
	public void setsFinalQueryRadioVenciProve(String sFinalQueryRadioVenciProve) {
		this.sFinalQueryRadioVenciProve= sFinalQueryRadioVenciProve;
	}
	
	public Border resaltarSeleccionarRadioVenciProve=null;
	
	public Border setResaltarSeleccionarRadioVenciProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciProveBeanSwingJInternalFrame radiovenciproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//radiovenciproveBeanSwingJInternalFrame.jTtoolBarRadioVenciProve.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRadioVenciProve= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRadioVenciProve() {
		return this.resaltarSeleccionarRadioVenciProve;
	}
	
	public void setResaltarSeleccionarRadioVenciProve(Border borderResaltarSeleccionarRadioVenciProve) {
		this.resaltarSeleccionarRadioVenciProve= borderResaltarSeleccionarRadioVenciProve;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRadioVenciProve=null;
	public Boolean mostraridRadioVenciProve=true;
	public Boolean activaridRadioVenciProve=true;

	public Border resaltarid_empresaRadioVenciProve=null;
	public Boolean mostrarid_empresaRadioVenciProve=true;
	public Boolean activarid_empresaRadioVenciProve=true;
	public Boolean cargarid_empresaRadioVenciProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRadioVenciProve=false;//ConEventDepend=true

	public Border resaltarid_tipo_radio_venciRadioVenciProve=null;
	public Boolean mostrarid_tipo_radio_venciRadioVenciProve=true;
	public Boolean activarid_tipo_radio_venciRadioVenciProve=true;
	public Boolean cargarid_tipo_radio_venciRadioVenciProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_radio_venciRadioVenciProve=false;//ConEventDepend=true

	public Border resaltardia_desdeRadioVenciProve=null;
	public Boolean mostrardia_desdeRadioVenciProve=true;
	public Boolean activardia_desdeRadioVenciProve=true;

	public Border resaltardia_hastaRadioVenciProve=null;
	public Boolean mostrardia_hastaRadioVenciProve=true;
	public Boolean activardia_hastaRadioVenciProve=true;

	
	

	public Border setResaltaridRadioVenciProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciProveBeanSwingJInternalFrame radiovenciproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//radiovenciproveBeanSwingJInternalFrame.jTtoolBarRadioVenciProve.setBorder(borderResaltar);
		
		this.resaltaridRadioVenciProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRadioVenciProve() {
		return this.resaltaridRadioVenciProve;
	}

	public void setResaltaridRadioVenciProve(Border borderResaltar) {
		this.resaltaridRadioVenciProve= borderResaltar;
	}

	public Boolean getMostraridRadioVenciProve() {
		return this.mostraridRadioVenciProve;
	}

	public void setMostraridRadioVenciProve(Boolean mostraridRadioVenciProve) {
		this.mostraridRadioVenciProve= mostraridRadioVenciProve;
	}

	public Boolean getActivaridRadioVenciProve() {
		return this.activaridRadioVenciProve;
	}

	public void setActivaridRadioVenciProve(Boolean activaridRadioVenciProve) {
		this.activaridRadioVenciProve= activaridRadioVenciProve;
	}

	public Border setResaltarid_empresaRadioVenciProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciProveBeanSwingJInternalFrame radiovenciproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//radiovenciproveBeanSwingJInternalFrame.jTtoolBarRadioVenciProve.setBorder(borderResaltar);
		
		this.resaltarid_empresaRadioVenciProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRadioVenciProve() {
		return this.resaltarid_empresaRadioVenciProve;
	}

	public void setResaltarid_empresaRadioVenciProve(Border borderResaltar) {
		this.resaltarid_empresaRadioVenciProve= borderResaltar;
	}

	public Boolean getMostrarid_empresaRadioVenciProve() {
		return this.mostrarid_empresaRadioVenciProve;
	}

	public void setMostrarid_empresaRadioVenciProve(Boolean mostrarid_empresaRadioVenciProve) {
		this.mostrarid_empresaRadioVenciProve= mostrarid_empresaRadioVenciProve;
	}

	public Boolean getActivarid_empresaRadioVenciProve() {
		return this.activarid_empresaRadioVenciProve;
	}

	public void setActivarid_empresaRadioVenciProve(Boolean activarid_empresaRadioVenciProve) {
		this.activarid_empresaRadioVenciProve= activarid_empresaRadioVenciProve;
	}

	public Boolean getCargarid_empresaRadioVenciProve() {
		return this.cargarid_empresaRadioVenciProve;
	}

	public void setCargarid_empresaRadioVenciProve(Boolean cargarid_empresaRadioVenciProve) {
		this.cargarid_empresaRadioVenciProve= cargarid_empresaRadioVenciProve;
	}

	public Border setResaltarid_tipo_radio_venciRadioVenciProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciProveBeanSwingJInternalFrame radiovenciproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//radiovenciproveBeanSwingJInternalFrame.jTtoolBarRadioVenciProve.setBorder(borderResaltar);
		
		this.resaltarid_tipo_radio_venciRadioVenciProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_radio_venciRadioVenciProve() {
		return this.resaltarid_tipo_radio_venciRadioVenciProve;
	}

	public void setResaltarid_tipo_radio_venciRadioVenciProve(Border borderResaltar) {
		this.resaltarid_tipo_radio_venciRadioVenciProve= borderResaltar;
	}

	public Boolean getMostrarid_tipo_radio_venciRadioVenciProve() {
		return this.mostrarid_tipo_radio_venciRadioVenciProve;
	}

	public void setMostrarid_tipo_radio_venciRadioVenciProve(Boolean mostrarid_tipo_radio_venciRadioVenciProve) {
		this.mostrarid_tipo_radio_venciRadioVenciProve= mostrarid_tipo_radio_venciRadioVenciProve;
	}

	public Boolean getActivarid_tipo_radio_venciRadioVenciProve() {
		return this.activarid_tipo_radio_venciRadioVenciProve;
	}

	public void setActivarid_tipo_radio_venciRadioVenciProve(Boolean activarid_tipo_radio_venciRadioVenciProve) {
		this.activarid_tipo_radio_venciRadioVenciProve= activarid_tipo_radio_venciRadioVenciProve;
	}

	public Boolean getCargarid_tipo_radio_venciRadioVenciProve() {
		return this.cargarid_tipo_radio_venciRadioVenciProve;
	}

	public void setCargarid_tipo_radio_venciRadioVenciProve(Boolean cargarid_tipo_radio_venciRadioVenciProve) {
		this.cargarid_tipo_radio_venciRadioVenciProve= cargarid_tipo_radio_venciRadioVenciProve;
	}

	public Border setResaltardia_desdeRadioVenciProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciProveBeanSwingJInternalFrame radiovenciproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//radiovenciproveBeanSwingJInternalFrame.jTtoolBarRadioVenciProve.setBorder(borderResaltar);
		
		this.resaltardia_desdeRadioVenciProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardia_desdeRadioVenciProve() {
		return this.resaltardia_desdeRadioVenciProve;
	}

	public void setResaltardia_desdeRadioVenciProve(Border borderResaltar) {
		this.resaltardia_desdeRadioVenciProve= borderResaltar;
	}

	public Boolean getMostrardia_desdeRadioVenciProve() {
		return this.mostrardia_desdeRadioVenciProve;
	}

	public void setMostrardia_desdeRadioVenciProve(Boolean mostrardia_desdeRadioVenciProve) {
		this.mostrardia_desdeRadioVenciProve= mostrardia_desdeRadioVenciProve;
	}

	public Boolean getActivardia_desdeRadioVenciProve() {
		return this.activardia_desdeRadioVenciProve;
	}

	public void setActivardia_desdeRadioVenciProve(Boolean activardia_desdeRadioVenciProve) {
		this.activardia_desdeRadioVenciProve= activardia_desdeRadioVenciProve;
	}

	public Border setResaltardia_hastaRadioVenciProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciProveBeanSwingJInternalFrame radiovenciproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//radiovenciproveBeanSwingJInternalFrame.jTtoolBarRadioVenciProve.setBorder(borderResaltar);
		
		this.resaltardia_hastaRadioVenciProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardia_hastaRadioVenciProve() {
		return this.resaltardia_hastaRadioVenciProve;
	}

	public void setResaltardia_hastaRadioVenciProve(Border borderResaltar) {
		this.resaltardia_hastaRadioVenciProve= borderResaltar;
	}

	public Boolean getMostrardia_hastaRadioVenciProve() {
		return this.mostrardia_hastaRadioVenciProve;
	}

	public void setMostrardia_hastaRadioVenciProve(Boolean mostrardia_hastaRadioVenciProve) {
		this.mostrardia_hastaRadioVenciProve= mostrardia_hastaRadioVenciProve;
	}

	public Boolean getActivardia_hastaRadioVenciProve() {
		return this.activardia_hastaRadioVenciProve;
	}

	public void setActivardia_hastaRadioVenciProve(Boolean activardia_hastaRadioVenciProve) {
		this.activardia_hastaRadioVenciProve= activardia_hastaRadioVenciProve;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridRadioVenciProve(esInicial);
		this.setMostrarid_empresaRadioVenciProve(esInicial);
		this.setMostrarid_tipo_radio_venciRadioVenciProve(esInicial);
		this.setMostrardia_desdeRadioVenciProve(esInicial);
		this.setMostrardia_hastaRadioVenciProve(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RadioVenciProveConstantesFunciones.ID)) {
				this.setMostraridRadioVenciProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciProveConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRadioVenciProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciProveConstantesFunciones.IDTIPORADIOVENCI)) {
				this.setMostrarid_tipo_radio_venciRadioVenciProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciProveConstantesFunciones.DIADESDE)) {
				this.setMostrardia_desdeRadioVenciProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciProveConstantesFunciones.DIAHASTA)) {
				this.setMostrardia_hastaRadioVenciProve(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridRadioVenciProve(esInicial);
		this.setActivarid_empresaRadioVenciProve(esInicial);
		this.setActivarid_tipo_radio_venciRadioVenciProve(esInicial);
		this.setActivardia_desdeRadioVenciProve(esInicial);
		this.setActivardia_hastaRadioVenciProve(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RadioVenciProveConstantesFunciones.ID)) {
				this.setActivaridRadioVenciProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciProveConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRadioVenciProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciProveConstantesFunciones.IDTIPORADIOVENCI)) {
				this.setActivarid_tipo_radio_venciRadioVenciProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciProveConstantesFunciones.DIADESDE)) {
				this.setActivardia_desdeRadioVenciProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciProveConstantesFunciones.DIAHASTA)) {
				this.setActivardia_hastaRadioVenciProve(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RadioVenciProveBeanSwingJInternalFrame radiovenciproveBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRadioVenciProve(esInicial);
		this.setResaltarid_empresaRadioVenciProve(esInicial);
		this.setResaltarid_tipo_radio_venciRadioVenciProve(esInicial);
		this.setResaltardia_desdeRadioVenciProve(esInicial);
		this.setResaltardia_hastaRadioVenciProve(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RadioVenciProveConstantesFunciones.ID)) {
				this.setResaltaridRadioVenciProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciProveConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRadioVenciProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciProveConstantesFunciones.IDTIPORADIOVENCI)) {
				this.setResaltarid_tipo_radio_venciRadioVenciProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciProveConstantesFunciones.DIADESDE)) {
				this.setResaltardia_desdeRadioVenciProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(RadioVenciProveConstantesFunciones.DIAHASTA)) {
				this.setResaltardia_hastaRadioVenciProve(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RadioVenciProveBeanSwingJInternalFrame radiovenciproveBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaRadioVenciProve=true;

	public Boolean getMostrarFK_IdEmpresaRadioVenciProve() {
		return this.mostrarFK_IdEmpresaRadioVenciProve;
	}

	public void setMostrarFK_IdEmpresaRadioVenciProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRadioVenciProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRadioVenciRadioVenciProve=true;

	public Boolean getMostrarFK_IdTipoRadioVenciRadioVenciProve() {
		return this.mostrarFK_IdTipoRadioVenciRadioVenciProve;
	}

	public void setMostrarFK_IdTipoRadioVenciRadioVenciProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRadioVenciRadioVenciProve= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaRadioVenciProve=true;

	public Boolean getActivarFK_IdEmpresaRadioVenciProve() {
		return this.activarFK_IdEmpresaRadioVenciProve;
	}

	public void setActivarFK_IdEmpresaRadioVenciProve(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRadioVenciProve= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRadioVenciRadioVenciProve=true;

	public Boolean getActivarFK_IdTipoRadioVenciRadioVenciProve() {
		return this.activarFK_IdTipoRadioVenciRadioVenciProve;
	}

	public void setActivarFK_IdTipoRadioVenciRadioVenciProve(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRadioVenciRadioVenciProve= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaRadioVenciProve=null;

	public Border getResaltarFK_IdEmpresaRadioVenciProve() {
		return this.resaltarFK_IdEmpresaRadioVenciProve;
	}

	public void setResaltarFK_IdEmpresaRadioVenciProve(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRadioVenciProve= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRadioVenciProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciProveBeanSwingJInternalFrame radiovenciproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRadioVenciProve= borderResaltar;
	}

	public Border resaltarFK_IdTipoRadioVenciRadioVenciProve=null;

	public Border getResaltarFK_IdTipoRadioVenciRadioVenciProve() {
		return this.resaltarFK_IdTipoRadioVenciRadioVenciProve;
	}

	public void setResaltarFK_IdTipoRadioVenciRadioVenciProve(Border borderResaltar) {
		this.resaltarFK_IdTipoRadioVenciRadioVenciProve= borderResaltar;
	}

	public void setResaltarFK_IdTipoRadioVenciRadioVenciProve(ParametroGeneralUsuario parametroGeneralUsuario/*RadioVenciProveBeanSwingJInternalFrame radiovenciproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRadioVenciRadioVenciProve= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}