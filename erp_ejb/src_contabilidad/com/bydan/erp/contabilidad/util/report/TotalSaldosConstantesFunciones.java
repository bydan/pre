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
package com.bydan.erp.contabilidad.util.report;

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


import com.bydan.erp.contabilidad.util.report.TotalSaldosConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.TotalSaldosParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.TotalSaldosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;



import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TotalSaldosConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="TotalSaldos";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TotalSaldos"+TotalSaldosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TotalSaldosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TotalSaldosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TotalSaldosConstantesFunciones.SCHEMA+"_"+TotalSaldosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TotalSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TotalSaldosConstantesFunciones.SCHEMA+"_"+TotalSaldosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TotalSaldosConstantesFunciones.SCHEMA+"_"+TotalSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TotalSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TotalSaldosConstantesFunciones.SCHEMA+"_"+TotalSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TotalSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TotalSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TotalSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TotalSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TotalSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TotalSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TotalSaldosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TotalSaldosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TotalSaldosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TotalSaldosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Total Saldoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Total Saldos";
	public static final String SCLASSWEBTITULO_LOWER="Total Saldos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TotalSaldos";
	public static final String OBJECTNAME="totalsaldos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="total_saldos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select totalsaldos from "+TotalSaldosConstantesFunciones.SPERSISTENCENAME+" totalsaldos";
	public static String QUERYSELECTNATIVE="select "+TotalSaldosConstantesFunciones.SCHEMA+"."+TotalSaldosConstantesFunciones.TABLENAME+".id,"+TotalSaldosConstantesFunciones.SCHEMA+"."+TotalSaldosConstantesFunciones.TABLENAME+".version_row,"+TotalSaldosConstantesFunciones.SCHEMA+"."+TotalSaldosConstantesFunciones.TABLENAME+".id_cuenta_contable,"+TotalSaldosConstantesFunciones.SCHEMA+"."+TotalSaldosConstantesFunciones.TABLENAME+".total_debito,"+TotalSaldosConstantesFunciones.SCHEMA+"."+TotalSaldosConstantesFunciones.TABLENAME+".total_credito,"+TotalSaldosConstantesFunciones.SCHEMA+"."+TotalSaldosConstantesFunciones.TABLENAME+".total_debito_extranjero,"+TotalSaldosConstantesFunciones.SCHEMA+"."+TotalSaldosConstantesFunciones.TABLENAME+".total_credito_extranjero from "+TotalSaldosConstantesFunciones.SCHEMA+"."+TotalSaldosConstantesFunciones.TABLENAME;//+" as "+TotalSaldosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String TOTALDEBITO= "total_debito";
    public static final String TOTALCREDITO= "total_credito";
    public static final String TOTALDEBITOEXTRANJERO= "total_debito_extranjero";
    public static final String TOTALCREDITOEXTRANJERO= "total_credito_extranjero";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_TOTALDEBITO= "Total Debito";
		public static final String LABEL_TOTALDEBITO_LOWER= "Total Debito";
    	public static final String LABEL_TOTALCREDITO= "Total Credito";
		public static final String LABEL_TOTALCREDITO_LOWER= "Total Credito";
    	public static final String LABEL_TOTALDEBITOEXTRANJERO= "Total Debito Extranjero";
		public static final String LABEL_TOTALDEBITOEXTRANJERO_LOWER= "Total Debito Extranjero";
    	public static final String LABEL_TOTALCREDITOEXTRANJERO= "Total Credito Extranjero";
		public static final String LABEL_TOTALCREDITOEXTRANJERO_LOWER= "Total Credito Extranjero";
	
		
		
		
		
		
		
		
	
	public static String getTotalSaldosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TotalSaldosConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=TotalSaldosConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(TotalSaldosConstantesFunciones.TOTALDEBITO)) {sLabelColumna=TotalSaldosConstantesFunciones.LABEL_TOTALDEBITO;}
		if(sNombreColumna.equals(TotalSaldosConstantesFunciones.TOTALCREDITO)) {sLabelColumna=TotalSaldosConstantesFunciones.LABEL_TOTALCREDITO;}
		if(sNombreColumna.equals(TotalSaldosConstantesFunciones.TOTALDEBITOEXTRANJERO)) {sLabelColumna=TotalSaldosConstantesFunciones.LABEL_TOTALDEBITOEXTRANJERO;}
		if(sNombreColumna.equals(TotalSaldosConstantesFunciones.TOTALCREDITOEXTRANJERO)) {sLabelColumna=TotalSaldosConstantesFunciones.LABEL_TOTALCREDITOEXTRANJERO;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getTotalSaldosDescripcion(TotalSaldos totalsaldos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(totalsaldos !=null/* && totalsaldos.getId()!=0*/) {
			if(totalsaldos.getId()!=null) {
				sDescripcion=totalsaldos.getId().toString();
			}//totalsaldostotalsaldos.getId().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTotalSaldosDescripcionDetallado(TotalSaldos totalsaldos) {
		String sDescripcion="";
			
		sDescripcion+=TotalSaldosConstantesFunciones.ID+"=";
		sDescripcion+=totalsaldos.getId().toString()+",";
		sDescripcion+=TotalSaldosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=totalsaldos.getVersionRow().toString()+",";
		sDescripcion+=TotalSaldosConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=totalsaldos.getid_cuenta_contable().toString()+",";
		sDescripcion+=TotalSaldosConstantesFunciones.TOTALDEBITO+"=";
		sDescripcion+=totalsaldos.gettotal_debito().toString()+",";
		sDescripcion+=TotalSaldosConstantesFunciones.TOTALCREDITO+"=";
		sDescripcion+=totalsaldos.gettotal_credito().toString()+",";
		sDescripcion+=TotalSaldosConstantesFunciones.TOTALDEBITOEXTRANJERO+"=";
		sDescripcion+=totalsaldos.gettotal_debito_extranjero().toString()+",";
		sDescripcion+=TotalSaldosConstantesFunciones.TOTALCREDITOEXTRANJERO+"=";
		sDescripcion+=totalsaldos.gettotal_credito_extranjero().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTotalSaldosDescripcion(TotalSaldos totalsaldos,String sValor) throws Exception {			
		if(totalsaldos !=null) {
			;//totalsaldostotalsaldos.getId().toString().trim();
		}		
	}
	
		

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTotalSaldos(TotalSaldos totalsaldos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosTotalSaldoss(List<TotalSaldos> totalsaldoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TotalSaldos totalsaldos: totalsaldoss) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTotalSaldos(TotalSaldos totalsaldos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && totalsaldos.getConCambioAuxiliar()) {
			totalsaldos.setIsDeleted(totalsaldos.getIsDeletedAuxiliar());	
			totalsaldos.setIsNew(totalsaldos.getIsNewAuxiliar());	
			totalsaldos.setIsChanged(totalsaldos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			totalsaldos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			totalsaldos.setIsDeletedAuxiliar(false);	
			totalsaldos.setIsNewAuxiliar(false);	
			totalsaldos.setIsChangedAuxiliar(false);
			
			totalsaldos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTotalSaldoss(List<TotalSaldos> totalsaldoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TotalSaldos totalsaldos : totalsaldoss) {
			if(conAsignarBase && totalsaldos.getConCambioAuxiliar()) {
				totalsaldos.setIsDeleted(totalsaldos.getIsDeletedAuxiliar());	
				totalsaldos.setIsNew(totalsaldos.getIsNewAuxiliar());	
				totalsaldos.setIsChanged(totalsaldos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				totalsaldos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				totalsaldos.setIsDeletedAuxiliar(false);	
				totalsaldos.setIsNewAuxiliar(false);	
				totalsaldos.setIsChangedAuxiliar(false);
				
				totalsaldos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTotalSaldos(TotalSaldos totalsaldos,Boolean conEnteros) throws Exception  {
		totalsaldos.settotal_debito(0.0);
		totalsaldos.settotal_credito(0.0);
		totalsaldos.settotal_debito_extranjero(0.0);
		totalsaldos.settotal_credito_extranjero(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTotalSaldoss(List<TotalSaldos> totalsaldoss,Boolean conEnteros) throws Exception  {
		
		for(TotalSaldos totalsaldos: totalsaldoss) {
			totalsaldos.settotal_debito(0.0);
			totalsaldos.settotal_credito(0.0);
			totalsaldos.settotal_debito_extranjero(0.0);
			totalsaldos.settotal_credito_extranjero(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTotalSaldos(List<TotalSaldos> totalsaldoss,TotalSaldos totalsaldosAux) throws Exception  {
		TotalSaldosConstantesFunciones.InicializarValoresTotalSaldos(totalsaldosAux,true);
		
		for(TotalSaldos totalsaldos: totalsaldoss) {
			if(totalsaldos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			totalsaldosAux.settotal_debito(totalsaldosAux.gettotal_debito()+totalsaldos.gettotal_debito());			
			totalsaldosAux.settotal_credito(totalsaldosAux.gettotal_credito()+totalsaldos.gettotal_credito());			
			totalsaldosAux.settotal_debito_extranjero(totalsaldosAux.gettotal_debito_extranjero()+totalsaldos.gettotal_debito_extranjero());			
			totalsaldosAux.settotal_credito_extranjero(totalsaldosAux.gettotal_credito_extranjero()+totalsaldos.gettotal_credito_extranjero());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTotalSaldos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TotalSaldosConstantesFunciones.getArrayColumnasGlobalesTotalSaldos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTotalSaldos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTotalSaldos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TotalSaldos> totalsaldoss,TotalSaldos totalsaldos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TotalSaldos totalsaldosAux: totalsaldoss) {
			if(totalsaldosAux!=null && totalsaldos!=null) {
				if((totalsaldosAux.getId()==null && totalsaldos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(totalsaldosAux.getId()!=null && totalsaldos.getId()!=null){
					if(totalsaldosAux.getId().equals(totalsaldos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTotalSaldos(List<TotalSaldos> totalsaldoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_debitoTotal=0.0;
		Double total_creditoTotal=0.0;
		Double total_debito_extranjeroTotal=0.0;
		Double total_credito_extranjeroTotal=0.0;
	
		for(TotalSaldos totalsaldos: totalsaldoss) {			
			if(totalsaldos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_debitoTotal+=totalsaldos.gettotal_debito();
			total_creditoTotal+=totalsaldos.gettotal_credito();
			total_debito_extranjeroTotal+=totalsaldos.gettotal_debito_extranjero();
			total_credito_extranjeroTotal+=totalsaldos.gettotal_credito_extranjero();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TotalSaldosConstantesFunciones.TOTALDEBITO);
		datoGeneral.setsDescripcion(TotalSaldosConstantesFunciones.LABEL_TOTALDEBITO);
		datoGeneral.setdValorDouble(total_debitoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TotalSaldosConstantesFunciones.TOTALCREDITO);
		datoGeneral.setsDescripcion(TotalSaldosConstantesFunciones.LABEL_TOTALCREDITO);
		datoGeneral.setdValorDouble(total_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TotalSaldosConstantesFunciones.TOTALDEBITOEXTRANJERO);
		datoGeneral.setsDescripcion(TotalSaldosConstantesFunciones.LABEL_TOTALDEBITOEXTRANJERO);
		datoGeneral.setdValorDouble(total_debito_extranjeroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TotalSaldosConstantesFunciones.TOTALCREDITOEXTRANJERO);
		datoGeneral.setsDescripcion(TotalSaldosConstantesFunciones.LABEL_TOTALCREDITOEXTRANJERO);
		datoGeneral.setdValorDouble(total_credito_extranjeroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTotalSaldos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TotalSaldosConstantesFunciones.LABEL_ID, TotalSaldosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TotalSaldosConstantesFunciones.LABEL_VERSIONROW, TotalSaldosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TotalSaldosConstantesFunciones.LABEL_IDCUENTACONTABLE, TotalSaldosConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TotalSaldosConstantesFunciones.LABEL_TOTALDEBITO, TotalSaldosConstantesFunciones.TOTALDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TotalSaldosConstantesFunciones.LABEL_TOTALCREDITO, TotalSaldosConstantesFunciones.TOTALCREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TotalSaldosConstantesFunciones.LABEL_TOTALDEBITOEXTRANJERO, TotalSaldosConstantesFunciones.TOTALDEBITOEXTRANJERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TotalSaldosConstantesFunciones.LABEL_TOTALCREDITOEXTRANJERO, TotalSaldosConstantesFunciones.TOTALCREDITOEXTRANJERO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTotalSaldos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TotalSaldosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TotalSaldosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TotalSaldosConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TotalSaldosConstantesFunciones.TOTALDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TotalSaldosConstantesFunciones.TOTALCREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TotalSaldosConstantesFunciones.TOTALDEBITOEXTRANJERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TotalSaldosConstantesFunciones.TOTALCREDITOEXTRANJERO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTotalSaldos() throws Exception  {
		return TotalSaldosConstantesFunciones.getTiposSeleccionarTotalSaldos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTotalSaldos(Boolean conFk) throws Exception  {
		return TotalSaldosConstantesFunciones.getTiposSeleccionarTotalSaldos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTotalSaldos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TotalSaldosConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(TotalSaldosConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TotalSaldosConstantesFunciones.LABEL_TOTALDEBITO);
			reporte.setsDescripcion(TotalSaldosConstantesFunciones.LABEL_TOTALDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TotalSaldosConstantesFunciones.LABEL_TOTALCREDITO);
			reporte.setsDescripcion(TotalSaldosConstantesFunciones.LABEL_TOTALCREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TotalSaldosConstantesFunciones.LABEL_TOTALDEBITOEXTRANJERO);
			reporte.setsDescripcion(TotalSaldosConstantesFunciones.LABEL_TOTALDEBITOEXTRANJERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TotalSaldosConstantesFunciones.LABEL_TOTALCREDITOEXTRANJERO);
			reporte.setsDescripcion(TotalSaldosConstantesFunciones.LABEL_TOTALCREDITOEXTRANJERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTotalSaldos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTotalSaldos(TotalSaldos totalsaldosAux) throws Exception {
		
			totalsaldosAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(totalsaldosAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTotalSaldos(List<TotalSaldos> totalsaldossTemp) throws Exception {
		for(TotalSaldos totalsaldosAux:totalsaldossTemp) {
			
			totalsaldosAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(totalsaldosAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTotalSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTotalSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTotalSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TotalSaldosConstantesFunciones.getClassesRelationshipsOfTotalSaldos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTotalSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTotalSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TotalSaldosConstantesFunciones.getClassesRelationshipsFromStringsOfTotalSaldos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTotalSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TotalSaldos totalsaldos,List<TotalSaldos> totalsaldoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(TotalSaldos totalsaldos,List<TotalSaldos> totalsaldoss) throws Exception {
		try	{			
			for(TotalSaldos totalsaldosLocal:totalsaldoss) {
				if(totalsaldosLocal.getId().equals(totalsaldos.getId())) {
					totalsaldosLocal.setIsSelected(totalsaldos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTotalSaldos(List<TotalSaldos> totalsaldossAux) throws Exception {
		//this.totalsaldossAux=totalsaldossAux;
		
		for(TotalSaldos totalsaldosAux:totalsaldossAux) {
			if(totalsaldosAux.getIsChanged()) {
				totalsaldosAux.setIsChanged(false);
			}		
			
			if(totalsaldosAux.getIsNew()) {
				totalsaldosAux.setIsNew(false);
			}	
			
			if(totalsaldosAux.getIsDeleted()) {
				totalsaldosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTotalSaldos(TotalSaldos totalsaldosAux) throws Exception {
		//this.totalsaldosAux=totalsaldosAux;
		
			if(totalsaldosAux.getIsChanged()) {
				totalsaldosAux.setIsChanged(false);
			}		
			
			if(totalsaldosAux.getIsNew()) {
				totalsaldosAux.setIsNew(false);
			}	
			
			if(totalsaldosAux.getIsDeleted()) {
				totalsaldosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TotalSaldos totalsaldosAsignar,TotalSaldos totalsaldos) throws Exception {
		totalsaldosAsignar.setId(totalsaldos.getId());	
		totalsaldosAsignar.setVersionRow(totalsaldos.getVersionRow());	
		totalsaldosAsignar.setid_cuenta_contable(totalsaldos.getid_cuenta_contable());
		totalsaldosAsignar.setcuentacontable_descripcion(totalsaldos.getcuentacontable_descripcion());	
		totalsaldosAsignar.settotal_debito(totalsaldos.gettotal_debito());	
		totalsaldosAsignar.settotal_credito(totalsaldos.gettotal_credito());	
		totalsaldosAsignar.settotal_debito_extranjero(totalsaldos.gettotal_debito_extranjero());	
		totalsaldosAsignar.settotal_credito_extranjero(totalsaldos.gettotal_credito_extranjero());	
	}
	
	public static void inicializarTotalSaldos(TotalSaldos totalsaldos) throws Exception {
		try {
				totalsaldos.setId(0L);	
					
				totalsaldos.setid_cuenta_contable(-1L);	
				totalsaldos.settotal_debito(0.0);	
				totalsaldos.settotal_credito(0.0);	
				totalsaldos.settotal_debito_extranjero(0.0);	
				totalsaldos.settotal_credito_extranjero(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTotalSaldos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TotalSaldosConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TotalSaldosConstantesFunciones.LABEL_TOTALDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TotalSaldosConstantesFunciones.LABEL_TOTALCREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TotalSaldosConstantesFunciones.LABEL_TOTALDEBITOEXTRANJERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TotalSaldosConstantesFunciones.LABEL_TOTALCREDITOEXTRANJERO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTotalSaldos(String sTipo,Row row,Workbook workbook,TotalSaldos totalsaldos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(totalsaldos.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(totalsaldos.gettotal_debito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(totalsaldos.gettotal_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(totalsaldos.gettotal_debito_extranjero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(totalsaldos.gettotal_credito_extranjero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTotalSaldos="";
	
	public String getsFinalQueryTotalSaldos() {
		return this.sFinalQueryTotalSaldos;
	}
	
	public void setsFinalQueryTotalSaldos(String sFinalQueryTotalSaldos) {
		this.sFinalQueryTotalSaldos= sFinalQueryTotalSaldos;
	}
	
	public Border resaltarSeleccionarTotalSaldos=null;
	
	public Border setResaltarSeleccionarTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*TotalSaldosBeanSwingJInternalFrame totalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//totalsaldosBeanSwingJInternalFrame.jTtoolBarTotalSaldos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTotalSaldos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTotalSaldos() {
		return this.resaltarSeleccionarTotalSaldos;
	}
	
	public void setResaltarSeleccionarTotalSaldos(Border borderResaltarSeleccionarTotalSaldos) {
		this.resaltarSeleccionarTotalSaldos= borderResaltarSeleccionarTotalSaldos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTotalSaldos=null;
	public Boolean mostraridTotalSaldos=true;
	public Boolean activaridTotalSaldos=true;

	public Border resaltarid_cuenta_contableTotalSaldos=null;
	public Boolean mostrarid_cuenta_contableTotalSaldos=true;
	public Boolean activarid_cuenta_contableTotalSaldos=true;
	public Boolean cargarid_cuenta_contableTotalSaldos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableTotalSaldos=false;//ConEventDepend=true

	public Border resaltartotal_debitoTotalSaldos=null;
	public Boolean mostrartotal_debitoTotalSaldos=true;
	public Boolean activartotal_debitoTotalSaldos=true;

	public Border resaltartotal_creditoTotalSaldos=null;
	public Boolean mostrartotal_creditoTotalSaldos=true;
	public Boolean activartotal_creditoTotalSaldos=true;

	public Border resaltartotal_debito_extranjeroTotalSaldos=null;
	public Boolean mostrartotal_debito_extranjeroTotalSaldos=true;
	public Boolean activartotal_debito_extranjeroTotalSaldos=true;

	public Border resaltartotal_credito_extranjeroTotalSaldos=null;
	public Boolean mostrartotal_credito_extranjeroTotalSaldos=true;
	public Boolean activartotal_credito_extranjeroTotalSaldos=true;

	
	

	public Border setResaltaridTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*TotalSaldosBeanSwingJInternalFrame totalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//totalsaldosBeanSwingJInternalFrame.jTtoolBarTotalSaldos.setBorder(borderResaltar);
		
		this.resaltaridTotalSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTotalSaldos() {
		return this.resaltaridTotalSaldos;
	}

	public void setResaltaridTotalSaldos(Border borderResaltar) {
		this.resaltaridTotalSaldos= borderResaltar;
	}

	public Boolean getMostraridTotalSaldos() {
		return this.mostraridTotalSaldos;
	}

	public void setMostraridTotalSaldos(Boolean mostraridTotalSaldos) {
		this.mostraridTotalSaldos= mostraridTotalSaldos;
	}

	public Boolean getActivaridTotalSaldos() {
		return this.activaridTotalSaldos;
	}

	public void setActivaridTotalSaldos(Boolean activaridTotalSaldos) {
		this.activaridTotalSaldos= activaridTotalSaldos;
	}

	public Border setResaltarid_cuenta_contableTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*TotalSaldosBeanSwingJInternalFrame totalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//totalsaldosBeanSwingJInternalFrame.jTtoolBarTotalSaldos.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableTotalSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableTotalSaldos() {
		return this.resaltarid_cuenta_contableTotalSaldos;
	}

	public void setResaltarid_cuenta_contableTotalSaldos(Border borderResaltar) {
		this.resaltarid_cuenta_contableTotalSaldos= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableTotalSaldos() {
		return this.mostrarid_cuenta_contableTotalSaldos;
	}

	public void setMostrarid_cuenta_contableTotalSaldos(Boolean mostrarid_cuenta_contableTotalSaldos) {
		this.mostrarid_cuenta_contableTotalSaldos= mostrarid_cuenta_contableTotalSaldos;
	}

	public Boolean getActivarid_cuenta_contableTotalSaldos() {
		return this.activarid_cuenta_contableTotalSaldos;
	}

	public void setActivarid_cuenta_contableTotalSaldos(Boolean activarid_cuenta_contableTotalSaldos) {
		this.activarid_cuenta_contableTotalSaldos= activarid_cuenta_contableTotalSaldos;
	}

	public Boolean getCargarid_cuenta_contableTotalSaldos() {
		return this.cargarid_cuenta_contableTotalSaldos;
	}

	public void setCargarid_cuenta_contableTotalSaldos(Boolean cargarid_cuenta_contableTotalSaldos) {
		this.cargarid_cuenta_contableTotalSaldos= cargarid_cuenta_contableTotalSaldos;
	}

	public Border setResaltartotal_debitoTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*TotalSaldosBeanSwingJInternalFrame totalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//totalsaldosBeanSwingJInternalFrame.jTtoolBarTotalSaldos.setBorder(borderResaltar);
		
		this.resaltartotal_debitoTotalSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_debitoTotalSaldos() {
		return this.resaltartotal_debitoTotalSaldos;
	}

	public void setResaltartotal_debitoTotalSaldos(Border borderResaltar) {
		this.resaltartotal_debitoTotalSaldos= borderResaltar;
	}

	public Boolean getMostrartotal_debitoTotalSaldos() {
		return this.mostrartotal_debitoTotalSaldos;
	}

	public void setMostrartotal_debitoTotalSaldos(Boolean mostrartotal_debitoTotalSaldos) {
		this.mostrartotal_debitoTotalSaldos= mostrartotal_debitoTotalSaldos;
	}

	public Boolean getActivartotal_debitoTotalSaldos() {
		return this.activartotal_debitoTotalSaldos;
	}

	public void setActivartotal_debitoTotalSaldos(Boolean activartotal_debitoTotalSaldos) {
		this.activartotal_debitoTotalSaldos= activartotal_debitoTotalSaldos;
	}

	public Border setResaltartotal_creditoTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*TotalSaldosBeanSwingJInternalFrame totalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//totalsaldosBeanSwingJInternalFrame.jTtoolBarTotalSaldos.setBorder(borderResaltar);
		
		this.resaltartotal_creditoTotalSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_creditoTotalSaldos() {
		return this.resaltartotal_creditoTotalSaldos;
	}

	public void setResaltartotal_creditoTotalSaldos(Border borderResaltar) {
		this.resaltartotal_creditoTotalSaldos= borderResaltar;
	}

	public Boolean getMostrartotal_creditoTotalSaldos() {
		return this.mostrartotal_creditoTotalSaldos;
	}

	public void setMostrartotal_creditoTotalSaldos(Boolean mostrartotal_creditoTotalSaldos) {
		this.mostrartotal_creditoTotalSaldos= mostrartotal_creditoTotalSaldos;
	}

	public Boolean getActivartotal_creditoTotalSaldos() {
		return this.activartotal_creditoTotalSaldos;
	}

	public void setActivartotal_creditoTotalSaldos(Boolean activartotal_creditoTotalSaldos) {
		this.activartotal_creditoTotalSaldos= activartotal_creditoTotalSaldos;
	}

	public Border setResaltartotal_debito_extranjeroTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*TotalSaldosBeanSwingJInternalFrame totalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//totalsaldosBeanSwingJInternalFrame.jTtoolBarTotalSaldos.setBorder(borderResaltar);
		
		this.resaltartotal_debito_extranjeroTotalSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_debito_extranjeroTotalSaldos() {
		return this.resaltartotal_debito_extranjeroTotalSaldos;
	}

	public void setResaltartotal_debito_extranjeroTotalSaldos(Border borderResaltar) {
		this.resaltartotal_debito_extranjeroTotalSaldos= borderResaltar;
	}

	public Boolean getMostrartotal_debito_extranjeroTotalSaldos() {
		return this.mostrartotal_debito_extranjeroTotalSaldos;
	}

	public void setMostrartotal_debito_extranjeroTotalSaldos(Boolean mostrartotal_debito_extranjeroTotalSaldos) {
		this.mostrartotal_debito_extranjeroTotalSaldos= mostrartotal_debito_extranjeroTotalSaldos;
	}

	public Boolean getActivartotal_debito_extranjeroTotalSaldos() {
		return this.activartotal_debito_extranjeroTotalSaldos;
	}

	public void setActivartotal_debito_extranjeroTotalSaldos(Boolean activartotal_debito_extranjeroTotalSaldos) {
		this.activartotal_debito_extranjeroTotalSaldos= activartotal_debito_extranjeroTotalSaldos;
	}

	public Border setResaltartotal_credito_extranjeroTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*TotalSaldosBeanSwingJInternalFrame totalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//totalsaldosBeanSwingJInternalFrame.jTtoolBarTotalSaldos.setBorder(borderResaltar);
		
		this.resaltartotal_credito_extranjeroTotalSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_credito_extranjeroTotalSaldos() {
		return this.resaltartotal_credito_extranjeroTotalSaldos;
	}

	public void setResaltartotal_credito_extranjeroTotalSaldos(Border borderResaltar) {
		this.resaltartotal_credito_extranjeroTotalSaldos= borderResaltar;
	}

	public Boolean getMostrartotal_credito_extranjeroTotalSaldos() {
		return this.mostrartotal_credito_extranjeroTotalSaldos;
	}

	public void setMostrartotal_credito_extranjeroTotalSaldos(Boolean mostrartotal_credito_extranjeroTotalSaldos) {
		this.mostrartotal_credito_extranjeroTotalSaldos= mostrartotal_credito_extranjeroTotalSaldos;
	}

	public Boolean getActivartotal_credito_extranjeroTotalSaldos() {
		return this.activartotal_credito_extranjeroTotalSaldos;
	}

	public void setActivartotal_credito_extranjeroTotalSaldos(Boolean activartotal_credito_extranjeroTotalSaldos) {
		this.activartotal_credito_extranjeroTotalSaldos= activartotal_credito_extranjeroTotalSaldos;
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
		
		
		this.setMostraridTotalSaldos(esInicial);
		this.setMostrarid_cuenta_contableTotalSaldos(esInicial);
		this.setMostrartotal_debitoTotalSaldos(esInicial);
		this.setMostrartotal_creditoTotalSaldos(esInicial);
		this.setMostrartotal_debito_extranjeroTotalSaldos(esInicial);
		this.setMostrartotal_credito_extranjeroTotalSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TotalSaldosConstantesFunciones.ID)) {
				this.setMostraridTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TotalSaldosConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TotalSaldosConstantesFunciones.TOTALDEBITO)) {
				this.setMostrartotal_debitoTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TotalSaldosConstantesFunciones.TOTALCREDITO)) {
				this.setMostrartotal_creditoTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TotalSaldosConstantesFunciones.TOTALDEBITOEXTRANJERO)) {
				this.setMostrartotal_debito_extranjeroTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TotalSaldosConstantesFunciones.TOTALCREDITOEXTRANJERO)) {
				this.setMostrartotal_credito_extranjeroTotalSaldos(esAsigna);
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
		
		
		this.setActivaridTotalSaldos(esInicial);
		this.setActivarid_cuenta_contableTotalSaldos(esInicial);
		this.setActivartotal_debitoTotalSaldos(esInicial);
		this.setActivartotal_creditoTotalSaldos(esInicial);
		this.setActivartotal_debito_extranjeroTotalSaldos(esInicial);
		this.setActivartotal_credito_extranjeroTotalSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TotalSaldosConstantesFunciones.ID)) {
				this.setActivaridTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TotalSaldosConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TotalSaldosConstantesFunciones.TOTALDEBITO)) {
				this.setActivartotal_debitoTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TotalSaldosConstantesFunciones.TOTALCREDITO)) {
				this.setActivartotal_creditoTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TotalSaldosConstantesFunciones.TOTALDEBITOEXTRANJERO)) {
				this.setActivartotal_debito_extranjeroTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TotalSaldosConstantesFunciones.TOTALCREDITOEXTRANJERO)) {
				this.setActivartotal_credito_extranjeroTotalSaldos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TotalSaldosBeanSwingJInternalFrame totalsaldosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTotalSaldos(esInicial);
		this.setResaltarid_cuenta_contableTotalSaldos(esInicial);
		this.setResaltartotal_debitoTotalSaldos(esInicial);
		this.setResaltartotal_creditoTotalSaldos(esInicial);
		this.setResaltartotal_debito_extranjeroTotalSaldos(esInicial);
		this.setResaltartotal_credito_extranjeroTotalSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TotalSaldosConstantesFunciones.ID)) {
				this.setResaltaridTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TotalSaldosConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TotalSaldosConstantesFunciones.TOTALDEBITO)) {
				this.setResaltartotal_debitoTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TotalSaldosConstantesFunciones.TOTALCREDITO)) {
				this.setResaltartotal_creditoTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TotalSaldosConstantesFunciones.TOTALDEBITOEXTRANJERO)) {
				this.setResaltartotal_debito_extranjeroTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TotalSaldosConstantesFunciones.TOTALCREDITOEXTRANJERO)) {
				this.setResaltartotal_credito_extranjeroTotalSaldos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TotalSaldosBeanSwingJInternalFrame totalsaldosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContableTotalSaldos=true;

	public Boolean getMostrarFK_IdCuentaContableTotalSaldos() {
		return this.mostrarFK_IdCuentaContableTotalSaldos;
	}

	public void setMostrarFK_IdCuentaContableTotalSaldos(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableTotalSaldos= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableTotalSaldos=true;

	public Boolean getActivarFK_IdCuentaContableTotalSaldos() {
		return this.activarFK_IdCuentaContableTotalSaldos;
	}

	public void setActivarFK_IdCuentaContableTotalSaldos(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableTotalSaldos= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableTotalSaldos=null;

	public Border getResaltarFK_IdCuentaContableTotalSaldos() {
		return this.resaltarFK_IdCuentaContableTotalSaldos;
	}

	public void setResaltarFK_IdCuentaContableTotalSaldos(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableTotalSaldos= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*TotalSaldosBeanSwingJInternalFrame totalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableTotalSaldos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}