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
package com.bydan.erp.sris.util;

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


import com.bydan.erp.sris.util.CuentaCreditoFiscalConstantesFunciones;
import com.bydan.erp.sris.util.CuentaCreditoFiscalParameterReturnGeneral;
//import com.bydan.erp.sris.util.CuentaCreditoFiscalParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CuentaCreditoFiscalConstantesFunciones extends CuentaCreditoFiscalConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CuentaCreditoFiscal";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CuentaCreditoFiscal"+CuentaCreditoFiscalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CuentaCreditoFiscalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CuentaCreditoFiscalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CuentaCreditoFiscalConstantesFunciones.SCHEMA+"_"+CuentaCreditoFiscalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CuentaCreditoFiscalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CuentaCreditoFiscalConstantesFunciones.SCHEMA+"_"+CuentaCreditoFiscalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CuentaCreditoFiscalConstantesFunciones.SCHEMA+"_"+CuentaCreditoFiscalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CuentaCreditoFiscalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CuentaCreditoFiscalConstantesFunciones.SCHEMA+"_"+CuentaCreditoFiscalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaCreditoFiscalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaCreditoFiscalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaCreditoFiscalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaCreditoFiscalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaCreditoFiscalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaCreditoFiscalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CuentaCreditoFiscalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CuentaCreditoFiscalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CuentaCreditoFiscalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CuentaCreditoFiscalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cuenta Credito Fiscales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cuenta Credito Fiscal";
	public static final String SCLASSWEBTITULO_LOWER="Cuenta Credito Fiscal";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CuentaCreditoFiscal";
	public static final String OBJECTNAME="cuentacreditofiscal";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="cuenta_credito_fiscal";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cuentacreditofiscal from "+CuentaCreditoFiscalConstantesFunciones.SPERSISTENCENAME+" cuentacreditofiscal";
	public static String QUERYSELECTNATIVE="select "+CuentaCreditoFiscalConstantesFunciones.SCHEMA+"."+CuentaCreditoFiscalConstantesFunciones.TABLENAME+".id,"+CuentaCreditoFiscalConstantesFunciones.SCHEMA+"."+CuentaCreditoFiscalConstantesFunciones.TABLENAME+".version_row,"+CuentaCreditoFiscalConstantesFunciones.SCHEMA+"."+CuentaCreditoFiscalConstantesFunciones.TABLENAME+".id_empresa,"+CuentaCreditoFiscalConstantesFunciones.SCHEMA+"."+CuentaCreditoFiscalConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CuentaCreditoFiscalConstantesFunciones.SCHEMA+"."+CuentaCreditoFiscalConstantesFunciones.TABLENAME+".esta_activo from "+CuentaCreditoFiscalConstantesFunciones.SCHEMA+"."+CuentaCreditoFiscalConstantesFunciones.TABLENAME;//+" as "+CuentaCreditoFiscalConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CuentaCreditoFiscalConstantesFuncionesAdditional cuentacreditofiscalConstantesFuncionesAdditional=null;
	
	public CuentaCreditoFiscalConstantesFuncionesAdditional getCuentaCreditoFiscalConstantesFuncionesAdditional() {
		return this.cuentacreditofiscalConstantesFuncionesAdditional;
	}
	
	public void setCuentaCreditoFiscalConstantesFuncionesAdditional(CuentaCreditoFiscalConstantesFuncionesAdditional cuentacreditofiscalConstantesFuncionesAdditional) {
		try {
			this.cuentacreditofiscalConstantesFuncionesAdditional=cuentacreditofiscalConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
	
	public static String getCuentaCreditoFiscalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CuentaCreditoFiscalConstantesFunciones.IDEMPRESA)) {sLabelColumna=CuentaCreditoFiscalConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CuentaCreditoFiscalConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=CuentaCreditoFiscalConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(CuentaCreditoFiscalConstantesFunciones.ESTAACTIVO)) {sLabelColumna=CuentaCreditoFiscalConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
		
	public static String getesta_activoDescripcion(CuentaCreditoFiscal cuentacreditofiscal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cuentacreditofiscal.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(CuentaCreditoFiscal cuentacreditofiscal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cuentacreditofiscal.getId(),cuentacreditofiscal.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getCuentaCreditoFiscalDescripcion(CuentaCreditoFiscal cuentacreditofiscal) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cuentacreditofiscal !=null/* && cuentacreditofiscal.getId()!=0*/) {
			if(cuentacreditofiscal.getId()!=null) {
				sDescripcion=cuentacreditofiscal.getId().toString();
			}//cuentacreditofiscalcuentacreditofiscal.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCuentaCreditoFiscalDescripcionDetallado(CuentaCreditoFiscal cuentacreditofiscal) {
		String sDescripcion="";
			
		sDescripcion+=CuentaCreditoFiscalConstantesFunciones.ID+"=";
		sDescripcion+=cuentacreditofiscal.getId().toString()+",";
		sDescripcion+=CuentaCreditoFiscalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cuentacreditofiscal.getVersionRow().toString()+",";
		sDescripcion+=CuentaCreditoFiscalConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cuentacreditofiscal.getid_empresa().toString()+",";
		sDescripcion+=CuentaCreditoFiscalConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=cuentacreditofiscal.getid_cuenta_contable().toString()+",";
		sDescripcion+=CuentaCreditoFiscalConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=cuentacreditofiscal.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCuentaCreditoFiscalDescripcion(CuentaCreditoFiscal cuentacreditofiscal,String sValor) throws Exception {			
		if(cuentacreditofiscal !=null) {
			//cuentacreditofiscalcuentacreditofiscal.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCuentaCreditoFiscal(CuentaCreditoFiscal cuentacreditofiscal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosCuentaCreditoFiscals(List<CuentaCreditoFiscal> cuentacreditofiscals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CuentaCreditoFiscal cuentacreditofiscal: cuentacreditofiscals) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaCreditoFiscal(CuentaCreditoFiscal cuentacreditofiscal,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cuentacreditofiscal.getConCambioAuxiliar()) {
			cuentacreditofiscal.setIsDeleted(cuentacreditofiscal.getIsDeletedAuxiliar());	
			cuentacreditofiscal.setIsNew(cuentacreditofiscal.getIsNewAuxiliar());	
			cuentacreditofiscal.setIsChanged(cuentacreditofiscal.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cuentacreditofiscal.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cuentacreditofiscal.setIsDeletedAuxiliar(false);	
			cuentacreditofiscal.setIsNewAuxiliar(false);	
			cuentacreditofiscal.setIsChangedAuxiliar(false);
			
			cuentacreditofiscal.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaCreditoFiscals(List<CuentaCreditoFiscal> cuentacreditofiscals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CuentaCreditoFiscal cuentacreditofiscal : cuentacreditofiscals) {
			if(conAsignarBase && cuentacreditofiscal.getConCambioAuxiliar()) {
				cuentacreditofiscal.setIsDeleted(cuentacreditofiscal.getIsDeletedAuxiliar());	
				cuentacreditofiscal.setIsNew(cuentacreditofiscal.getIsNewAuxiliar());	
				cuentacreditofiscal.setIsChanged(cuentacreditofiscal.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cuentacreditofiscal.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cuentacreditofiscal.setIsDeletedAuxiliar(false);	
				cuentacreditofiscal.setIsNewAuxiliar(false);	
				cuentacreditofiscal.setIsChangedAuxiliar(false);
				
				cuentacreditofiscal.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCuentaCreditoFiscal(CuentaCreditoFiscal cuentacreditofiscal,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCuentaCreditoFiscals(List<CuentaCreditoFiscal> cuentacreditofiscals,Boolean conEnteros) throws Exception  {
		
		for(CuentaCreditoFiscal cuentacreditofiscal: cuentacreditofiscals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCuentaCreditoFiscal(List<CuentaCreditoFiscal> cuentacreditofiscals,CuentaCreditoFiscal cuentacreditofiscalAux) throws Exception  {
		CuentaCreditoFiscalConstantesFunciones.InicializarValoresCuentaCreditoFiscal(cuentacreditofiscalAux,true);
		
		for(CuentaCreditoFiscal cuentacreditofiscal: cuentacreditofiscals) {
			if(cuentacreditofiscal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaCreditoFiscal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CuentaCreditoFiscalConstantesFunciones.getArrayColumnasGlobalesCuentaCreditoFiscal(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaCreditoFiscal(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentaCreditoFiscalConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentaCreditoFiscalConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCuentaCreditoFiscal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CuentaCreditoFiscal> cuentacreditofiscals,CuentaCreditoFiscal cuentacreditofiscal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CuentaCreditoFiscal cuentacreditofiscalAux: cuentacreditofiscals) {
			if(cuentacreditofiscalAux!=null && cuentacreditofiscal!=null) {
				if((cuentacreditofiscalAux.getId()==null && cuentacreditofiscal.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cuentacreditofiscalAux.getId()!=null && cuentacreditofiscal.getId()!=null){
					if(cuentacreditofiscalAux.getId().equals(cuentacreditofiscal.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCuentaCreditoFiscal(List<CuentaCreditoFiscal> cuentacreditofiscals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CuentaCreditoFiscal cuentacreditofiscal: cuentacreditofiscals) {			
			if(cuentacreditofiscal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCuentaCreditoFiscal() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CuentaCreditoFiscalConstantesFunciones.LABEL_ID, CuentaCreditoFiscalConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaCreditoFiscalConstantesFunciones.LABEL_VERSIONROW, CuentaCreditoFiscalConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaCreditoFiscalConstantesFunciones.LABEL_IDEMPRESA, CuentaCreditoFiscalConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaCreditoFiscalConstantesFunciones.LABEL_IDCUENTACONTABLE, CuentaCreditoFiscalConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaCreditoFiscalConstantesFunciones.LABEL_ESTAACTIVO, CuentaCreditoFiscalConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCuentaCreditoFiscal() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CuentaCreditoFiscalConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaCreditoFiscalConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaCreditoFiscalConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaCreditoFiscalConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaCreditoFiscalConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaCreditoFiscal() throws Exception  {
		return CuentaCreditoFiscalConstantesFunciones.getTiposSeleccionarCuentaCreditoFiscal(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaCreditoFiscal(Boolean conFk) throws Exception  {
		return CuentaCreditoFiscalConstantesFunciones.getTiposSeleccionarCuentaCreditoFiscal(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaCreditoFiscal(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaCreditoFiscalConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CuentaCreditoFiscalConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaCreditoFiscalConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(CuentaCreditoFiscalConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaCreditoFiscalConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(CuentaCreditoFiscalConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCuentaCreditoFiscal(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaCreditoFiscal(CuentaCreditoFiscal cuentacreditofiscalAux) throws Exception {
		
			cuentacreditofiscalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentacreditofiscalAux.getEmpresa()));
			cuentacreditofiscalAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacreditofiscalAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaCreditoFiscal(List<CuentaCreditoFiscal> cuentacreditofiscalsTemp) throws Exception {
		for(CuentaCreditoFiscal cuentacreditofiscalAux:cuentacreditofiscalsTemp) {
			
			cuentacreditofiscalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentacreditofiscalAux.getEmpresa()));
			cuentacreditofiscalAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacreditofiscalAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaCreditoFiscal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCuentaCreditoFiscal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaCreditoFiscal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaCreditoFiscalConstantesFunciones.getClassesRelationshipsOfCuentaCreditoFiscal(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaCreditoFiscal(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaCreditoFiscal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaCreditoFiscalConstantesFunciones.getClassesRelationshipsFromStringsOfCuentaCreditoFiscal(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaCreditoFiscal(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CuentaCreditoFiscal cuentacreditofiscal,List<CuentaCreditoFiscal> cuentacreditofiscals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CuentaCreditoFiscal cuentacreditofiscalEncontrado=null;
			
			for(CuentaCreditoFiscal cuentacreditofiscalLocal:cuentacreditofiscals) {
				if(cuentacreditofiscalLocal.getId().equals(cuentacreditofiscal.getId())) {
					cuentacreditofiscalEncontrado=cuentacreditofiscalLocal;
					
					cuentacreditofiscalLocal.setIsChanged(cuentacreditofiscal.getIsChanged());
					cuentacreditofiscalLocal.setIsNew(cuentacreditofiscal.getIsNew());
					cuentacreditofiscalLocal.setIsDeleted(cuentacreditofiscal.getIsDeleted());
					
					cuentacreditofiscalLocal.setGeneralEntityOriginal(cuentacreditofiscal.getGeneralEntityOriginal());
					
					cuentacreditofiscalLocal.setId(cuentacreditofiscal.getId());	
					cuentacreditofiscalLocal.setVersionRow(cuentacreditofiscal.getVersionRow());	
					cuentacreditofiscalLocal.setid_empresa(cuentacreditofiscal.getid_empresa());	
					cuentacreditofiscalLocal.setid_cuenta_contable(cuentacreditofiscal.getid_cuenta_contable());	
					cuentacreditofiscalLocal.setesta_activo(cuentacreditofiscal.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cuentacreditofiscal.getIsDeleted()) {
				if(!existe) {
					cuentacreditofiscals.add(cuentacreditofiscal);
				}
			} else {
				if(cuentacreditofiscalEncontrado!=null && permiteQuitar)  {
					cuentacreditofiscals.remove(cuentacreditofiscalEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CuentaCreditoFiscal cuentacreditofiscal,List<CuentaCreditoFiscal> cuentacreditofiscals) throws Exception {
		try	{			
			for(CuentaCreditoFiscal cuentacreditofiscalLocal:cuentacreditofiscals) {
				if(cuentacreditofiscalLocal.getId().equals(cuentacreditofiscal.getId())) {
					cuentacreditofiscalLocal.setIsSelected(cuentacreditofiscal.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCuentaCreditoFiscal(List<CuentaCreditoFiscal> cuentacreditofiscalsAux) throws Exception {
		//this.cuentacreditofiscalsAux=cuentacreditofiscalsAux;
		
		for(CuentaCreditoFiscal cuentacreditofiscalAux:cuentacreditofiscalsAux) {
			if(cuentacreditofiscalAux.getIsChanged()) {
				cuentacreditofiscalAux.setIsChanged(false);
			}		
			
			if(cuentacreditofiscalAux.getIsNew()) {
				cuentacreditofiscalAux.setIsNew(false);
			}	
			
			if(cuentacreditofiscalAux.getIsDeleted()) {
				cuentacreditofiscalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCuentaCreditoFiscal(CuentaCreditoFiscal cuentacreditofiscalAux) throws Exception {
		//this.cuentacreditofiscalAux=cuentacreditofiscalAux;
		
			if(cuentacreditofiscalAux.getIsChanged()) {
				cuentacreditofiscalAux.setIsChanged(false);
			}		
			
			if(cuentacreditofiscalAux.getIsNew()) {
				cuentacreditofiscalAux.setIsNew(false);
			}	
			
			if(cuentacreditofiscalAux.getIsDeleted()) {
				cuentacreditofiscalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CuentaCreditoFiscal cuentacreditofiscalAsignar,CuentaCreditoFiscal cuentacreditofiscal) throws Exception {
		cuentacreditofiscalAsignar.setId(cuentacreditofiscal.getId());	
		cuentacreditofiscalAsignar.setVersionRow(cuentacreditofiscal.getVersionRow());	
		cuentacreditofiscalAsignar.setid_empresa(cuentacreditofiscal.getid_empresa());
		cuentacreditofiscalAsignar.setempresa_descripcion(cuentacreditofiscal.getempresa_descripcion());	
		cuentacreditofiscalAsignar.setid_cuenta_contable(cuentacreditofiscal.getid_cuenta_contable());
		cuentacreditofiscalAsignar.setcuentacontable_descripcion(cuentacreditofiscal.getcuentacontable_descripcion());	
		cuentacreditofiscalAsignar.setesta_activo(cuentacreditofiscal.getesta_activo());	
	}
	
	public static void inicializarCuentaCreditoFiscal(CuentaCreditoFiscal cuentacreditofiscal) throws Exception {
		try {
				cuentacreditofiscal.setId(0L);	
					
				cuentacreditofiscal.setid_empresa(-1L);	
				cuentacreditofiscal.setid_cuenta_contable(-1L);	
				cuentacreditofiscal.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCuentaCreditoFiscal(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaCreditoFiscalConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaCreditoFiscalConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaCreditoFiscalConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCuentaCreditoFiscal(String sTipo,Row row,Workbook workbook,CuentaCreditoFiscal cuentacreditofiscal,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacreditofiscal.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacreditofiscal.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cuentacreditofiscal.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCuentaCreditoFiscal=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCuentaCreditoFiscal() {
		return this.sFinalQueryCuentaCreditoFiscal;
	}
	
	public void setsFinalQueryCuentaCreditoFiscal(String sFinalQueryCuentaCreditoFiscal) {
		this.sFinalQueryCuentaCreditoFiscal= sFinalQueryCuentaCreditoFiscal;
	}
	
	public Border resaltarSeleccionarCuentaCreditoFiscal=null;
	
	public Border setResaltarSeleccionarCuentaCreditoFiscal(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaCreditoFiscalBeanSwingJInternalFrame cuentacreditofiscalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cuentacreditofiscalBeanSwingJInternalFrame.jTtoolBarCuentaCreditoFiscal.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCuentaCreditoFiscal= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCuentaCreditoFiscal() {
		return this.resaltarSeleccionarCuentaCreditoFiscal;
	}
	
	public void setResaltarSeleccionarCuentaCreditoFiscal(Border borderResaltarSeleccionarCuentaCreditoFiscal) {
		this.resaltarSeleccionarCuentaCreditoFiscal= borderResaltarSeleccionarCuentaCreditoFiscal;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCuentaCreditoFiscal=null;
	public Boolean mostraridCuentaCreditoFiscal=true;
	public Boolean activaridCuentaCreditoFiscal=true;

	public Border resaltarid_empresaCuentaCreditoFiscal=null;
	public Boolean mostrarid_empresaCuentaCreditoFiscal=true;
	public Boolean activarid_empresaCuentaCreditoFiscal=true;
	public Boolean cargarid_empresaCuentaCreditoFiscal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCuentaCreditoFiscal=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableCuentaCreditoFiscal=null;
	public Boolean mostrarid_cuenta_contableCuentaCreditoFiscal=true;
	public Boolean activarid_cuenta_contableCuentaCreditoFiscal=true;
	public Boolean cargarid_cuenta_contableCuentaCreditoFiscal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableCuentaCreditoFiscal=false;//ConEventDepend=true

	public Border resaltaresta_activoCuentaCreditoFiscal=null;
	public Boolean mostraresta_activoCuentaCreditoFiscal=true;
	public Boolean activaresta_activoCuentaCreditoFiscal=true;

	
	

	public Border setResaltaridCuentaCreditoFiscal(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaCreditoFiscalBeanSwingJInternalFrame cuentacreditofiscalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacreditofiscalBeanSwingJInternalFrame.jTtoolBarCuentaCreditoFiscal.setBorder(borderResaltar);
		
		this.resaltaridCuentaCreditoFiscal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCuentaCreditoFiscal() {
		return this.resaltaridCuentaCreditoFiscal;
	}

	public void setResaltaridCuentaCreditoFiscal(Border borderResaltar) {
		this.resaltaridCuentaCreditoFiscal= borderResaltar;
	}

	public Boolean getMostraridCuentaCreditoFiscal() {
		return this.mostraridCuentaCreditoFiscal;
	}

	public void setMostraridCuentaCreditoFiscal(Boolean mostraridCuentaCreditoFiscal) {
		this.mostraridCuentaCreditoFiscal= mostraridCuentaCreditoFiscal;
	}

	public Boolean getActivaridCuentaCreditoFiscal() {
		return this.activaridCuentaCreditoFiscal;
	}

	public void setActivaridCuentaCreditoFiscal(Boolean activaridCuentaCreditoFiscal) {
		this.activaridCuentaCreditoFiscal= activaridCuentaCreditoFiscal;
	}

	public Border setResaltarid_empresaCuentaCreditoFiscal(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaCreditoFiscalBeanSwingJInternalFrame cuentacreditofiscalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacreditofiscalBeanSwingJInternalFrame.jTtoolBarCuentaCreditoFiscal.setBorder(borderResaltar);
		
		this.resaltarid_empresaCuentaCreditoFiscal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCuentaCreditoFiscal() {
		return this.resaltarid_empresaCuentaCreditoFiscal;
	}

	public void setResaltarid_empresaCuentaCreditoFiscal(Border borderResaltar) {
		this.resaltarid_empresaCuentaCreditoFiscal= borderResaltar;
	}

	public Boolean getMostrarid_empresaCuentaCreditoFiscal() {
		return this.mostrarid_empresaCuentaCreditoFiscal;
	}

	public void setMostrarid_empresaCuentaCreditoFiscal(Boolean mostrarid_empresaCuentaCreditoFiscal) {
		this.mostrarid_empresaCuentaCreditoFiscal= mostrarid_empresaCuentaCreditoFiscal;
	}

	public Boolean getActivarid_empresaCuentaCreditoFiscal() {
		return this.activarid_empresaCuentaCreditoFiscal;
	}

	public void setActivarid_empresaCuentaCreditoFiscal(Boolean activarid_empresaCuentaCreditoFiscal) {
		this.activarid_empresaCuentaCreditoFiscal= activarid_empresaCuentaCreditoFiscal;
	}

	public Boolean getCargarid_empresaCuentaCreditoFiscal() {
		return this.cargarid_empresaCuentaCreditoFiscal;
	}

	public void setCargarid_empresaCuentaCreditoFiscal(Boolean cargarid_empresaCuentaCreditoFiscal) {
		this.cargarid_empresaCuentaCreditoFiscal= cargarid_empresaCuentaCreditoFiscal;
	}

	public Border setResaltarid_cuenta_contableCuentaCreditoFiscal(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaCreditoFiscalBeanSwingJInternalFrame cuentacreditofiscalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacreditofiscalBeanSwingJInternalFrame.jTtoolBarCuentaCreditoFiscal.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableCuentaCreditoFiscal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableCuentaCreditoFiscal() {
		return this.resaltarid_cuenta_contableCuentaCreditoFiscal;
	}

	public void setResaltarid_cuenta_contableCuentaCreditoFiscal(Border borderResaltar) {
		this.resaltarid_cuenta_contableCuentaCreditoFiscal= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableCuentaCreditoFiscal() {
		return this.mostrarid_cuenta_contableCuentaCreditoFiscal;
	}

	public void setMostrarid_cuenta_contableCuentaCreditoFiscal(Boolean mostrarid_cuenta_contableCuentaCreditoFiscal) {
		this.mostrarid_cuenta_contableCuentaCreditoFiscal= mostrarid_cuenta_contableCuentaCreditoFiscal;
	}

	public Boolean getActivarid_cuenta_contableCuentaCreditoFiscal() {
		return this.activarid_cuenta_contableCuentaCreditoFiscal;
	}

	public void setActivarid_cuenta_contableCuentaCreditoFiscal(Boolean activarid_cuenta_contableCuentaCreditoFiscal) {
		this.activarid_cuenta_contableCuentaCreditoFiscal= activarid_cuenta_contableCuentaCreditoFiscal;
	}

	public Boolean getCargarid_cuenta_contableCuentaCreditoFiscal() {
		return this.cargarid_cuenta_contableCuentaCreditoFiscal;
	}

	public void setCargarid_cuenta_contableCuentaCreditoFiscal(Boolean cargarid_cuenta_contableCuentaCreditoFiscal) {
		this.cargarid_cuenta_contableCuentaCreditoFiscal= cargarid_cuenta_contableCuentaCreditoFiscal;
	}

	public Border setResaltaresta_activoCuentaCreditoFiscal(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaCreditoFiscalBeanSwingJInternalFrame cuentacreditofiscalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacreditofiscalBeanSwingJInternalFrame.jTtoolBarCuentaCreditoFiscal.setBorder(borderResaltar);
		
		this.resaltaresta_activoCuentaCreditoFiscal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoCuentaCreditoFiscal() {
		return this.resaltaresta_activoCuentaCreditoFiscal;
	}

	public void setResaltaresta_activoCuentaCreditoFiscal(Border borderResaltar) {
		this.resaltaresta_activoCuentaCreditoFiscal= borderResaltar;
	}

	public Boolean getMostraresta_activoCuentaCreditoFiscal() {
		return this.mostraresta_activoCuentaCreditoFiscal;
	}

	public void setMostraresta_activoCuentaCreditoFiscal(Boolean mostraresta_activoCuentaCreditoFiscal) {
		this.mostraresta_activoCuentaCreditoFiscal= mostraresta_activoCuentaCreditoFiscal;
	}

	public Boolean getActivaresta_activoCuentaCreditoFiscal() {
		return this.activaresta_activoCuentaCreditoFiscal;
	}

	public void setActivaresta_activoCuentaCreditoFiscal(Boolean activaresta_activoCuentaCreditoFiscal) {
		this.activaresta_activoCuentaCreditoFiscal= activaresta_activoCuentaCreditoFiscal;
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
		
		
		this.setMostraridCuentaCreditoFiscal(esInicial);
		this.setMostrarid_empresaCuentaCreditoFiscal(esInicial);
		this.setMostrarid_cuenta_contableCuentaCreditoFiscal(esInicial);
		this.setMostraresta_activoCuentaCreditoFiscal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaCreditoFiscalConstantesFunciones.ID)) {
				this.setMostraridCuentaCreditoFiscal(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaCreditoFiscalConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCuentaCreditoFiscal(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaCreditoFiscalConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableCuentaCreditoFiscal(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaCreditoFiscalConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoCuentaCreditoFiscal(esAsigna);
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
		
		
		this.setActivaridCuentaCreditoFiscal(esInicial);
		this.setActivarid_empresaCuentaCreditoFiscal(esInicial);
		this.setActivarid_cuenta_contableCuentaCreditoFiscal(esInicial);
		this.setActivaresta_activoCuentaCreditoFiscal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaCreditoFiscalConstantesFunciones.ID)) {
				this.setActivaridCuentaCreditoFiscal(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaCreditoFiscalConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCuentaCreditoFiscal(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaCreditoFiscalConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableCuentaCreditoFiscal(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaCreditoFiscalConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoCuentaCreditoFiscal(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaCreditoFiscalBeanSwingJInternalFrame cuentacreditofiscalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCuentaCreditoFiscal(esInicial);
		this.setResaltarid_empresaCuentaCreditoFiscal(esInicial);
		this.setResaltarid_cuenta_contableCuentaCreditoFiscal(esInicial);
		this.setResaltaresta_activoCuentaCreditoFiscal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaCreditoFiscalConstantesFunciones.ID)) {
				this.setResaltaridCuentaCreditoFiscal(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaCreditoFiscalConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCuentaCreditoFiscal(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaCreditoFiscalConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableCuentaCreditoFiscal(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaCreditoFiscalConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoCuentaCreditoFiscal(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaCreditoFiscalBeanSwingJInternalFrame cuentacreditofiscalBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContableCuentaCreditoFiscal=true;

	public Boolean getMostrarFK_IdCuentaContableCuentaCreditoFiscal() {
		return this.mostrarFK_IdCuentaContableCuentaCreditoFiscal;
	}

	public void setMostrarFK_IdCuentaContableCuentaCreditoFiscal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCuentaCreditoFiscal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCuentaCreditoFiscal=true;

	public Boolean getMostrarFK_IdEmpresaCuentaCreditoFiscal() {
		return this.mostrarFK_IdEmpresaCuentaCreditoFiscal;
	}

	public void setMostrarFK_IdEmpresaCuentaCreditoFiscal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCuentaCreditoFiscal= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableCuentaCreditoFiscal=true;

	public Boolean getActivarFK_IdCuentaContableCuentaCreditoFiscal() {
		return this.activarFK_IdCuentaContableCuentaCreditoFiscal;
	}

	public void setActivarFK_IdCuentaContableCuentaCreditoFiscal(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCuentaCreditoFiscal= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCuentaCreditoFiscal=true;

	public Boolean getActivarFK_IdEmpresaCuentaCreditoFiscal() {
		return this.activarFK_IdEmpresaCuentaCreditoFiscal;
	}

	public void setActivarFK_IdEmpresaCuentaCreditoFiscal(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCuentaCreditoFiscal= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableCuentaCreditoFiscal=null;

	public Border getResaltarFK_IdCuentaContableCuentaCreditoFiscal() {
		return this.resaltarFK_IdCuentaContableCuentaCreditoFiscal;
	}

	public void setResaltarFK_IdCuentaContableCuentaCreditoFiscal(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCuentaCreditoFiscal= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCuentaCreditoFiscal(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaCreditoFiscalBeanSwingJInternalFrame cuentacreditofiscalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCuentaCreditoFiscal= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCuentaCreditoFiscal=null;

	public Border getResaltarFK_IdEmpresaCuentaCreditoFiscal() {
		return this.resaltarFK_IdEmpresaCuentaCreditoFiscal;
	}

	public void setResaltarFK_IdEmpresaCuentaCreditoFiscal(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCuentaCreditoFiscal= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCuentaCreditoFiscal(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaCreditoFiscalBeanSwingJInternalFrame cuentacreditofiscalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCuentaCreditoFiscal= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}