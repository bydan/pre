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


import com.bydan.erp.contabilidad.util.report.VistaTotalSaldosConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.VistaTotalSaldosParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.VistaTotalSaldosParameterGeneral;

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
final public class VistaTotalSaldosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="VistaTotalSaldos";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VistaTotalSaldos"+VistaTotalSaldosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VistaTotalSaldosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VistaTotalSaldosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VistaTotalSaldosConstantesFunciones.SCHEMA+"_"+VistaTotalSaldosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VistaTotalSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VistaTotalSaldosConstantesFunciones.SCHEMA+"_"+VistaTotalSaldosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VistaTotalSaldosConstantesFunciones.SCHEMA+"_"+VistaTotalSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VistaTotalSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VistaTotalSaldosConstantesFunciones.SCHEMA+"_"+VistaTotalSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VistaTotalSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VistaTotalSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VistaTotalSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VistaTotalSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VistaTotalSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VistaTotalSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VistaTotalSaldosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VistaTotalSaldosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VistaTotalSaldosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VistaTotalSaldosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Vista Total Saldoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Vista Total Saldos";
	public static final String SCLASSWEBTITULO_LOWER="Vista Total Saldos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VistaTotalSaldos";
	public static final String OBJECTNAME="vistatotalsaldos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="vista_total_saldos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select vistatotalsaldos from "+VistaTotalSaldosConstantesFunciones.SPERSISTENCENAME+" vistatotalsaldos";
	public static String QUERYSELECTNATIVE="select "+VistaTotalSaldosConstantesFunciones.SCHEMA+"."+VistaTotalSaldosConstantesFunciones.TABLENAME+".id,"+VistaTotalSaldosConstantesFunciones.SCHEMA+"."+VistaTotalSaldosConstantesFunciones.TABLENAME+".version_row,"+VistaTotalSaldosConstantesFunciones.SCHEMA+"."+VistaTotalSaldosConstantesFunciones.TABLENAME+".id_cuenta_contable,"+VistaTotalSaldosConstantesFunciones.SCHEMA+"."+VistaTotalSaldosConstantesFunciones.TABLENAME+".total_debito_moneda_local,"+VistaTotalSaldosConstantesFunciones.SCHEMA+"."+VistaTotalSaldosConstantesFunciones.TABLENAME+".total_credito_moneda_local,"+VistaTotalSaldosConstantesFunciones.SCHEMA+"."+VistaTotalSaldosConstantesFunciones.TABLENAME+".total_debito_moneda_extran,"+VistaTotalSaldosConstantesFunciones.SCHEMA+"."+VistaTotalSaldosConstantesFunciones.TABLENAME+".total_credito_moneda_extran from "+VistaTotalSaldosConstantesFunciones.SCHEMA+"."+VistaTotalSaldosConstantesFunciones.TABLENAME;//+" as "+VistaTotalSaldosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String TOTALDEBITOMONEDALOCAL= "total_debito_moneda_local";
    public static final String TOTALCREDITOMONEDALOCAL= "total_credito_moneda_local";
    public static final String TOTALDEBITOMONEDAEXTRAN= "total_debito_moneda_extran";
    public static final String TOTALCREDITOMONEDAEXTRAN= "total_credito_moneda_extran";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCUENTACONTABLE= "Idcuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_TOTALDEBITOMONEDALOCAL= "Total Debito Moneda Local";
		public static final String LABEL_TOTALDEBITOMONEDALOCAL_LOWER= "Total Debito Moneda Local";
    	public static final String LABEL_TOTALCREDITOMONEDALOCAL= "Total Credito Moneda Local";
		public static final String LABEL_TOTALCREDITOMONEDALOCAL_LOWER= "Total Credito Moneda Local";
    	public static final String LABEL_TOTALDEBITOMONEDAEXTRAN= "Total Debito Moneda Extran";
		public static final String LABEL_TOTALDEBITOMONEDAEXTRAN_LOWER= "Total Debito Moneda Extran";
    	public static final String LABEL_TOTALCREDITOMONEDAEXTRAN= "Total Credito Moneda Extran";
		public static final String LABEL_TOTALCREDITOMONEDAEXTRAN_LOWER= "Total Credito Moneda Extran";
	
		
		
		
		
		
		
		
	
	public static String getVistaTotalSaldosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VistaTotalSaldosConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=VistaTotalSaldosConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDALOCAL)) {sLabelColumna=VistaTotalSaldosConstantesFunciones.LABEL_TOTALDEBITOMONEDALOCAL;}
		if(sNombreColumna.equals(VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDALOCAL)) {sLabelColumna=VistaTotalSaldosConstantesFunciones.LABEL_TOTALCREDITOMONEDALOCAL;}
		if(sNombreColumna.equals(VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDAEXTRAN)) {sLabelColumna=VistaTotalSaldosConstantesFunciones.LABEL_TOTALDEBITOMONEDAEXTRAN;}
		if(sNombreColumna.equals(VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDAEXTRAN)) {sLabelColumna=VistaTotalSaldosConstantesFunciones.LABEL_TOTALCREDITOMONEDAEXTRAN;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getVistaTotalSaldosDescripcion(VistaTotalSaldos vistatotalsaldos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(vistatotalsaldos !=null/* && vistatotalsaldos.getId()!=0*/) {
			if(vistatotalsaldos.getId()!=null) {
				sDescripcion=vistatotalsaldos.getId().toString();
			}//vistatotalsaldosvistatotalsaldos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVistaTotalSaldosDescripcionDetallado(VistaTotalSaldos vistatotalsaldos) {
		String sDescripcion="";
			
		sDescripcion+=VistaTotalSaldosConstantesFunciones.ID+"=";
		sDescripcion+=vistatotalsaldos.getId().toString()+",";
		sDescripcion+=VistaTotalSaldosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=vistatotalsaldos.getVersionRow().toString()+",";
		sDescripcion+=VistaTotalSaldosConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=vistatotalsaldos.getid_cuenta_contable().toString()+",";
		sDescripcion+=VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDALOCAL+"=";
		sDescripcion+=vistatotalsaldos.gettotal_debito_moneda_local().toString()+",";
		sDescripcion+=VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDALOCAL+"=";
		sDescripcion+=vistatotalsaldos.gettotal_credito_moneda_local().toString()+",";
		sDescripcion+=VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDAEXTRAN+"=";
		sDescripcion+=vistatotalsaldos.gettotal_debito_moneda_extran().toString()+",";
		sDescripcion+=VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDAEXTRAN+"=";
		sDescripcion+=vistatotalsaldos.gettotal_credito_moneda_extran().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setVistaTotalSaldosDescripcion(VistaTotalSaldos vistatotalsaldos,String sValor) throws Exception {			
		if(vistatotalsaldos !=null) {
			//vistatotalsaldosvistatotalsaldos.getId().toString();
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
			sNombreIndice="Tipo=  Por Idcuenta Contable";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Idcuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVistaTotalSaldos(VistaTotalSaldos vistatotalsaldos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosVistaTotalSaldoss(List<VistaTotalSaldos> vistatotalsaldoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VistaTotalSaldos vistatotalsaldos: vistatotalsaldoss) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVistaTotalSaldos(VistaTotalSaldos vistatotalsaldos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && vistatotalsaldos.getConCambioAuxiliar()) {
			vistatotalsaldos.setIsDeleted(vistatotalsaldos.getIsDeletedAuxiliar());	
			vistatotalsaldos.setIsNew(vistatotalsaldos.getIsNewAuxiliar());	
			vistatotalsaldos.setIsChanged(vistatotalsaldos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			vistatotalsaldos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			vistatotalsaldos.setIsDeletedAuxiliar(false);	
			vistatotalsaldos.setIsNewAuxiliar(false);	
			vistatotalsaldos.setIsChangedAuxiliar(false);
			
			vistatotalsaldos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVistaTotalSaldoss(List<VistaTotalSaldos> vistatotalsaldoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VistaTotalSaldos vistatotalsaldos : vistatotalsaldoss) {
			if(conAsignarBase && vistatotalsaldos.getConCambioAuxiliar()) {
				vistatotalsaldos.setIsDeleted(vistatotalsaldos.getIsDeletedAuxiliar());	
				vistatotalsaldos.setIsNew(vistatotalsaldos.getIsNewAuxiliar());	
				vistatotalsaldos.setIsChanged(vistatotalsaldos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				vistatotalsaldos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				vistatotalsaldos.setIsDeletedAuxiliar(false);	
				vistatotalsaldos.setIsNewAuxiliar(false);	
				vistatotalsaldos.setIsChangedAuxiliar(false);
				
				vistatotalsaldos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVistaTotalSaldos(VistaTotalSaldos vistatotalsaldos,Boolean conEnteros) throws Exception  {
		vistatotalsaldos.settotal_debito_moneda_local(0.0);
		vistatotalsaldos.settotal_credito_moneda_local(0.0);
		vistatotalsaldos.settotal_debito_moneda_extran(0.0);
		vistatotalsaldos.settotal_credito_moneda_extran(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVistaTotalSaldoss(List<VistaTotalSaldos> vistatotalsaldoss,Boolean conEnteros) throws Exception  {
		
		for(VistaTotalSaldos vistatotalsaldos: vistatotalsaldoss) {
			vistatotalsaldos.settotal_debito_moneda_local(0.0);
			vistatotalsaldos.settotal_credito_moneda_local(0.0);
			vistatotalsaldos.settotal_debito_moneda_extran(0.0);
			vistatotalsaldos.settotal_credito_moneda_extran(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVistaTotalSaldos(List<VistaTotalSaldos> vistatotalsaldoss,VistaTotalSaldos vistatotalsaldosAux) throws Exception  {
		VistaTotalSaldosConstantesFunciones.InicializarValoresVistaTotalSaldos(vistatotalsaldosAux,true);
		
		for(VistaTotalSaldos vistatotalsaldos: vistatotalsaldoss) {
			if(vistatotalsaldos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			vistatotalsaldosAux.settotal_debito_moneda_local(vistatotalsaldosAux.gettotal_debito_moneda_local()+vistatotalsaldos.gettotal_debito_moneda_local());			
			vistatotalsaldosAux.settotal_credito_moneda_local(vistatotalsaldosAux.gettotal_credito_moneda_local()+vistatotalsaldos.gettotal_credito_moneda_local());			
			vistatotalsaldosAux.settotal_debito_moneda_extran(vistatotalsaldosAux.gettotal_debito_moneda_extran()+vistatotalsaldos.gettotal_debito_moneda_extran());			
			vistatotalsaldosAux.settotal_credito_moneda_extran(vistatotalsaldosAux.gettotal_credito_moneda_extran()+vistatotalsaldos.gettotal_credito_moneda_extran());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVistaTotalSaldos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VistaTotalSaldosConstantesFunciones.getArrayColumnasGlobalesVistaTotalSaldos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVistaTotalSaldos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVistaTotalSaldos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VistaTotalSaldos> vistatotalsaldoss,VistaTotalSaldos vistatotalsaldos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VistaTotalSaldos vistatotalsaldosAux: vistatotalsaldoss) {
			if(vistatotalsaldosAux!=null && vistatotalsaldos!=null) {
				if((vistatotalsaldosAux.getId()==null && vistatotalsaldos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(vistatotalsaldosAux.getId()!=null && vistatotalsaldos.getId()!=null){
					if(vistatotalsaldosAux.getId().equals(vistatotalsaldos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVistaTotalSaldos(List<VistaTotalSaldos> vistatotalsaldoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_debito_moneda_localTotal=0.0;
		Double total_credito_moneda_localTotal=0.0;
		Double total_debito_moneda_extranTotal=0.0;
		Double total_credito_moneda_extranTotal=0.0;
	
		for(VistaTotalSaldos vistatotalsaldos: vistatotalsaldoss) {			
			if(vistatotalsaldos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_debito_moneda_localTotal+=vistatotalsaldos.gettotal_debito_moneda_local();
			total_credito_moneda_localTotal+=vistatotalsaldos.gettotal_credito_moneda_local();
			total_debito_moneda_extranTotal+=vistatotalsaldos.gettotal_debito_moneda_extran();
			total_credito_moneda_extranTotal+=vistatotalsaldos.gettotal_credito_moneda_extran();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDALOCAL);
		datoGeneral.setsDescripcion(VistaTotalSaldosConstantesFunciones.LABEL_TOTALDEBITOMONEDALOCAL);
		datoGeneral.setdValorDouble(total_debito_moneda_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDALOCAL);
		datoGeneral.setsDescripcion(VistaTotalSaldosConstantesFunciones.LABEL_TOTALCREDITOMONEDALOCAL);
		datoGeneral.setdValorDouble(total_credito_moneda_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDAEXTRAN);
		datoGeneral.setsDescripcion(VistaTotalSaldosConstantesFunciones.LABEL_TOTALDEBITOMONEDAEXTRAN);
		datoGeneral.setdValorDouble(total_debito_moneda_extranTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDAEXTRAN);
		datoGeneral.setsDescripcion(VistaTotalSaldosConstantesFunciones.LABEL_TOTALCREDITOMONEDAEXTRAN);
		datoGeneral.setdValorDouble(total_credito_moneda_extranTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVistaTotalSaldos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VistaTotalSaldosConstantesFunciones.LABEL_ID, VistaTotalSaldosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VistaTotalSaldosConstantesFunciones.LABEL_VERSIONROW, VistaTotalSaldosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VistaTotalSaldosConstantesFunciones.LABEL_IDCUENTACONTABLE, VistaTotalSaldosConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VistaTotalSaldosConstantesFunciones.LABEL_TOTALDEBITOMONEDALOCAL, VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDALOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VistaTotalSaldosConstantesFunciones.LABEL_TOTALCREDITOMONEDALOCAL, VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDALOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VistaTotalSaldosConstantesFunciones.LABEL_TOTALDEBITOMONEDAEXTRAN, VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDAEXTRAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VistaTotalSaldosConstantesFunciones.LABEL_TOTALCREDITOMONEDAEXTRAN, VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDAEXTRAN,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVistaTotalSaldos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VistaTotalSaldosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VistaTotalSaldosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VistaTotalSaldosConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDALOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDALOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDAEXTRAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDAEXTRAN;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVistaTotalSaldos() throws Exception  {
		return VistaTotalSaldosConstantesFunciones.getTiposSeleccionarVistaTotalSaldos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVistaTotalSaldos(Boolean conFk) throws Exception  {
		return VistaTotalSaldosConstantesFunciones.getTiposSeleccionarVistaTotalSaldos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVistaTotalSaldos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VistaTotalSaldosConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(VistaTotalSaldosConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VistaTotalSaldosConstantesFunciones.LABEL_TOTALDEBITOMONEDALOCAL);
			reporte.setsDescripcion(VistaTotalSaldosConstantesFunciones.LABEL_TOTALDEBITOMONEDALOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VistaTotalSaldosConstantesFunciones.LABEL_TOTALCREDITOMONEDALOCAL);
			reporte.setsDescripcion(VistaTotalSaldosConstantesFunciones.LABEL_TOTALCREDITOMONEDALOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VistaTotalSaldosConstantesFunciones.LABEL_TOTALDEBITOMONEDAEXTRAN);
			reporte.setsDescripcion(VistaTotalSaldosConstantesFunciones.LABEL_TOTALDEBITOMONEDAEXTRAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VistaTotalSaldosConstantesFunciones.LABEL_TOTALCREDITOMONEDAEXTRAN);
			reporte.setsDescripcion(VistaTotalSaldosConstantesFunciones.LABEL_TOTALCREDITOMONEDAEXTRAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVistaTotalSaldos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVistaTotalSaldos(VistaTotalSaldos vistatotalsaldosAux) throws Exception {
		
			vistatotalsaldosAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(vistatotalsaldosAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVistaTotalSaldos(List<VistaTotalSaldos> vistatotalsaldossTemp) throws Exception {
		for(VistaTotalSaldos vistatotalsaldosAux:vistatotalsaldossTemp) {
			
			vistatotalsaldosAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(vistatotalsaldosAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVistaTotalSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVistaTotalSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVistaTotalSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VistaTotalSaldosConstantesFunciones.getClassesRelationshipsOfVistaTotalSaldos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVistaTotalSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVistaTotalSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VistaTotalSaldosConstantesFunciones.getClassesRelationshipsFromStringsOfVistaTotalSaldos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVistaTotalSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VistaTotalSaldos vistatotalsaldos,List<VistaTotalSaldos> vistatotalsaldoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(VistaTotalSaldos vistatotalsaldos,List<VistaTotalSaldos> vistatotalsaldoss) throws Exception {
		try	{			
			for(VistaTotalSaldos vistatotalsaldosLocal:vistatotalsaldoss) {
				if(vistatotalsaldosLocal.getId().equals(vistatotalsaldos.getId())) {
					vistatotalsaldosLocal.setIsSelected(vistatotalsaldos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVistaTotalSaldos(List<VistaTotalSaldos> vistatotalsaldossAux) throws Exception {
		//this.vistatotalsaldossAux=vistatotalsaldossAux;
		
		for(VistaTotalSaldos vistatotalsaldosAux:vistatotalsaldossAux) {
			if(vistatotalsaldosAux.getIsChanged()) {
				vistatotalsaldosAux.setIsChanged(false);
			}		
			
			if(vistatotalsaldosAux.getIsNew()) {
				vistatotalsaldosAux.setIsNew(false);
			}	
			
			if(vistatotalsaldosAux.getIsDeleted()) {
				vistatotalsaldosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVistaTotalSaldos(VistaTotalSaldos vistatotalsaldosAux) throws Exception {
		//this.vistatotalsaldosAux=vistatotalsaldosAux;
		
			if(vistatotalsaldosAux.getIsChanged()) {
				vistatotalsaldosAux.setIsChanged(false);
			}		
			
			if(vistatotalsaldosAux.getIsNew()) {
				vistatotalsaldosAux.setIsNew(false);
			}	
			
			if(vistatotalsaldosAux.getIsDeleted()) {
				vistatotalsaldosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VistaTotalSaldos vistatotalsaldosAsignar,VistaTotalSaldos vistatotalsaldos) throws Exception {
		vistatotalsaldosAsignar.setId(vistatotalsaldos.getId());	
		vistatotalsaldosAsignar.setVersionRow(vistatotalsaldos.getVersionRow());	
		vistatotalsaldosAsignar.setid_cuenta_contable(vistatotalsaldos.getid_cuenta_contable());
		vistatotalsaldosAsignar.setcuentacontable_descripcion(vistatotalsaldos.getcuentacontable_descripcion());	
		vistatotalsaldosAsignar.settotal_debito_moneda_local(vistatotalsaldos.gettotal_debito_moneda_local());	
		vistatotalsaldosAsignar.settotal_credito_moneda_local(vistatotalsaldos.gettotal_credito_moneda_local());	
		vistatotalsaldosAsignar.settotal_debito_moneda_extran(vistatotalsaldos.gettotal_debito_moneda_extran());	
		vistatotalsaldosAsignar.settotal_credito_moneda_extran(vistatotalsaldos.gettotal_credito_moneda_extran());	
	}
	
	public static void inicializarVistaTotalSaldos(VistaTotalSaldos vistatotalsaldos) throws Exception {
		try {
				vistatotalsaldos.setId(0L);	
					
				vistatotalsaldos.setid_cuenta_contable(-1L);	
				vistatotalsaldos.settotal_debito_moneda_local(0.0);	
				vistatotalsaldos.settotal_credito_moneda_local(0.0);	
				vistatotalsaldos.settotal_debito_moneda_extran(0.0);	
				vistatotalsaldos.settotal_credito_moneda_extran(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVistaTotalSaldos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VistaTotalSaldosConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VistaTotalSaldosConstantesFunciones.LABEL_TOTALDEBITOMONEDALOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VistaTotalSaldosConstantesFunciones.LABEL_TOTALCREDITOMONEDALOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VistaTotalSaldosConstantesFunciones.LABEL_TOTALDEBITOMONEDAEXTRAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VistaTotalSaldosConstantesFunciones.LABEL_TOTALCREDITOMONEDAEXTRAN);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVistaTotalSaldos(String sTipo,Row row,Workbook workbook,VistaTotalSaldos vistatotalsaldos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(vistatotalsaldos.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vistatotalsaldos.gettotal_debito_moneda_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vistatotalsaldos.gettotal_credito_moneda_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vistatotalsaldos.gettotal_debito_moneda_extran());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vistatotalsaldos.gettotal_credito_moneda_extran());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVistaTotalSaldos="";
	
	public String getsFinalQueryVistaTotalSaldos() {
		return this.sFinalQueryVistaTotalSaldos;
	}
	
	public void setsFinalQueryVistaTotalSaldos(String sFinalQueryVistaTotalSaldos) {
		this.sFinalQueryVistaTotalSaldos= sFinalQueryVistaTotalSaldos;
	}
	
	public Border resaltarSeleccionarVistaTotalSaldos=null;
	
	public Border setResaltarSeleccionarVistaTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*VistaTotalSaldosBeanSwingJInternalFrame vistatotalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//vistatotalsaldosBeanSwingJInternalFrame.jTtoolBarVistaTotalSaldos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVistaTotalSaldos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVistaTotalSaldos() {
		return this.resaltarSeleccionarVistaTotalSaldos;
	}
	
	public void setResaltarSeleccionarVistaTotalSaldos(Border borderResaltarSeleccionarVistaTotalSaldos) {
		this.resaltarSeleccionarVistaTotalSaldos= borderResaltarSeleccionarVistaTotalSaldos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVistaTotalSaldos=null;
	public Boolean mostraridVistaTotalSaldos=true;
	public Boolean activaridVistaTotalSaldos=true;

	public Border resaltarid_cuenta_contableVistaTotalSaldos=null;
	public Boolean mostrarid_cuenta_contableVistaTotalSaldos=true;
	public Boolean activarid_cuenta_contableVistaTotalSaldos=true;
	public Boolean cargarid_cuenta_contableVistaTotalSaldos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableVistaTotalSaldos=false;//ConEventDepend=true

	public Border resaltartotal_debito_moneda_localVistaTotalSaldos=null;
	public Boolean mostrartotal_debito_moneda_localVistaTotalSaldos=true;
	public Boolean activartotal_debito_moneda_localVistaTotalSaldos=true;

	public Border resaltartotal_credito_moneda_localVistaTotalSaldos=null;
	public Boolean mostrartotal_credito_moneda_localVistaTotalSaldos=true;
	public Boolean activartotal_credito_moneda_localVistaTotalSaldos=true;

	public Border resaltartotal_debito_moneda_extranVistaTotalSaldos=null;
	public Boolean mostrartotal_debito_moneda_extranVistaTotalSaldos=true;
	public Boolean activartotal_debito_moneda_extranVistaTotalSaldos=true;

	public Border resaltartotal_credito_moneda_extranVistaTotalSaldos=null;
	public Boolean mostrartotal_credito_moneda_extranVistaTotalSaldos=true;
	public Boolean activartotal_credito_moneda_extranVistaTotalSaldos=true;

	
	

	public Border setResaltaridVistaTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*VistaTotalSaldosBeanSwingJInternalFrame vistatotalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vistatotalsaldosBeanSwingJInternalFrame.jTtoolBarVistaTotalSaldos.setBorder(borderResaltar);
		
		this.resaltaridVistaTotalSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVistaTotalSaldos() {
		return this.resaltaridVistaTotalSaldos;
	}

	public void setResaltaridVistaTotalSaldos(Border borderResaltar) {
		this.resaltaridVistaTotalSaldos= borderResaltar;
	}

	public Boolean getMostraridVistaTotalSaldos() {
		return this.mostraridVistaTotalSaldos;
	}

	public void setMostraridVistaTotalSaldos(Boolean mostraridVistaTotalSaldos) {
		this.mostraridVistaTotalSaldos= mostraridVistaTotalSaldos;
	}

	public Boolean getActivaridVistaTotalSaldos() {
		return this.activaridVistaTotalSaldos;
	}

	public void setActivaridVistaTotalSaldos(Boolean activaridVistaTotalSaldos) {
		this.activaridVistaTotalSaldos= activaridVistaTotalSaldos;
	}

	public Border setResaltarid_cuenta_contableVistaTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*VistaTotalSaldosBeanSwingJInternalFrame vistatotalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vistatotalsaldosBeanSwingJInternalFrame.jTtoolBarVistaTotalSaldos.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableVistaTotalSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableVistaTotalSaldos() {
		return this.resaltarid_cuenta_contableVistaTotalSaldos;
	}

	public void setResaltarid_cuenta_contableVistaTotalSaldos(Border borderResaltar) {
		this.resaltarid_cuenta_contableVistaTotalSaldos= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableVistaTotalSaldos() {
		return this.mostrarid_cuenta_contableVistaTotalSaldos;
	}

	public void setMostrarid_cuenta_contableVistaTotalSaldos(Boolean mostrarid_cuenta_contableVistaTotalSaldos) {
		this.mostrarid_cuenta_contableVistaTotalSaldos= mostrarid_cuenta_contableVistaTotalSaldos;
	}

	public Boolean getActivarid_cuenta_contableVistaTotalSaldos() {
		return this.activarid_cuenta_contableVistaTotalSaldos;
	}

	public void setActivarid_cuenta_contableVistaTotalSaldos(Boolean activarid_cuenta_contableVistaTotalSaldos) {
		this.activarid_cuenta_contableVistaTotalSaldos= activarid_cuenta_contableVistaTotalSaldos;
	}

	public Boolean getCargarid_cuenta_contableVistaTotalSaldos() {
		return this.cargarid_cuenta_contableVistaTotalSaldos;
	}

	public void setCargarid_cuenta_contableVistaTotalSaldos(Boolean cargarid_cuenta_contableVistaTotalSaldos) {
		this.cargarid_cuenta_contableVistaTotalSaldos= cargarid_cuenta_contableVistaTotalSaldos;
	}

	public Border setResaltartotal_debito_moneda_localVistaTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*VistaTotalSaldosBeanSwingJInternalFrame vistatotalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vistatotalsaldosBeanSwingJInternalFrame.jTtoolBarVistaTotalSaldos.setBorder(borderResaltar);
		
		this.resaltartotal_debito_moneda_localVistaTotalSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_debito_moneda_localVistaTotalSaldos() {
		return this.resaltartotal_debito_moneda_localVistaTotalSaldos;
	}

	public void setResaltartotal_debito_moneda_localVistaTotalSaldos(Border borderResaltar) {
		this.resaltartotal_debito_moneda_localVistaTotalSaldos= borderResaltar;
	}

	public Boolean getMostrartotal_debito_moneda_localVistaTotalSaldos() {
		return this.mostrartotal_debito_moneda_localVistaTotalSaldos;
	}

	public void setMostrartotal_debito_moneda_localVistaTotalSaldos(Boolean mostrartotal_debito_moneda_localVistaTotalSaldos) {
		this.mostrartotal_debito_moneda_localVistaTotalSaldos= mostrartotal_debito_moneda_localVistaTotalSaldos;
	}

	public Boolean getActivartotal_debito_moneda_localVistaTotalSaldos() {
		return this.activartotal_debito_moneda_localVistaTotalSaldos;
	}

	public void setActivartotal_debito_moneda_localVistaTotalSaldos(Boolean activartotal_debito_moneda_localVistaTotalSaldos) {
		this.activartotal_debito_moneda_localVistaTotalSaldos= activartotal_debito_moneda_localVistaTotalSaldos;
	}

	public Border setResaltartotal_credito_moneda_localVistaTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*VistaTotalSaldosBeanSwingJInternalFrame vistatotalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vistatotalsaldosBeanSwingJInternalFrame.jTtoolBarVistaTotalSaldos.setBorder(borderResaltar);
		
		this.resaltartotal_credito_moneda_localVistaTotalSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_credito_moneda_localVistaTotalSaldos() {
		return this.resaltartotal_credito_moneda_localVistaTotalSaldos;
	}

	public void setResaltartotal_credito_moneda_localVistaTotalSaldos(Border borderResaltar) {
		this.resaltartotal_credito_moneda_localVistaTotalSaldos= borderResaltar;
	}

	public Boolean getMostrartotal_credito_moneda_localVistaTotalSaldos() {
		return this.mostrartotal_credito_moneda_localVistaTotalSaldos;
	}

	public void setMostrartotal_credito_moneda_localVistaTotalSaldos(Boolean mostrartotal_credito_moneda_localVistaTotalSaldos) {
		this.mostrartotal_credito_moneda_localVistaTotalSaldos= mostrartotal_credito_moneda_localVistaTotalSaldos;
	}

	public Boolean getActivartotal_credito_moneda_localVistaTotalSaldos() {
		return this.activartotal_credito_moneda_localVistaTotalSaldos;
	}

	public void setActivartotal_credito_moneda_localVistaTotalSaldos(Boolean activartotal_credito_moneda_localVistaTotalSaldos) {
		this.activartotal_credito_moneda_localVistaTotalSaldos= activartotal_credito_moneda_localVistaTotalSaldos;
	}

	public Border setResaltartotal_debito_moneda_extranVistaTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*VistaTotalSaldosBeanSwingJInternalFrame vistatotalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vistatotalsaldosBeanSwingJInternalFrame.jTtoolBarVistaTotalSaldos.setBorder(borderResaltar);
		
		this.resaltartotal_debito_moneda_extranVistaTotalSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_debito_moneda_extranVistaTotalSaldos() {
		return this.resaltartotal_debito_moneda_extranVistaTotalSaldos;
	}

	public void setResaltartotal_debito_moneda_extranVistaTotalSaldos(Border borderResaltar) {
		this.resaltartotal_debito_moneda_extranVistaTotalSaldos= borderResaltar;
	}

	public Boolean getMostrartotal_debito_moneda_extranVistaTotalSaldos() {
		return this.mostrartotal_debito_moneda_extranVistaTotalSaldos;
	}

	public void setMostrartotal_debito_moneda_extranVistaTotalSaldos(Boolean mostrartotal_debito_moneda_extranVistaTotalSaldos) {
		this.mostrartotal_debito_moneda_extranVistaTotalSaldos= mostrartotal_debito_moneda_extranVistaTotalSaldos;
	}

	public Boolean getActivartotal_debito_moneda_extranVistaTotalSaldos() {
		return this.activartotal_debito_moneda_extranVistaTotalSaldos;
	}

	public void setActivartotal_debito_moneda_extranVistaTotalSaldos(Boolean activartotal_debito_moneda_extranVistaTotalSaldos) {
		this.activartotal_debito_moneda_extranVistaTotalSaldos= activartotal_debito_moneda_extranVistaTotalSaldos;
	}

	public Border setResaltartotal_credito_moneda_extranVistaTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*VistaTotalSaldosBeanSwingJInternalFrame vistatotalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vistatotalsaldosBeanSwingJInternalFrame.jTtoolBarVistaTotalSaldos.setBorder(borderResaltar);
		
		this.resaltartotal_credito_moneda_extranVistaTotalSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_credito_moneda_extranVistaTotalSaldos() {
		return this.resaltartotal_credito_moneda_extranVistaTotalSaldos;
	}

	public void setResaltartotal_credito_moneda_extranVistaTotalSaldos(Border borderResaltar) {
		this.resaltartotal_credito_moneda_extranVistaTotalSaldos= borderResaltar;
	}

	public Boolean getMostrartotal_credito_moneda_extranVistaTotalSaldos() {
		return this.mostrartotal_credito_moneda_extranVistaTotalSaldos;
	}

	public void setMostrartotal_credito_moneda_extranVistaTotalSaldos(Boolean mostrartotal_credito_moneda_extranVistaTotalSaldos) {
		this.mostrartotal_credito_moneda_extranVistaTotalSaldos= mostrartotal_credito_moneda_extranVistaTotalSaldos;
	}

	public Boolean getActivartotal_credito_moneda_extranVistaTotalSaldos() {
		return this.activartotal_credito_moneda_extranVistaTotalSaldos;
	}

	public void setActivartotal_credito_moneda_extranVistaTotalSaldos(Boolean activartotal_credito_moneda_extranVistaTotalSaldos) {
		this.activartotal_credito_moneda_extranVistaTotalSaldos= activartotal_credito_moneda_extranVistaTotalSaldos;
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
		
		
		this.setMostraridVistaTotalSaldos(esInicial);
		this.setMostrarid_cuenta_contableVistaTotalSaldos(esInicial);
		this.setMostrartotal_debito_moneda_localVistaTotalSaldos(esInicial);
		this.setMostrartotal_credito_moneda_localVistaTotalSaldos(esInicial);
		this.setMostrartotal_debito_moneda_extranVistaTotalSaldos(esInicial);
		this.setMostrartotal_credito_moneda_extranVistaTotalSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.ID)) {
				this.setMostraridVistaTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableVistaTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDALOCAL)) {
				this.setMostrartotal_debito_moneda_localVistaTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDALOCAL)) {
				this.setMostrartotal_credito_moneda_localVistaTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDAEXTRAN)) {
				this.setMostrartotal_debito_moneda_extranVistaTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDAEXTRAN)) {
				this.setMostrartotal_credito_moneda_extranVistaTotalSaldos(esAsigna);
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
		
		
		this.setActivaridVistaTotalSaldos(esInicial);
		this.setActivarid_cuenta_contableVistaTotalSaldos(esInicial);
		this.setActivartotal_debito_moneda_localVistaTotalSaldos(esInicial);
		this.setActivartotal_credito_moneda_localVistaTotalSaldos(esInicial);
		this.setActivartotal_debito_moneda_extranVistaTotalSaldos(esInicial);
		this.setActivartotal_credito_moneda_extranVistaTotalSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.ID)) {
				this.setActivaridVistaTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableVistaTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDALOCAL)) {
				this.setActivartotal_debito_moneda_localVistaTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDALOCAL)) {
				this.setActivartotal_credito_moneda_localVistaTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDAEXTRAN)) {
				this.setActivartotal_debito_moneda_extranVistaTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDAEXTRAN)) {
				this.setActivartotal_credito_moneda_extranVistaTotalSaldos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VistaTotalSaldosBeanSwingJInternalFrame vistatotalsaldosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVistaTotalSaldos(esInicial);
		this.setResaltarid_cuenta_contableVistaTotalSaldos(esInicial);
		this.setResaltartotal_debito_moneda_localVistaTotalSaldos(esInicial);
		this.setResaltartotal_credito_moneda_localVistaTotalSaldos(esInicial);
		this.setResaltartotal_debito_moneda_extranVistaTotalSaldos(esInicial);
		this.setResaltartotal_credito_moneda_extranVistaTotalSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.ID)) {
				this.setResaltaridVistaTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableVistaTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDALOCAL)) {
				this.setResaltartotal_debito_moneda_localVistaTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDALOCAL)) {
				this.setResaltartotal_credito_moneda_localVistaTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.TOTALDEBITOMONEDAEXTRAN)) {
				this.setResaltartotal_debito_moneda_extranVistaTotalSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VistaTotalSaldosConstantesFunciones.TOTALCREDITOMONEDAEXTRAN)) {
				this.setResaltartotal_credito_moneda_extranVistaTotalSaldos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VistaTotalSaldosBeanSwingJInternalFrame vistatotalsaldosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContableVistaTotalSaldos=true;

	public Boolean getMostrarFK_IdCuentaContableVistaTotalSaldos() {
		return this.mostrarFK_IdCuentaContableVistaTotalSaldos;
	}

	public void setMostrarFK_IdCuentaContableVistaTotalSaldos(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableVistaTotalSaldos= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableVistaTotalSaldos=true;

	public Boolean getActivarFK_IdCuentaContableVistaTotalSaldos() {
		return this.activarFK_IdCuentaContableVistaTotalSaldos;
	}

	public void setActivarFK_IdCuentaContableVistaTotalSaldos(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableVistaTotalSaldos= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableVistaTotalSaldos=null;

	public Border getResaltarFK_IdCuentaContableVistaTotalSaldos() {
		return this.resaltarFK_IdCuentaContableVistaTotalSaldos;
	}

	public void setResaltarFK_IdCuentaContableVistaTotalSaldos(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableVistaTotalSaldos= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableVistaTotalSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*VistaTotalSaldosBeanSwingJInternalFrame vistatotalsaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableVistaTotalSaldos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}