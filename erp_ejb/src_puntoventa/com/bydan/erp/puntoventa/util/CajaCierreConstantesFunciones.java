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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.CajaCierreConstantesFunciones;
import com.bydan.erp.puntoventa.util.CajaCierreParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CajaCierreParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CajaCierreConstantesFunciones extends CajaCierreConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CajaCierre";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CajaCierre"+CajaCierreConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CajaCierreHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CajaCierreHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CajaCierreConstantesFunciones.SCHEMA+"_"+CajaCierreConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CajaCierreHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CajaCierreConstantesFunciones.SCHEMA+"_"+CajaCierreConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CajaCierreConstantesFunciones.SCHEMA+"_"+CajaCierreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CajaCierreHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CajaCierreConstantesFunciones.SCHEMA+"_"+CajaCierreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaCierreConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaCierreHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaCierreConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaCierreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaCierreHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaCierreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CajaCierreConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CajaCierreConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CajaCierreConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CajaCierreConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Caja Cierres";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Caja Cierre";
	public static final String SCLASSWEBTITULO_LOWER="Caja Cierre";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CajaCierre";
	public static final String OBJECTNAME="cajacierre";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="caja_cierre";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cajacierre from "+CajaCierreConstantesFunciones.SPERSISTENCENAME+" cajacierre";
	public static String QUERYSELECTNATIVE="select "+CajaCierreConstantesFunciones.SCHEMA+"."+CajaCierreConstantesFunciones.TABLENAME+".id,"+CajaCierreConstantesFunciones.SCHEMA+"."+CajaCierreConstantesFunciones.TABLENAME+".version_row,"+CajaCierreConstantesFunciones.SCHEMA+"."+CajaCierreConstantesFunciones.TABLENAME+".id_empresa,"+CajaCierreConstantesFunciones.SCHEMA+"."+CajaCierreConstantesFunciones.TABLENAME+".id_sucursal,"+CajaCierreConstantesFunciones.SCHEMA+"."+CajaCierreConstantesFunciones.TABLENAME+".id_caja,"+CajaCierreConstantesFunciones.SCHEMA+"."+CajaCierreConstantesFunciones.TABLENAME+".fecha_cierre,"+CajaCierreConstantesFunciones.SCHEMA+"."+CajaCierreConstantesFunciones.TABLENAME+".hora_cierre,"+CajaCierreConstantesFunciones.SCHEMA+"."+CajaCierreConstantesFunciones.TABLENAME+".esta_activo from "+CajaCierreConstantesFunciones.SCHEMA+"."+CajaCierreConstantesFunciones.TABLENAME;//+" as "+CajaCierreConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CajaCierreConstantesFuncionesAdditional cajacierreConstantesFuncionesAdditional=null;
	
	public CajaCierreConstantesFuncionesAdditional getCajaCierreConstantesFuncionesAdditional() {
		return this.cajacierreConstantesFuncionesAdditional;
	}
	
	public void setCajaCierreConstantesFuncionesAdditional(CajaCierreConstantesFuncionesAdditional cajacierreConstantesFuncionesAdditional) {
		try {
			this.cajacierreConstantesFuncionesAdditional=cajacierreConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCAJA= "id_caja";
    public static final String FECHACIERRE= "fecha_cierre";
    public static final String HORACIERRE= "hora_cierre";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCAJA= "Caja";
		public static final String LABEL_IDCAJA_LOWER= "Caja";
    	public static final String LABEL_FECHACIERRE= "Fecha Cierre";
		public static final String LABEL_FECHACIERRE_LOWER= "Fecha Cierre";
    	public static final String LABEL_HORACIERRE= "Hora Cierre";
		public static final String LABEL_HORACIERRE_LOWER= "Hora Cierre";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
		
		
	
	public static String getCajaCierreLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CajaCierreConstantesFunciones.IDEMPRESA)) {sLabelColumna=CajaCierreConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CajaCierreConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CajaCierreConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CajaCierreConstantesFunciones.IDCAJA)) {sLabelColumna=CajaCierreConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(CajaCierreConstantesFunciones.FECHACIERRE)) {sLabelColumna=CajaCierreConstantesFunciones.LABEL_FECHACIERRE;}
		if(sNombreColumna.equals(CajaCierreConstantesFunciones.HORACIERRE)) {sLabelColumna=CajaCierreConstantesFunciones.LABEL_HORACIERRE;}
		if(sNombreColumna.equals(CajaCierreConstantesFunciones.ESTAACTIVO)) {sLabelColumna=CajaCierreConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(CajaCierre cajacierre) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cajacierre.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(CajaCierre cajacierre) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cajacierre.getId(),cajacierre.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getCajaCierreDescripcion(CajaCierre cajacierre) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cajacierre !=null/* && cajacierre.getId()!=0*/) {
			if(cajacierre.getId()!=null) {
				sDescripcion=cajacierre.getId().toString();
			}//cajacierrecajacierre.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCajaCierreDescripcionDetallado(CajaCierre cajacierre) {
		String sDescripcion="";
			
		sDescripcion+=CajaCierreConstantesFunciones.ID+"=";
		sDescripcion+=cajacierre.getId().toString()+",";
		sDescripcion+=CajaCierreConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cajacierre.getVersionRow().toString()+",";
		sDescripcion+=CajaCierreConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cajacierre.getid_empresa().toString()+",";
		sDescripcion+=CajaCierreConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cajacierre.getid_sucursal().toString()+",";
		sDescripcion+=CajaCierreConstantesFunciones.IDCAJA+"=";
		sDescripcion+=cajacierre.getid_caja().toString()+",";
		sDescripcion+=CajaCierreConstantesFunciones.FECHACIERRE+"=";
		sDescripcion+=cajacierre.getfecha_cierre().toString()+",";
		sDescripcion+=CajaCierreConstantesFunciones.HORACIERRE+"=";
		sDescripcion+=cajacierre.gethora_cierre().toString()+",";
		sDescripcion+=CajaCierreConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=cajacierre.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCajaCierreDescripcion(CajaCierre cajacierre,String sValor) throws Exception {			
		if(cajacierre !=null) {
			//cajacierrecajacierre.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getCajaDescripcion(Caja caja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(caja!=null/*&&caja.getId()>0*/) {
			sDescripcion=CajaConstantesFunciones.getCajaDescripcion(caja);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCaja")) {
			sNombreIndice="Tipo=  Por Caja";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCaja(Long id_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCajaCierre(CajaCierre cajacierre,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosCajaCierres(List<CajaCierre> cajacierres,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CajaCierre cajacierre: cajacierres) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajaCierre(CajaCierre cajacierre,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cajacierre.getConCambioAuxiliar()) {
			cajacierre.setIsDeleted(cajacierre.getIsDeletedAuxiliar());	
			cajacierre.setIsNew(cajacierre.getIsNewAuxiliar());	
			cajacierre.setIsChanged(cajacierre.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cajacierre.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cajacierre.setIsDeletedAuxiliar(false);	
			cajacierre.setIsNewAuxiliar(false);	
			cajacierre.setIsChangedAuxiliar(false);
			
			cajacierre.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajaCierres(List<CajaCierre> cajacierres,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CajaCierre cajacierre : cajacierres) {
			if(conAsignarBase && cajacierre.getConCambioAuxiliar()) {
				cajacierre.setIsDeleted(cajacierre.getIsDeletedAuxiliar());	
				cajacierre.setIsNew(cajacierre.getIsNewAuxiliar());	
				cajacierre.setIsChanged(cajacierre.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cajacierre.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cajacierre.setIsDeletedAuxiliar(false);	
				cajacierre.setIsNewAuxiliar(false);	
				cajacierre.setIsChangedAuxiliar(false);
				
				cajacierre.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCajaCierre(CajaCierre cajacierre,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCajaCierres(List<CajaCierre> cajacierres,Boolean conEnteros) throws Exception  {
		
		for(CajaCierre cajacierre: cajacierres) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCajaCierre(List<CajaCierre> cajacierres,CajaCierre cajacierreAux) throws Exception  {
		CajaCierreConstantesFunciones.InicializarValoresCajaCierre(cajacierreAux,true);
		
		for(CajaCierre cajacierre: cajacierres) {
			if(cajacierre.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaCierre(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CajaCierreConstantesFunciones.getArrayColumnasGlobalesCajaCierre(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaCierre(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaCierreConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaCierreConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaCierreConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaCierreConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCajaCierre(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CajaCierre> cajacierres,CajaCierre cajacierre,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CajaCierre cajacierreAux: cajacierres) {
			if(cajacierreAux!=null && cajacierre!=null) {
				if((cajacierreAux.getId()==null && cajacierre.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cajacierreAux.getId()!=null && cajacierre.getId()!=null){
					if(cajacierreAux.getId().equals(cajacierre.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCajaCierre(List<CajaCierre> cajacierres) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CajaCierre cajacierre: cajacierres) {			
			if(cajacierre.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCajaCierre() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CajaCierreConstantesFunciones.LABEL_ID, CajaCierreConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaCierreConstantesFunciones.LABEL_VERSIONROW, CajaCierreConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaCierreConstantesFunciones.LABEL_IDEMPRESA, CajaCierreConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaCierreConstantesFunciones.LABEL_IDSUCURSAL, CajaCierreConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaCierreConstantesFunciones.LABEL_IDCAJA, CajaCierreConstantesFunciones.IDCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaCierreConstantesFunciones.LABEL_FECHACIERRE, CajaCierreConstantesFunciones.FECHACIERRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaCierreConstantesFunciones.LABEL_HORACIERRE, CajaCierreConstantesFunciones.HORACIERRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaCierreConstantesFunciones.LABEL_ESTAACTIVO, CajaCierreConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCajaCierre() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CajaCierreConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaCierreConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaCierreConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaCierreConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaCierreConstantesFunciones.IDCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaCierreConstantesFunciones.FECHACIERRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaCierreConstantesFunciones.HORACIERRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaCierreConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaCierre() throws Exception  {
		return CajaCierreConstantesFunciones.getTiposSeleccionarCajaCierre(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaCierre(Boolean conFk) throws Exception  {
		return CajaCierreConstantesFunciones.getTiposSeleccionarCajaCierre(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaCierre(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaCierreConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CajaCierreConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaCierreConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CajaCierreConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaCierreConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(CajaCierreConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaCierreConstantesFunciones.LABEL_FECHACIERRE);
			reporte.setsDescripcion(CajaCierreConstantesFunciones.LABEL_FECHACIERRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(CajaCierreConstantesFunciones.LABEL_HORACIERRE);
		reporte.setsDescripcion(CajaCierreConstantesFunciones.LABEL_HORACIERRE);

		arrTiposSeleccionarTodos.add(reporte);
		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaCierreConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(CajaCierreConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCajaCierre(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCajaCierre(CajaCierre cajacierreAux) throws Exception {
		
			cajacierreAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajacierreAux.getEmpresa()));
			cajacierreAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajacierreAux.getSucursal()));
			cajacierreAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(cajacierreAux.getCaja()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCajaCierre(List<CajaCierre> cajacierresTemp) throws Exception {
		for(CajaCierre cajacierreAux:cajacierresTemp) {
			
			cajacierreAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajacierreAux.getEmpresa()));
			cajacierreAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajacierreAux.getSucursal()));
			cajacierreAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(cajacierreAux.getCaja()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCajaCierre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Caja.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Caja.class)) {
						classes.add(new Classe(Caja.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCajaCierre(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaCierre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaCierreConstantesFunciones.getClassesRelationshipsOfCajaCierre(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaCierre(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajaCierre(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaCierreConstantesFunciones.getClassesRelationshipsFromStringsOfCajaCierre(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajaCierre(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CajaCierre cajacierre,List<CajaCierre> cajacierres,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CajaCierre cajacierreEncontrado=null;
			
			for(CajaCierre cajacierreLocal:cajacierres) {
				if(cajacierreLocal.getId().equals(cajacierre.getId())) {
					cajacierreEncontrado=cajacierreLocal;
					
					cajacierreLocal.setIsChanged(cajacierre.getIsChanged());
					cajacierreLocal.setIsNew(cajacierre.getIsNew());
					cajacierreLocal.setIsDeleted(cajacierre.getIsDeleted());
					
					cajacierreLocal.setGeneralEntityOriginal(cajacierre.getGeneralEntityOriginal());
					
					cajacierreLocal.setId(cajacierre.getId());	
					cajacierreLocal.setVersionRow(cajacierre.getVersionRow());	
					cajacierreLocal.setid_empresa(cajacierre.getid_empresa());	
					cajacierreLocal.setid_sucursal(cajacierre.getid_sucursal());	
					cajacierreLocal.setid_caja(cajacierre.getid_caja());	
					cajacierreLocal.setfecha_cierre(cajacierre.getfecha_cierre());	
					cajacierreLocal.sethora_cierre(cajacierre.gethora_cierre());	
					cajacierreLocal.setesta_activo(cajacierre.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cajacierre.getIsDeleted()) {
				if(!existe) {
					cajacierres.add(cajacierre);
				}
			} else {
				if(cajacierreEncontrado!=null && permiteQuitar)  {
					cajacierres.remove(cajacierreEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CajaCierre cajacierre,List<CajaCierre> cajacierres) throws Exception {
		try	{			
			for(CajaCierre cajacierreLocal:cajacierres) {
				if(cajacierreLocal.getId().equals(cajacierre.getId())) {
					cajacierreLocal.setIsSelected(cajacierre.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCajaCierre(List<CajaCierre> cajacierresAux) throws Exception {
		//this.cajacierresAux=cajacierresAux;
		
		for(CajaCierre cajacierreAux:cajacierresAux) {
			if(cajacierreAux.getIsChanged()) {
				cajacierreAux.setIsChanged(false);
			}		
			
			if(cajacierreAux.getIsNew()) {
				cajacierreAux.setIsNew(false);
			}	
			
			if(cajacierreAux.getIsDeleted()) {
				cajacierreAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCajaCierre(CajaCierre cajacierreAux) throws Exception {
		//this.cajacierreAux=cajacierreAux;
		
			if(cajacierreAux.getIsChanged()) {
				cajacierreAux.setIsChanged(false);
			}		
			
			if(cajacierreAux.getIsNew()) {
				cajacierreAux.setIsNew(false);
			}	
			
			if(cajacierreAux.getIsDeleted()) {
				cajacierreAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CajaCierre cajacierreAsignar,CajaCierre cajacierre) throws Exception {
		cajacierreAsignar.setId(cajacierre.getId());	
		cajacierreAsignar.setVersionRow(cajacierre.getVersionRow());	
		cajacierreAsignar.setid_empresa(cajacierre.getid_empresa());
		cajacierreAsignar.setempresa_descripcion(cajacierre.getempresa_descripcion());	
		cajacierreAsignar.setid_sucursal(cajacierre.getid_sucursal());
		cajacierreAsignar.setsucursal_descripcion(cajacierre.getsucursal_descripcion());	
		cajacierreAsignar.setid_caja(cajacierre.getid_caja());
		cajacierreAsignar.setcaja_descripcion(cajacierre.getcaja_descripcion());	
		cajacierreAsignar.setfecha_cierre(cajacierre.getfecha_cierre());	
		cajacierreAsignar.sethora_cierre(cajacierre.gethora_cierre());	
		cajacierreAsignar.setesta_activo(cajacierre.getesta_activo());	
	}
	
	public static void inicializarCajaCierre(CajaCierre cajacierre) throws Exception {
		try {
				cajacierre.setId(0L);	
					
				cajacierre.setid_empresa(-1L);	
				cajacierre.setid_sucursal(-1L);	
				cajacierre.setid_caja(-1L);	
				cajacierre.setfecha_cierre(new Date());	
				cajacierre.sethora_cierre(new Time((new Date()).getTime()));	
				cajacierre.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCajaCierre(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaCierreConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaCierreConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaCierreConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaCierreConstantesFunciones.LABEL_FECHACIERRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaCierreConstantesFunciones.LABEL_HORACIERRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaCierreConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCajaCierre(String sTipo,Row row,Workbook workbook,CajaCierre cajacierre,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cajacierre.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajacierre.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajacierre.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajacierre.getfecha_cierre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajacierre.gethora_cierre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cajacierre.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCajaCierre=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCajaCierre() {
		return this.sFinalQueryCajaCierre;
	}
	
	public void setsFinalQueryCajaCierre(String sFinalQueryCajaCierre) {
		this.sFinalQueryCajaCierre= sFinalQueryCajaCierre;
	}
	
	public Border resaltarSeleccionarCajaCierre=null;
	
	public Border setResaltarSeleccionarCajaCierre(ParametroGeneralUsuario parametroGeneralUsuario/*CajaCierreBeanSwingJInternalFrame cajacierreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cajacierreBeanSwingJInternalFrame.jTtoolBarCajaCierre.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCajaCierre= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCajaCierre() {
		return this.resaltarSeleccionarCajaCierre;
	}
	
	public void setResaltarSeleccionarCajaCierre(Border borderResaltarSeleccionarCajaCierre) {
		this.resaltarSeleccionarCajaCierre= borderResaltarSeleccionarCajaCierre;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCajaCierre=null;
	public Boolean mostraridCajaCierre=true;
	public Boolean activaridCajaCierre=true;

	public Border resaltarid_empresaCajaCierre=null;
	public Boolean mostrarid_empresaCajaCierre=true;
	public Boolean activarid_empresaCajaCierre=true;
	public Boolean cargarid_empresaCajaCierre=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCajaCierre=false;//ConEventDepend=true

	public Border resaltarid_sucursalCajaCierre=null;
	public Boolean mostrarid_sucursalCajaCierre=true;
	public Boolean activarid_sucursalCajaCierre=true;
	public Boolean cargarid_sucursalCajaCierre=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCajaCierre=false;//ConEventDepend=true

	public Border resaltarid_cajaCajaCierre=null;
	public Boolean mostrarid_cajaCajaCierre=true;
	public Boolean activarid_cajaCajaCierre=true;
	public Boolean cargarid_cajaCajaCierre=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaCajaCierre=false;//ConEventDepend=true

	public Border resaltarfecha_cierreCajaCierre=null;
	public Boolean mostrarfecha_cierreCajaCierre=true;
	public Boolean activarfecha_cierreCajaCierre=true;

	public Border resaltarhora_cierreCajaCierre=null;
	public Boolean mostrarhora_cierreCajaCierre=true;
	public Boolean activarhora_cierreCajaCierre=true;

	public Border resaltaresta_activoCajaCierre=null;
	public Boolean mostraresta_activoCajaCierre=true;
	public Boolean activaresta_activoCajaCierre=true;

	
	

	public Border setResaltaridCajaCierre(ParametroGeneralUsuario parametroGeneralUsuario/*CajaCierreBeanSwingJInternalFrame cajacierreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajacierreBeanSwingJInternalFrame.jTtoolBarCajaCierre.setBorder(borderResaltar);
		
		this.resaltaridCajaCierre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCajaCierre() {
		return this.resaltaridCajaCierre;
	}

	public void setResaltaridCajaCierre(Border borderResaltar) {
		this.resaltaridCajaCierre= borderResaltar;
	}

	public Boolean getMostraridCajaCierre() {
		return this.mostraridCajaCierre;
	}

	public void setMostraridCajaCierre(Boolean mostraridCajaCierre) {
		this.mostraridCajaCierre= mostraridCajaCierre;
	}

	public Boolean getActivaridCajaCierre() {
		return this.activaridCajaCierre;
	}

	public void setActivaridCajaCierre(Boolean activaridCajaCierre) {
		this.activaridCajaCierre= activaridCajaCierre;
	}

	public Border setResaltarid_empresaCajaCierre(ParametroGeneralUsuario parametroGeneralUsuario/*CajaCierreBeanSwingJInternalFrame cajacierreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajacierreBeanSwingJInternalFrame.jTtoolBarCajaCierre.setBorder(borderResaltar);
		
		this.resaltarid_empresaCajaCierre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCajaCierre() {
		return this.resaltarid_empresaCajaCierre;
	}

	public void setResaltarid_empresaCajaCierre(Border borderResaltar) {
		this.resaltarid_empresaCajaCierre= borderResaltar;
	}

	public Boolean getMostrarid_empresaCajaCierre() {
		return this.mostrarid_empresaCajaCierre;
	}

	public void setMostrarid_empresaCajaCierre(Boolean mostrarid_empresaCajaCierre) {
		this.mostrarid_empresaCajaCierre= mostrarid_empresaCajaCierre;
	}

	public Boolean getActivarid_empresaCajaCierre() {
		return this.activarid_empresaCajaCierre;
	}

	public void setActivarid_empresaCajaCierre(Boolean activarid_empresaCajaCierre) {
		this.activarid_empresaCajaCierre= activarid_empresaCajaCierre;
	}

	public Boolean getCargarid_empresaCajaCierre() {
		return this.cargarid_empresaCajaCierre;
	}

	public void setCargarid_empresaCajaCierre(Boolean cargarid_empresaCajaCierre) {
		this.cargarid_empresaCajaCierre= cargarid_empresaCajaCierre;
	}

	public Border setResaltarid_sucursalCajaCierre(ParametroGeneralUsuario parametroGeneralUsuario/*CajaCierreBeanSwingJInternalFrame cajacierreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajacierreBeanSwingJInternalFrame.jTtoolBarCajaCierre.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCajaCierre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCajaCierre() {
		return this.resaltarid_sucursalCajaCierre;
	}

	public void setResaltarid_sucursalCajaCierre(Border borderResaltar) {
		this.resaltarid_sucursalCajaCierre= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCajaCierre() {
		return this.mostrarid_sucursalCajaCierre;
	}

	public void setMostrarid_sucursalCajaCierre(Boolean mostrarid_sucursalCajaCierre) {
		this.mostrarid_sucursalCajaCierre= mostrarid_sucursalCajaCierre;
	}

	public Boolean getActivarid_sucursalCajaCierre() {
		return this.activarid_sucursalCajaCierre;
	}

	public void setActivarid_sucursalCajaCierre(Boolean activarid_sucursalCajaCierre) {
		this.activarid_sucursalCajaCierre= activarid_sucursalCajaCierre;
	}

	public Boolean getCargarid_sucursalCajaCierre() {
		return this.cargarid_sucursalCajaCierre;
	}

	public void setCargarid_sucursalCajaCierre(Boolean cargarid_sucursalCajaCierre) {
		this.cargarid_sucursalCajaCierre= cargarid_sucursalCajaCierre;
	}

	public Border setResaltarid_cajaCajaCierre(ParametroGeneralUsuario parametroGeneralUsuario/*CajaCierreBeanSwingJInternalFrame cajacierreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajacierreBeanSwingJInternalFrame.jTtoolBarCajaCierre.setBorder(borderResaltar);
		
		this.resaltarid_cajaCajaCierre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaCajaCierre() {
		return this.resaltarid_cajaCajaCierre;
	}

	public void setResaltarid_cajaCajaCierre(Border borderResaltar) {
		this.resaltarid_cajaCajaCierre= borderResaltar;
	}

	public Boolean getMostrarid_cajaCajaCierre() {
		return this.mostrarid_cajaCajaCierre;
	}

	public void setMostrarid_cajaCajaCierre(Boolean mostrarid_cajaCajaCierre) {
		this.mostrarid_cajaCajaCierre= mostrarid_cajaCajaCierre;
	}

	public Boolean getActivarid_cajaCajaCierre() {
		return this.activarid_cajaCajaCierre;
	}

	public void setActivarid_cajaCajaCierre(Boolean activarid_cajaCajaCierre) {
		this.activarid_cajaCajaCierre= activarid_cajaCajaCierre;
	}

	public Boolean getCargarid_cajaCajaCierre() {
		return this.cargarid_cajaCajaCierre;
	}

	public void setCargarid_cajaCajaCierre(Boolean cargarid_cajaCajaCierre) {
		this.cargarid_cajaCajaCierre= cargarid_cajaCajaCierre;
	}

	public Border setResaltarfecha_cierreCajaCierre(ParametroGeneralUsuario parametroGeneralUsuario/*CajaCierreBeanSwingJInternalFrame cajacierreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajacierreBeanSwingJInternalFrame.jTtoolBarCajaCierre.setBorder(borderResaltar);
		
		this.resaltarfecha_cierreCajaCierre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_cierreCajaCierre() {
		return this.resaltarfecha_cierreCajaCierre;
	}

	public void setResaltarfecha_cierreCajaCierre(Border borderResaltar) {
		this.resaltarfecha_cierreCajaCierre= borderResaltar;
	}

	public Boolean getMostrarfecha_cierreCajaCierre() {
		return this.mostrarfecha_cierreCajaCierre;
	}

	public void setMostrarfecha_cierreCajaCierre(Boolean mostrarfecha_cierreCajaCierre) {
		this.mostrarfecha_cierreCajaCierre= mostrarfecha_cierreCajaCierre;
	}

	public Boolean getActivarfecha_cierreCajaCierre() {
		return this.activarfecha_cierreCajaCierre;
	}

	public void setActivarfecha_cierreCajaCierre(Boolean activarfecha_cierreCajaCierre) {
		this.activarfecha_cierreCajaCierre= activarfecha_cierreCajaCierre;
	}

	public Border setResaltarhora_cierreCajaCierre(ParametroGeneralUsuario parametroGeneralUsuario/*CajaCierreBeanSwingJInternalFrame cajacierreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajacierreBeanSwingJInternalFrame.jTtoolBarCajaCierre.setBorder(borderResaltar);
		
		this.resaltarhora_cierreCajaCierre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_cierreCajaCierre() {
		return this.resaltarhora_cierreCajaCierre;
	}

	public void setResaltarhora_cierreCajaCierre(Border borderResaltar) {
		this.resaltarhora_cierreCajaCierre= borderResaltar;
	}

	public Boolean getMostrarhora_cierreCajaCierre() {
		return this.mostrarhora_cierreCajaCierre;
	}

	public void setMostrarhora_cierreCajaCierre(Boolean mostrarhora_cierreCajaCierre) {
		this.mostrarhora_cierreCajaCierre= mostrarhora_cierreCajaCierre;
	}

	public Boolean getActivarhora_cierreCajaCierre() {
		return this.activarhora_cierreCajaCierre;
	}

	public void setActivarhora_cierreCajaCierre(Boolean activarhora_cierreCajaCierre) {
		this.activarhora_cierreCajaCierre= activarhora_cierreCajaCierre;
	}

	public Border setResaltaresta_activoCajaCierre(ParametroGeneralUsuario parametroGeneralUsuario/*CajaCierreBeanSwingJInternalFrame cajacierreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajacierreBeanSwingJInternalFrame.jTtoolBarCajaCierre.setBorder(borderResaltar);
		
		this.resaltaresta_activoCajaCierre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoCajaCierre() {
		return this.resaltaresta_activoCajaCierre;
	}

	public void setResaltaresta_activoCajaCierre(Border borderResaltar) {
		this.resaltaresta_activoCajaCierre= borderResaltar;
	}

	public Boolean getMostraresta_activoCajaCierre() {
		return this.mostraresta_activoCajaCierre;
	}

	public void setMostraresta_activoCajaCierre(Boolean mostraresta_activoCajaCierre) {
		this.mostraresta_activoCajaCierre= mostraresta_activoCajaCierre;
	}

	public Boolean getActivaresta_activoCajaCierre() {
		return this.activaresta_activoCajaCierre;
	}

	public void setActivaresta_activoCajaCierre(Boolean activaresta_activoCajaCierre) {
		this.activaresta_activoCajaCierre= activaresta_activoCajaCierre;
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
		
		
		this.setMostraridCajaCierre(esInicial);
		this.setMostrarid_empresaCajaCierre(esInicial);
		this.setMostrarid_sucursalCajaCierre(esInicial);
		this.setMostrarid_cajaCajaCierre(esInicial);
		this.setMostrarfecha_cierreCajaCierre(esInicial);
		this.setMostrarhora_cierreCajaCierre(esInicial);
		this.setMostraresta_activoCajaCierre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaCierreConstantesFunciones.ID)) {
				this.setMostraridCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.FECHACIERRE)) {
				this.setMostrarfecha_cierreCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.HORACIERRE)) {
				this.setMostrarhora_cierreCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoCajaCierre(esAsigna);
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
		
		
		this.setActivaridCajaCierre(esInicial);
		this.setActivarid_empresaCajaCierre(esInicial);
		this.setActivarid_sucursalCajaCierre(esInicial);
		this.setActivarid_cajaCajaCierre(esInicial);
		this.setActivarfecha_cierreCajaCierre(esInicial);
		this.setActivarhora_cierreCajaCierre(esInicial);
		this.setActivaresta_activoCajaCierre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaCierreConstantesFunciones.ID)) {
				this.setActivaridCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.FECHACIERRE)) {
				this.setActivarfecha_cierreCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.HORACIERRE)) {
				this.setActivarhora_cierreCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoCajaCierre(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaCierreBeanSwingJInternalFrame cajacierreBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCajaCierre(esInicial);
		this.setResaltarid_empresaCajaCierre(esInicial);
		this.setResaltarid_sucursalCajaCierre(esInicial);
		this.setResaltarid_cajaCajaCierre(esInicial);
		this.setResaltarfecha_cierreCajaCierre(esInicial);
		this.setResaltarhora_cierreCajaCierre(esInicial);
		this.setResaltaresta_activoCajaCierre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaCierreConstantesFunciones.ID)) {
				this.setResaltaridCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.FECHACIERRE)) {
				this.setResaltarfecha_cierreCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.HORACIERRE)) {
				this.setResaltarhora_cierreCajaCierre(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaCierreConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoCajaCierre(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaCierreBeanSwingJInternalFrame cajacierreBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCajaCajaCierre=true;

	public Boolean getMostrarFK_IdCajaCajaCierre() {
		return this.mostrarFK_IdCajaCajaCierre;
	}

	public void setMostrarFK_IdCajaCajaCierre(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCajaCajaCierre= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCajaCierre=true;

	public Boolean getMostrarFK_IdEmpresaCajaCierre() {
		return this.mostrarFK_IdEmpresaCajaCierre;
	}

	public void setMostrarFK_IdEmpresaCajaCierre(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCajaCierre= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCajaCierre=true;

	public Boolean getMostrarFK_IdSucursalCajaCierre() {
		return this.mostrarFK_IdSucursalCajaCierre;
	}

	public void setMostrarFK_IdSucursalCajaCierre(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCajaCierre= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCajaCajaCierre=true;

	public Boolean getActivarFK_IdCajaCajaCierre() {
		return this.activarFK_IdCajaCajaCierre;
	}

	public void setActivarFK_IdCajaCajaCierre(Boolean habilitarResaltar) {
		this.activarFK_IdCajaCajaCierre= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCajaCierre=true;

	public Boolean getActivarFK_IdEmpresaCajaCierre() {
		return this.activarFK_IdEmpresaCajaCierre;
	}

	public void setActivarFK_IdEmpresaCajaCierre(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCajaCierre= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCajaCierre=true;

	public Boolean getActivarFK_IdSucursalCajaCierre() {
		return this.activarFK_IdSucursalCajaCierre;
	}

	public void setActivarFK_IdSucursalCajaCierre(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCajaCierre= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCajaCajaCierre=null;

	public Border getResaltarFK_IdCajaCajaCierre() {
		return this.resaltarFK_IdCajaCajaCierre;
	}

	public void setResaltarFK_IdCajaCajaCierre(Border borderResaltar) {
		this.resaltarFK_IdCajaCajaCierre= borderResaltar;
	}

	public void setResaltarFK_IdCajaCajaCierre(ParametroGeneralUsuario parametroGeneralUsuario/*CajaCierreBeanSwingJInternalFrame cajacierreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCajaCajaCierre= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCajaCierre=null;

	public Border getResaltarFK_IdEmpresaCajaCierre() {
		return this.resaltarFK_IdEmpresaCajaCierre;
	}

	public void setResaltarFK_IdEmpresaCajaCierre(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCajaCierre= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCajaCierre(ParametroGeneralUsuario parametroGeneralUsuario/*CajaCierreBeanSwingJInternalFrame cajacierreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCajaCierre= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCajaCierre=null;

	public Border getResaltarFK_IdSucursalCajaCierre() {
		return this.resaltarFK_IdSucursalCajaCierre;
	}

	public void setResaltarFK_IdSucursalCajaCierre(Border borderResaltar) {
		this.resaltarFK_IdSucursalCajaCierre= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCajaCierre(ParametroGeneralUsuario parametroGeneralUsuario/*CajaCierreBeanSwingJInternalFrame cajacierreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCajaCierre= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}