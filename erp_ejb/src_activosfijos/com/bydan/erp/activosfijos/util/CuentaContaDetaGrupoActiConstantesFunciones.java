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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.CuentaContaDetaGrupoActiConstantesFunciones;
import com.bydan.erp.activosfijos.util.CuentaContaDetaGrupoActiParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.CuentaContaDetaGrupoActiParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CuentaContaDetaGrupoActiConstantesFunciones extends CuentaContaDetaGrupoActiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CuentaContaDetaGrupoActi";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CuentaContaDetaGrupoActi"+CuentaContaDetaGrupoActiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CuentaContaDetaGrupoActiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CuentaContaDetaGrupoActiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"_"+CuentaContaDetaGrupoActiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CuentaContaDetaGrupoActiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"_"+CuentaContaDetaGrupoActiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"_"+CuentaContaDetaGrupoActiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CuentaContaDetaGrupoActiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"_"+CuentaContaDetaGrupoActiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContaDetaGrupoActiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaContaDetaGrupoActiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContaDetaGrupoActiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContaDetaGrupoActiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaContaDetaGrupoActiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContaDetaGrupoActiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CuentaContaDetaGrupoActiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CuentaContaDetaGrupoActiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CuentaContaDetaGrupoActiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CuentaContaDetaGrupoActiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cuenta Conta Deta Grupo Actis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cuenta Conta Deta Grupo Acti";
	public static final String SCLASSWEBTITULO_LOWER="Cuenta Conta Deta Grupo Acti";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CuentaContaDetaGrupoActi";
	public static final String OBJECTNAME="cuentacontadetagrupoacti";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="cuenta_conta_deta_grupo_acti";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cuentacontadetagrupoacti from "+CuentaContaDetaGrupoActiConstantesFunciones.SPERSISTENCENAME+" cuentacontadetagrupoacti";
	public static String QUERYSELECTNATIVE="select "+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME+".id,"+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME+".version_row,"+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME+".id_detalle_grupo_activo_fijo from "+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME;//+" as "+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CuentaContaDetaGrupoActiConstantesFuncionesAdditional cuentacontadetagrupoactiConstantesFuncionesAdditional=null;
	
	public CuentaContaDetaGrupoActiConstantesFuncionesAdditional getCuentaContaDetaGrupoActiConstantesFuncionesAdditional() {
		return this.cuentacontadetagrupoactiConstantesFuncionesAdditional;
	}
	
	public void setCuentaContaDetaGrupoActiConstantesFuncionesAdditional(CuentaContaDetaGrupoActiConstantesFuncionesAdditional cuentacontadetagrupoactiConstantesFuncionesAdditional) {
		try {
			this.cuentacontadetagrupoactiConstantesFuncionesAdditional=cuentacontadetagrupoactiConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDDETALLEGRUPOACTIVOFIJO= "id_detalle_grupo_activo_fijo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDDETALLEGRUPOACTIVOFIJO= "Detalle Grupo Activo Fijo";
		public static final String LABEL_IDDETALLEGRUPOACTIVOFIJO_LOWER= "Detalle Grupo Activo Fijo";
	
		
		
		
		
	
	public static String getCuentaContaDetaGrupoActiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CuentaContaDetaGrupoActiConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=CuentaContaDetaGrupoActiConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(CuentaContaDetaGrupoActiConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {sLabelColumna=CuentaContaDetaGrupoActiConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO;}
		
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
	
	
	
			
			
			
			
	
	public static String getCuentaContaDetaGrupoActiDescripcion(CuentaContaDetaGrupoActi cuentacontadetagrupoacti) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cuentacontadetagrupoacti !=null/* && cuentacontadetagrupoacti.getId()!=0*/) {
			if(cuentacontadetagrupoacti.getId()!=null) {
				sDescripcion=cuentacontadetagrupoacti.getId().toString();
			}//cuentacontadetagrupoacticuentacontadetagrupoacti.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCuentaContaDetaGrupoActiDescripcionDetallado(CuentaContaDetaGrupoActi cuentacontadetagrupoacti) {
		String sDescripcion="";
			
		sDescripcion+=CuentaContaDetaGrupoActiConstantesFunciones.ID+"=";
		sDescripcion+=cuentacontadetagrupoacti.getId().toString()+",";
		sDescripcion+=CuentaContaDetaGrupoActiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cuentacontadetagrupoacti.getVersionRow().toString()+",";
		sDescripcion+=CuentaContaDetaGrupoActiConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=cuentacontadetagrupoacti.getid_cuenta_contable().toString()+",";
		sDescripcion+=CuentaContaDetaGrupoActiConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO+"=";
		sDescripcion+=cuentacontadetagrupoacti.getid_detalle_grupo_activo_fijo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCuentaContaDetaGrupoActiDescripcion(CuentaContaDetaGrupoActi cuentacontadetagrupoacti,String sValor) throws Exception {			
		if(cuentacontadetagrupoacti !=null) {
			//cuentacontadetagrupoacticuentacontadetagrupoacti.getId().toString();
		}		
	}
	
		

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getDetalleGrupoActivoFijoDescripcion(DetalleGrupoActivoFijo detallegrupoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detallegrupoactivofijo!=null/*&&detallegrupoactivofijo.getId()>0*/) {
			sDescripcion=DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(detallegrupoactivofijo);
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
		} else if(sNombreIndice.equals("FK_IdDetalleGrupoActivoFijo")) {
			sNombreIndice="Tipo=  Por Detalle Grupo Activo Fijo";
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

	public static String getDetalleIndiceFK_IdDetalleGrupoActivoFijo(Long id_detalle_grupo_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_grupo_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Detalle Grupo Activo Fijo="+id_detalle_grupo_activo_fijo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCuentaContaDetaGrupoActi(CuentaContaDetaGrupoActi cuentacontadetagrupoacti,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosCuentaContaDetaGrupoActis(List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti: cuentacontadetagrupoactis) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaContaDetaGrupoActi(CuentaContaDetaGrupoActi cuentacontadetagrupoacti,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cuentacontadetagrupoacti.getConCambioAuxiliar()) {
			cuentacontadetagrupoacti.setIsDeleted(cuentacontadetagrupoacti.getIsDeletedAuxiliar());	
			cuentacontadetagrupoacti.setIsNew(cuentacontadetagrupoacti.getIsNewAuxiliar());	
			cuentacontadetagrupoacti.setIsChanged(cuentacontadetagrupoacti.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cuentacontadetagrupoacti.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cuentacontadetagrupoacti.setIsDeletedAuxiliar(false);	
			cuentacontadetagrupoacti.setIsNewAuxiliar(false);	
			cuentacontadetagrupoacti.setIsChangedAuxiliar(false);
			
			cuentacontadetagrupoacti.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaContaDetaGrupoActis(List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti : cuentacontadetagrupoactis) {
			if(conAsignarBase && cuentacontadetagrupoacti.getConCambioAuxiliar()) {
				cuentacontadetagrupoacti.setIsDeleted(cuentacontadetagrupoacti.getIsDeletedAuxiliar());	
				cuentacontadetagrupoacti.setIsNew(cuentacontadetagrupoacti.getIsNewAuxiliar());	
				cuentacontadetagrupoacti.setIsChanged(cuentacontadetagrupoacti.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cuentacontadetagrupoacti.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cuentacontadetagrupoacti.setIsDeletedAuxiliar(false);	
				cuentacontadetagrupoacti.setIsNewAuxiliar(false);	
				cuentacontadetagrupoacti.setIsChangedAuxiliar(false);
				
				cuentacontadetagrupoacti.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCuentaContaDetaGrupoActi(CuentaContaDetaGrupoActi cuentacontadetagrupoacti,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCuentaContaDetaGrupoActis(List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis,Boolean conEnteros) throws Exception  {
		
		for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti: cuentacontadetagrupoactis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCuentaContaDetaGrupoActi(List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis,CuentaContaDetaGrupoActi cuentacontadetagrupoactiAux) throws Exception  {
		CuentaContaDetaGrupoActiConstantesFunciones.InicializarValoresCuentaContaDetaGrupoActi(cuentacontadetagrupoactiAux,true);
		
		for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti: cuentacontadetagrupoactis) {
			if(cuentacontadetagrupoacti.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaContaDetaGrupoActi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CuentaContaDetaGrupoActiConstantesFunciones.getArrayColumnasGlobalesCuentaContaDetaGrupoActi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaContaDetaGrupoActi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCuentaContaDetaGrupoActi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis,CuentaContaDetaGrupoActi cuentacontadetagrupoacti,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CuentaContaDetaGrupoActi cuentacontadetagrupoactiAux: cuentacontadetagrupoactis) {
			if(cuentacontadetagrupoactiAux!=null && cuentacontadetagrupoacti!=null) {
				if((cuentacontadetagrupoactiAux.getId()==null && cuentacontadetagrupoacti.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cuentacontadetagrupoactiAux.getId()!=null && cuentacontadetagrupoacti.getId()!=null){
					if(cuentacontadetagrupoactiAux.getId().equals(cuentacontadetagrupoacti.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCuentaContaDetaGrupoActi(List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti: cuentacontadetagrupoactis) {			
			if(cuentacontadetagrupoacti.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCuentaContaDetaGrupoActi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CuentaContaDetaGrupoActiConstantesFunciones.LABEL_ID, CuentaContaDetaGrupoActiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContaDetaGrupoActiConstantesFunciones.LABEL_VERSIONROW, CuentaContaDetaGrupoActiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContaDetaGrupoActiConstantesFunciones.LABEL_IDCUENTACONTABLE, CuentaContaDetaGrupoActiConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContaDetaGrupoActiConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO, CuentaContaDetaGrupoActiConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCuentaContaDetaGrupoActi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CuentaContaDetaGrupoActiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContaDetaGrupoActiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContaDetaGrupoActiConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContaDetaGrupoActiConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaContaDetaGrupoActi() throws Exception  {
		return CuentaContaDetaGrupoActiConstantesFunciones.getTiposSeleccionarCuentaContaDetaGrupoActi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaContaDetaGrupoActi(Boolean conFk) throws Exception  {
		return CuentaContaDetaGrupoActiConstantesFunciones.getTiposSeleccionarCuentaContaDetaGrupoActi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaContaDetaGrupoActi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContaDetaGrupoActiConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(CuentaContaDetaGrupoActiConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContaDetaGrupoActiConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO);
			reporte.setsDescripcion(CuentaContaDetaGrupoActiConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCuentaContaDetaGrupoActi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(CuentaContaDetaGrupoActi cuentacontadetagrupoactiAux) throws Exception {
		
			cuentacontadetagrupoactiAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontadetagrupoactiAux.getCuentaContable()));
			cuentacontadetagrupoactiAux.setdetallegrupoactivofijo_descripcion(DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(cuentacontadetagrupoactiAux.getDetalleGrupoActivoFijo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactisTemp) throws Exception {
		for(CuentaContaDetaGrupoActi cuentacontadetagrupoactiAux:cuentacontadetagrupoactisTemp) {
			
			cuentacontadetagrupoactiAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontadetagrupoactiAux.getCuentaContable()));
			cuentacontadetagrupoactiAux.setdetallegrupoactivofijo_descripcion(DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(cuentacontadetagrupoactiAux.getDetalleGrupoActivoFijo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaContaDetaGrupoActi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(DetalleGrupoActivoFijo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
						classes.add(new Classe(DetalleGrupoActivoFijo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCuentaContaDetaGrupoActi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(DetalleGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleGrupoActivoFijo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(DetalleGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleGrupoActivoFijo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaContaDetaGrupoActi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaContaDetaGrupoActiConstantesFunciones.getClassesRelationshipsOfCuentaContaDetaGrupoActi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaContaDetaGrupoActi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaContaDetaGrupoActi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaContaDetaGrupoActiConstantesFunciones.getClassesRelationshipsFromStringsOfCuentaContaDetaGrupoActi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaContaDetaGrupoActi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CuentaContaDetaGrupoActi cuentacontadetagrupoacti,List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CuentaContaDetaGrupoActi cuentacontadetagrupoactiEncontrado=null;
			
			for(CuentaContaDetaGrupoActi cuentacontadetagrupoactiLocal:cuentacontadetagrupoactis) {
				if(cuentacontadetagrupoactiLocal.getId().equals(cuentacontadetagrupoacti.getId())) {
					cuentacontadetagrupoactiEncontrado=cuentacontadetagrupoactiLocal;
					
					cuentacontadetagrupoactiLocal.setIsChanged(cuentacontadetagrupoacti.getIsChanged());
					cuentacontadetagrupoactiLocal.setIsNew(cuentacontadetagrupoacti.getIsNew());
					cuentacontadetagrupoactiLocal.setIsDeleted(cuentacontadetagrupoacti.getIsDeleted());
					
					cuentacontadetagrupoactiLocal.setGeneralEntityOriginal(cuentacontadetagrupoacti.getGeneralEntityOriginal());
					
					cuentacontadetagrupoactiLocal.setId(cuentacontadetagrupoacti.getId());	
					cuentacontadetagrupoactiLocal.setVersionRow(cuentacontadetagrupoacti.getVersionRow());	
					cuentacontadetagrupoactiLocal.setid_cuenta_contable(cuentacontadetagrupoacti.getid_cuenta_contable());	
					cuentacontadetagrupoactiLocal.setid_detalle_grupo_activo_fijo(cuentacontadetagrupoacti.getid_detalle_grupo_activo_fijo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cuentacontadetagrupoacti.getIsDeleted()) {
				if(!existe) {
					cuentacontadetagrupoactis.add(cuentacontadetagrupoacti);
				}
			} else {
				if(cuentacontadetagrupoactiEncontrado!=null && permiteQuitar)  {
					cuentacontadetagrupoactis.remove(cuentacontadetagrupoactiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CuentaContaDetaGrupoActi cuentacontadetagrupoacti,List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis) throws Exception {
		try	{			
			for(CuentaContaDetaGrupoActi cuentacontadetagrupoactiLocal:cuentacontadetagrupoactis) {
				if(cuentacontadetagrupoactiLocal.getId().equals(cuentacontadetagrupoacti.getId())) {
					cuentacontadetagrupoactiLocal.setIsSelected(cuentacontadetagrupoacti.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCuentaContaDetaGrupoActi(List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactisAux) throws Exception {
		//this.cuentacontadetagrupoactisAux=cuentacontadetagrupoactisAux;
		
		for(CuentaContaDetaGrupoActi cuentacontadetagrupoactiAux:cuentacontadetagrupoactisAux) {
			if(cuentacontadetagrupoactiAux.getIsChanged()) {
				cuentacontadetagrupoactiAux.setIsChanged(false);
			}		
			
			if(cuentacontadetagrupoactiAux.getIsNew()) {
				cuentacontadetagrupoactiAux.setIsNew(false);
			}	
			
			if(cuentacontadetagrupoactiAux.getIsDeleted()) {
				cuentacontadetagrupoactiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCuentaContaDetaGrupoActi(CuentaContaDetaGrupoActi cuentacontadetagrupoactiAux) throws Exception {
		//this.cuentacontadetagrupoactiAux=cuentacontadetagrupoactiAux;
		
			if(cuentacontadetagrupoactiAux.getIsChanged()) {
				cuentacontadetagrupoactiAux.setIsChanged(false);
			}		
			
			if(cuentacontadetagrupoactiAux.getIsNew()) {
				cuentacontadetagrupoactiAux.setIsNew(false);
			}	
			
			if(cuentacontadetagrupoactiAux.getIsDeleted()) {
				cuentacontadetagrupoactiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CuentaContaDetaGrupoActi cuentacontadetagrupoactiAsignar,CuentaContaDetaGrupoActi cuentacontadetagrupoacti) throws Exception {
		cuentacontadetagrupoactiAsignar.setId(cuentacontadetagrupoacti.getId());	
		cuentacontadetagrupoactiAsignar.setVersionRow(cuentacontadetagrupoacti.getVersionRow());	
		cuentacontadetagrupoactiAsignar.setid_cuenta_contable(cuentacontadetagrupoacti.getid_cuenta_contable());
		cuentacontadetagrupoactiAsignar.setcuentacontable_descripcion(cuentacontadetagrupoacti.getcuentacontable_descripcion());	
		cuentacontadetagrupoactiAsignar.setid_detalle_grupo_activo_fijo(cuentacontadetagrupoacti.getid_detalle_grupo_activo_fijo());
		cuentacontadetagrupoactiAsignar.setdetallegrupoactivofijo_descripcion(cuentacontadetagrupoacti.getdetallegrupoactivofijo_descripcion());	
	}
	
	public static void inicializarCuentaContaDetaGrupoActi(CuentaContaDetaGrupoActi cuentacontadetagrupoacti) throws Exception {
		try {
				cuentacontadetagrupoacti.setId(0L);	
					
				cuentacontadetagrupoacti.setid_cuenta_contable(-1L);	
				cuentacontadetagrupoacti.setid_detalle_grupo_activo_fijo(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCuentaContaDetaGrupoActi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContaDetaGrupoActiConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContaDetaGrupoActiConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCuentaContaDetaGrupoActi(String sTipo,Row row,Workbook workbook,CuentaContaDetaGrupoActi cuentacontadetagrupoacti,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontadetagrupoacti.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontadetagrupoacti.getdetallegrupoactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCuentaContaDetaGrupoActi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCuentaContaDetaGrupoActi() {
		return this.sFinalQueryCuentaContaDetaGrupoActi;
	}
	
	public void setsFinalQueryCuentaContaDetaGrupoActi(String sFinalQueryCuentaContaDetaGrupoActi) {
		this.sFinalQueryCuentaContaDetaGrupoActi= sFinalQueryCuentaContaDetaGrupoActi;
	}
	
	public Border resaltarSeleccionarCuentaContaDetaGrupoActi=null;
	
	public Border setResaltarSeleccionarCuentaContaDetaGrupoActi(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContaDetaGrupoActiBeanSwingJInternalFrame cuentacontadetagrupoactiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cuentacontadetagrupoactiBeanSwingJInternalFrame.jTtoolBarCuentaContaDetaGrupoActi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCuentaContaDetaGrupoActi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCuentaContaDetaGrupoActi() {
		return this.resaltarSeleccionarCuentaContaDetaGrupoActi;
	}
	
	public void setResaltarSeleccionarCuentaContaDetaGrupoActi(Border borderResaltarSeleccionarCuentaContaDetaGrupoActi) {
		this.resaltarSeleccionarCuentaContaDetaGrupoActi= borderResaltarSeleccionarCuentaContaDetaGrupoActi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCuentaContaDetaGrupoActi=null;
	public Boolean mostraridCuentaContaDetaGrupoActi=true;
	public Boolean activaridCuentaContaDetaGrupoActi=true;

	public Border resaltarid_cuenta_contableCuentaContaDetaGrupoActi=null;
	public Boolean mostrarid_cuenta_contableCuentaContaDetaGrupoActi=true;
	public Boolean activarid_cuenta_contableCuentaContaDetaGrupoActi=true;
	public Boolean cargarid_cuenta_contableCuentaContaDetaGrupoActi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableCuentaContaDetaGrupoActi=false;//ConEventDepend=true

	public Border resaltarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi=null;
	public Boolean mostrarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi=true;
	public Boolean activarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi=true;
	public Boolean cargarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi=false;//ConEventDepend=true

	
	

	public Border setResaltaridCuentaContaDetaGrupoActi(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContaDetaGrupoActiBeanSwingJInternalFrame cuentacontadetagrupoactiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontadetagrupoactiBeanSwingJInternalFrame.jTtoolBarCuentaContaDetaGrupoActi.setBorder(borderResaltar);
		
		this.resaltaridCuentaContaDetaGrupoActi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCuentaContaDetaGrupoActi() {
		return this.resaltaridCuentaContaDetaGrupoActi;
	}

	public void setResaltaridCuentaContaDetaGrupoActi(Border borderResaltar) {
		this.resaltaridCuentaContaDetaGrupoActi= borderResaltar;
	}

	public Boolean getMostraridCuentaContaDetaGrupoActi() {
		return this.mostraridCuentaContaDetaGrupoActi;
	}

	public void setMostraridCuentaContaDetaGrupoActi(Boolean mostraridCuentaContaDetaGrupoActi) {
		this.mostraridCuentaContaDetaGrupoActi= mostraridCuentaContaDetaGrupoActi;
	}

	public Boolean getActivaridCuentaContaDetaGrupoActi() {
		return this.activaridCuentaContaDetaGrupoActi;
	}

	public void setActivaridCuentaContaDetaGrupoActi(Boolean activaridCuentaContaDetaGrupoActi) {
		this.activaridCuentaContaDetaGrupoActi= activaridCuentaContaDetaGrupoActi;
	}

	public Border setResaltarid_cuenta_contableCuentaContaDetaGrupoActi(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContaDetaGrupoActiBeanSwingJInternalFrame cuentacontadetagrupoactiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontadetagrupoactiBeanSwingJInternalFrame.jTtoolBarCuentaContaDetaGrupoActi.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableCuentaContaDetaGrupoActi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableCuentaContaDetaGrupoActi() {
		return this.resaltarid_cuenta_contableCuentaContaDetaGrupoActi;
	}

	public void setResaltarid_cuenta_contableCuentaContaDetaGrupoActi(Border borderResaltar) {
		this.resaltarid_cuenta_contableCuentaContaDetaGrupoActi= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableCuentaContaDetaGrupoActi() {
		return this.mostrarid_cuenta_contableCuentaContaDetaGrupoActi;
	}

	public void setMostrarid_cuenta_contableCuentaContaDetaGrupoActi(Boolean mostrarid_cuenta_contableCuentaContaDetaGrupoActi) {
		this.mostrarid_cuenta_contableCuentaContaDetaGrupoActi= mostrarid_cuenta_contableCuentaContaDetaGrupoActi;
	}

	public Boolean getActivarid_cuenta_contableCuentaContaDetaGrupoActi() {
		return this.activarid_cuenta_contableCuentaContaDetaGrupoActi;
	}

	public void setActivarid_cuenta_contableCuentaContaDetaGrupoActi(Boolean activarid_cuenta_contableCuentaContaDetaGrupoActi) {
		this.activarid_cuenta_contableCuentaContaDetaGrupoActi= activarid_cuenta_contableCuentaContaDetaGrupoActi;
	}

	public Boolean getCargarid_cuenta_contableCuentaContaDetaGrupoActi() {
		return this.cargarid_cuenta_contableCuentaContaDetaGrupoActi;
	}

	public void setCargarid_cuenta_contableCuentaContaDetaGrupoActi(Boolean cargarid_cuenta_contableCuentaContaDetaGrupoActi) {
		this.cargarid_cuenta_contableCuentaContaDetaGrupoActi= cargarid_cuenta_contableCuentaContaDetaGrupoActi;
	}

	public Border setResaltarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContaDetaGrupoActiBeanSwingJInternalFrame cuentacontadetagrupoactiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontadetagrupoactiBeanSwingJInternalFrame.jTtoolBarCuentaContaDetaGrupoActi.setBorder(borderResaltar);
		
		this.resaltarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi() {
		return this.resaltarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi;
	}

	public void setResaltarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi(Border borderResaltar) {
		this.resaltarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi= borderResaltar;
	}

	public Boolean getMostrarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi() {
		return this.mostrarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi;
	}

	public void setMostrarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi(Boolean mostrarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi) {
		this.mostrarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi= mostrarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi;
	}

	public Boolean getActivarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi() {
		return this.activarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi;
	}

	public void setActivarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi(Boolean activarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi) {
		this.activarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi= activarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi;
	}

	public Boolean getCargarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi() {
		return this.cargarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi;
	}

	public void setCargarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi(Boolean cargarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi) {
		this.cargarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi= cargarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi;
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
		
		
		this.setMostraridCuentaContaDetaGrupoActi(esInicial);
		this.setMostrarid_cuenta_contableCuentaContaDetaGrupoActi(esInicial);
		this.setMostrarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaContaDetaGrupoActiConstantesFunciones.ID)) {
				this.setMostraridCuentaContaDetaGrupoActi(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContaDetaGrupoActiConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableCuentaContaDetaGrupoActi(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContaDetaGrupoActiConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {
				this.setMostrarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi(esAsigna);
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
		
		
		this.setActivaridCuentaContaDetaGrupoActi(esInicial);
		this.setActivarid_cuenta_contableCuentaContaDetaGrupoActi(esInicial);
		this.setActivarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaContaDetaGrupoActiConstantesFunciones.ID)) {
				this.setActivaridCuentaContaDetaGrupoActi(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContaDetaGrupoActiConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableCuentaContaDetaGrupoActi(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContaDetaGrupoActiConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {
				this.setActivarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaContaDetaGrupoActiBeanSwingJInternalFrame cuentacontadetagrupoactiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCuentaContaDetaGrupoActi(esInicial);
		this.setResaltarid_cuenta_contableCuentaContaDetaGrupoActi(esInicial);
		this.setResaltarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaContaDetaGrupoActiConstantesFunciones.ID)) {
				this.setResaltaridCuentaContaDetaGrupoActi(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContaDetaGrupoActiConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableCuentaContaDetaGrupoActi(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContaDetaGrupoActiConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {
				this.setResaltarid_detalle_grupo_activo_fijoCuentaContaDetaGrupoActi(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaContaDetaGrupoActiBeanSwingJInternalFrame cuentacontadetagrupoactiBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContableCuentaContaDetaGrupoActi=true;

	public Boolean getMostrarFK_IdCuentaContableCuentaContaDetaGrupoActi() {
		return this.mostrarFK_IdCuentaContableCuentaContaDetaGrupoActi;
	}

	public void setMostrarFK_IdCuentaContableCuentaContaDetaGrupoActi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCuentaContaDetaGrupoActi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi=true;

	public Boolean getMostrarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi() {
		return this.mostrarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi;
	}

	public void setMostrarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableCuentaContaDetaGrupoActi=true;

	public Boolean getActivarFK_IdCuentaContableCuentaContaDetaGrupoActi() {
		return this.activarFK_IdCuentaContableCuentaContaDetaGrupoActi;
	}

	public void setActivarFK_IdCuentaContableCuentaContaDetaGrupoActi(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCuentaContaDetaGrupoActi= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi=true;

	public Boolean getActivarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi() {
		return this.activarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi;
	}

	public void setActivarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableCuentaContaDetaGrupoActi=null;

	public Border getResaltarFK_IdCuentaContableCuentaContaDetaGrupoActi() {
		return this.resaltarFK_IdCuentaContableCuentaContaDetaGrupoActi;
	}

	public void setResaltarFK_IdCuentaContableCuentaContaDetaGrupoActi(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCuentaContaDetaGrupoActi= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCuentaContaDetaGrupoActi(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContaDetaGrupoActiBeanSwingJInternalFrame cuentacontadetagrupoactiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCuentaContaDetaGrupoActi= borderResaltar;
	}

	public Border resaltarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi=null;

	public Border getResaltarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi() {
		return this.resaltarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi;
	}

	public void setResaltarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi(Border borderResaltar) {
		this.resaltarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi= borderResaltar;
	}

	public void setResaltarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContaDetaGrupoActiBeanSwingJInternalFrame cuentacontadetagrupoactiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleGrupoActivoFijoCuentaContaDetaGrupoActi= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}