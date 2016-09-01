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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.CentroCostoEstructuraConstantesFunciones;
import com.bydan.erp.nomina.util.CentroCostoEstructuraParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CentroCostoEstructuraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CentroCostoEstructuraConstantesFunciones extends CentroCostoEstructuraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CentroCostoEstructura";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CentroCostoEstructura"+CentroCostoEstructuraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CentroCostoEstructuraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CentroCostoEstructuraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CentroCostoEstructuraConstantesFunciones.SCHEMA+"_"+CentroCostoEstructuraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CentroCostoEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CentroCostoEstructuraConstantesFunciones.SCHEMA+"_"+CentroCostoEstructuraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CentroCostoEstructuraConstantesFunciones.SCHEMA+"_"+CentroCostoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CentroCostoEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CentroCostoEstructuraConstantesFunciones.SCHEMA+"_"+CentroCostoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CentroCostoEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CentroCostoEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CentroCostoEstructuraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CentroCostoEstructuraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CentroCostoEstructuraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CentroCostoEstructuraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Centro Costo Estructuras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Centro Costo Estructura";
	public static final String SCLASSWEBTITULO_LOWER="Centro Costo Estructura";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CentroCostoEstructura";
	public static final String OBJECTNAME="centrocostoestructura";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="centro_costo_estructura";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select centrocostoestructura from "+CentroCostoEstructuraConstantesFunciones.SPERSISTENCENAME+" centrocostoestructura";
	public static String QUERYSELECTNATIVE="select "+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".id,"+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".version_row,"+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".id_empresa,"+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".id_sucursal,"+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".id_estructura,"+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".id_centro_costo,"+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".porcentaje from "+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME;//+" as "+CentroCostoEstructuraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CentroCostoEstructuraConstantesFuncionesAdditional centrocostoestructuraConstantesFuncionesAdditional=null;
	
	public CentroCostoEstructuraConstantesFuncionesAdditional getCentroCostoEstructuraConstantesFuncionesAdditional() {
		return this.centrocostoestructuraConstantesFuncionesAdditional;
	}
	
	public void setCentroCostoEstructuraConstantesFuncionesAdditional(CentroCostoEstructuraConstantesFuncionesAdditional centrocostoestructuraConstantesFuncionesAdditional) {
		try {
			this.centrocostoestructuraConstantesFuncionesAdditional=centrocostoestructuraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String PORCENTAJE= "porcentaje";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
	
		
		
		
		
		
		
		
	
	public static String getCentroCostoEstructuraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CentroCostoEstructuraConstantesFunciones.IDEMPRESA)) {sLabelColumna=CentroCostoEstructuraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CentroCostoEstructuraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CentroCostoEstructuraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CentroCostoEstructuraConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=CentroCostoEstructuraConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(CentroCostoEstructuraConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=CentroCostoEstructuraConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(CentroCostoEstructuraConstantesFunciones.PORCENTAJE)) {sLabelColumna=CentroCostoEstructuraConstantesFunciones.LABEL_PORCENTAJE;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getCentroCostoEstructuraDescripcion(CentroCostoEstructura centrocostoestructura) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(centrocostoestructura !=null/* && centrocostoestructura.getId()!=0*/) {
			if(centrocostoestructura.getId()!=null) {
				sDescripcion=centrocostoestructura.getId().toString();
			}//centrocostoestructuracentrocostoestructura.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCentroCostoEstructuraDescripcionDetallado(CentroCostoEstructura centrocostoestructura) {
		String sDescripcion="";
			
		sDescripcion+=CentroCostoEstructuraConstantesFunciones.ID+"=";
		sDescripcion+=centrocostoestructura.getId().toString()+",";
		sDescripcion+=CentroCostoEstructuraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=centrocostoestructura.getVersionRow().toString()+",";
		sDescripcion+=CentroCostoEstructuraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=centrocostoestructura.getid_empresa().toString()+",";
		sDescripcion+=CentroCostoEstructuraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=centrocostoestructura.getid_sucursal().toString()+",";
		sDescripcion+=CentroCostoEstructuraConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=centrocostoestructura.getid_estructura().toString()+",";
		sDescripcion+=CentroCostoEstructuraConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=centrocostoestructura.getid_centro_costo().toString()+",";
		sDescripcion+=CentroCostoEstructuraConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=centrocostoestructura.getporcentaje().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCentroCostoEstructuraDescripcion(CentroCostoEstructura centrocostoestructura,String sValor) throws Exception {			
		if(centrocostoestructura !=null) {
			//centrocostoestructuracentrocostoestructura.getId().toString();
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

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
		}

		return sDescripcion;
	}

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCentroCostoEstructura(CentroCostoEstructura centrocostoestructura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosCentroCostoEstructuras(List<CentroCostoEstructura> centrocostoestructuras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CentroCostoEstructura centrocostoestructura: centrocostoestructuras) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCentroCostoEstructura(CentroCostoEstructura centrocostoestructura,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && centrocostoestructura.getConCambioAuxiliar()) {
			centrocostoestructura.setIsDeleted(centrocostoestructura.getIsDeletedAuxiliar());	
			centrocostoestructura.setIsNew(centrocostoestructura.getIsNewAuxiliar());	
			centrocostoestructura.setIsChanged(centrocostoestructura.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			centrocostoestructura.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			centrocostoestructura.setIsDeletedAuxiliar(false);	
			centrocostoestructura.setIsNewAuxiliar(false);	
			centrocostoestructura.setIsChangedAuxiliar(false);
			
			centrocostoestructura.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCentroCostoEstructuras(List<CentroCostoEstructura> centrocostoestructuras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CentroCostoEstructura centrocostoestructura : centrocostoestructuras) {
			if(conAsignarBase && centrocostoestructura.getConCambioAuxiliar()) {
				centrocostoestructura.setIsDeleted(centrocostoestructura.getIsDeletedAuxiliar());	
				centrocostoestructura.setIsNew(centrocostoestructura.getIsNewAuxiliar());	
				centrocostoestructura.setIsChanged(centrocostoestructura.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				centrocostoestructura.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				centrocostoestructura.setIsDeletedAuxiliar(false);	
				centrocostoestructura.setIsNewAuxiliar(false);	
				centrocostoestructura.setIsChangedAuxiliar(false);
				
				centrocostoestructura.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCentroCostoEstructura(CentroCostoEstructura centrocostoestructura,Boolean conEnteros) throws Exception  {
		centrocostoestructura.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCentroCostoEstructuras(List<CentroCostoEstructura> centrocostoestructuras,Boolean conEnteros) throws Exception  {
		
		for(CentroCostoEstructura centrocostoestructura: centrocostoestructuras) {
			centrocostoestructura.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCentroCostoEstructura(List<CentroCostoEstructura> centrocostoestructuras,CentroCostoEstructura centrocostoestructuraAux) throws Exception  {
		CentroCostoEstructuraConstantesFunciones.InicializarValoresCentroCostoEstructura(centrocostoestructuraAux,true);
		
		for(CentroCostoEstructura centrocostoestructura: centrocostoestructuras) {
			if(centrocostoestructura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			centrocostoestructuraAux.setporcentaje(centrocostoestructuraAux.getporcentaje()+centrocostoestructura.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCentroCostoEstructura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CentroCostoEstructuraConstantesFunciones.getArrayColumnasGlobalesCentroCostoEstructura(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCentroCostoEstructura(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CentroCostoEstructuraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CentroCostoEstructuraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CentroCostoEstructuraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CentroCostoEstructuraConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCentroCostoEstructura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CentroCostoEstructura> centrocostoestructuras,CentroCostoEstructura centrocostoestructura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CentroCostoEstructura centrocostoestructuraAux: centrocostoestructuras) {
			if(centrocostoestructuraAux!=null && centrocostoestructura!=null) {
				if((centrocostoestructuraAux.getId()==null && centrocostoestructura.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(centrocostoestructuraAux.getId()!=null && centrocostoestructura.getId()!=null){
					if(centrocostoestructuraAux.getId().equals(centrocostoestructura.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCentroCostoEstructura(List<CentroCostoEstructura> centrocostoestructuras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(CentroCostoEstructura centrocostoestructura: centrocostoestructuras) {			
			if(centrocostoestructura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=centrocostoestructura.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoEstructuraConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(CentroCostoEstructuraConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCentroCostoEstructura() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CentroCostoEstructuraConstantesFunciones.LABEL_ID, CentroCostoEstructuraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoEstructuraConstantesFunciones.LABEL_VERSIONROW, CentroCostoEstructuraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoEstructuraConstantesFunciones.LABEL_IDEMPRESA, CentroCostoEstructuraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoEstructuraConstantesFunciones.LABEL_IDSUCURSAL, CentroCostoEstructuraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoEstructuraConstantesFunciones.LABEL_IDESTRUCTURA, CentroCostoEstructuraConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoEstructuraConstantesFunciones.LABEL_IDCENTROCOSTO, CentroCostoEstructuraConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoEstructuraConstantesFunciones.LABEL_PORCENTAJE, CentroCostoEstructuraConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCentroCostoEstructura() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CentroCostoEstructuraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoEstructuraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoEstructuraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoEstructuraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoEstructuraConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoEstructuraConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoEstructuraConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCentroCostoEstructura() throws Exception  {
		return CentroCostoEstructuraConstantesFunciones.getTiposSeleccionarCentroCostoEstructura(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCentroCostoEstructura(Boolean conFk) throws Exception  {
		return CentroCostoEstructuraConstantesFunciones.getTiposSeleccionarCentroCostoEstructura(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCentroCostoEstructura(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoEstructuraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CentroCostoEstructuraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoEstructuraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CentroCostoEstructuraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoEstructuraConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(CentroCostoEstructuraConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoEstructuraConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(CentroCostoEstructuraConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoEstructuraConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(CentroCostoEstructuraConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCentroCostoEstructura(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCentroCostoEstructura(CentroCostoEstructura centrocostoestructuraAux) throws Exception {
		
			centrocostoestructuraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(centrocostoestructuraAux.getEmpresa()));
			centrocostoestructuraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(centrocostoestructuraAux.getSucursal()));
			centrocostoestructuraAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(centrocostoestructuraAux.getEstructura()));
			centrocostoestructuraAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocostoestructuraAux.getCentroCosto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCentroCostoEstructura(List<CentroCostoEstructura> centrocostoestructurasTemp) throws Exception {
		for(CentroCostoEstructura centrocostoestructuraAux:centrocostoestructurasTemp) {
			
			centrocostoestructuraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(centrocostoestructuraAux.getEmpresa()));
			centrocostoestructuraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(centrocostoestructuraAux.getSucursal()));
			centrocostoestructuraAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(centrocostoestructuraAux.getEstructura()));
			centrocostoestructuraAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocostoestructuraAux.getCentroCosto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCentroCostoEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(CentroCosto.class));
				
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
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCentroCostoEstructura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCentroCostoEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CentroCostoEstructuraConstantesFunciones.getClassesRelationshipsOfCentroCostoEstructura(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCentroCostoEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCentroCostoEstructura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CentroCostoEstructuraConstantesFunciones.getClassesRelationshipsFromStringsOfCentroCostoEstructura(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCentroCostoEstructura(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CentroCostoEstructura centrocostoestructura,List<CentroCostoEstructura> centrocostoestructuras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CentroCostoEstructura centrocostoestructuraEncontrado=null;
			
			for(CentroCostoEstructura centrocostoestructuraLocal:centrocostoestructuras) {
				if(centrocostoestructuraLocal.getId().equals(centrocostoestructura.getId())) {
					centrocostoestructuraEncontrado=centrocostoestructuraLocal;
					
					centrocostoestructuraLocal.setIsChanged(centrocostoestructura.getIsChanged());
					centrocostoestructuraLocal.setIsNew(centrocostoestructura.getIsNew());
					centrocostoestructuraLocal.setIsDeleted(centrocostoestructura.getIsDeleted());
					
					centrocostoestructuraLocal.setGeneralEntityOriginal(centrocostoestructura.getGeneralEntityOriginal());
					
					centrocostoestructuraLocal.setId(centrocostoestructura.getId());	
					centrocostoestructuraLocal.setVersionRow(centrocostoestructura.getVersionRow());	
					centrocostoestructuraLocal.setid_empresa(centrocostoestructura.getid_empresa());	
					centrocostoestructuraLocal.setid_sucursal(centrocostoestructura.getid_sucursal());	
					centrocostoestructuraLocal.setid_estructura(centrocostoestructura.getid_estructura());	
					centrocostoestructuraLocal.setid_centro_costo(centrocostoestructura.getid_centro_costo());	
					centrocostoestructuraLocal.setporcentaje(centrocostoestructura.getporcentaje());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!centrocostoestructura.getIsDeleted()) {
				if(!existe) {
					centrocostoestructuras.add(centrocostoestructura);
				}
			} else {
				if(centrocostoestructuraEncontrado!=null && permiteQuitar)  {
					centrocostoestructuras.remove(centrocostoestructuraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CentroCostoEstructura centrocostoestructura,List<CentroCostoEstructura> centrocostoestructuras) throws Exception {
		try	{			
			for(CentroCostoEstructura centrocostoestructuraLocal:centrocostoestructuras) {
				if(centrocostoestructuraLocal.getId().equals(centrocostoestructura.getId())) {
					centrocostoestructuraLocal.setIsSelected(centrocostoestructura.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCentroCostoEstructura(List<CentroCostoEstructura> centrocostoestructurasAux) throws Exception {
		//this.centrocostoestructurasAux=centrocostoestructurasAux;
		
		for(CentroCostoEstructura centrocostoestructuraAux:centrocostoestructurasAux) {
			if(centrocostoestructuraAux.getIsChanged()) {
				centrocostoestructuraAux.setIsChanged(false);
			}		
			
			if(centrocostoestructuraAux.getIsNew()) {
				centrocostoestructuraAux.setIsNew(false);
			}	
			
			if(centrocostoestructuraAux.getIsDeleted()) {
				centrocostoestructuraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCentroCostoEstructura(CentroCostoEstructura centrocostoestructuraAux) throws Exception {
		//this.centrocostoestructuraAux=centrocostoestructuraAux;
		
			if(centrocostoestructuraAux.getIsChanged()) {
				centrocostoestructuraAux.setIsChanged(false);
			}		
			
			if(centrocostoestructuraAux.getIsNew()) {
				centrocostoestructuraAux.setIsNew(false);
			}	
			
			if(centrocostoestructuraAux.getIsDeleted()) {
				centrocostoestructuraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CentroCostoEstructura centrocostoestructuraAsignar,CentroCostoEstructura centrocostoestructura) throws Exception {
		centrocostoestructuraAsignar.setId(centrocostoestructura.getId());	
		centrocostoestructuraAsignar.setVersionRow(centrocostoestructura.getVersionRow());	
		centrocostoestructuraAsignar.setid_empresa(centrocostoestructura.getid_empresa());
		centrocostoestructuraAsignar.setempresa_descripcion(centrocostoestructura.getempresa_descripcion());	
		centrocostoestructuraAsignar.setid_sucursal(centrocostoestructura.getid_sucursal());
		centrocostoestructuraAsignar.setsucursal_descripcion(centrocostoestructura.getsucursal_descripcion());	
		centrocostoestructuraAsignar.setid_estructura(centrocostoestructura.getid_estructura());
		centrocostoestructuraAsignar.setestructura_descripcion(centrocostoestructura.getestructura_descripcion());	
		centrocostoestructuraAsignar.setid_centro_costo(centrocostoestructura.getid_centro_costo());
		centrocostoestructuraAsignar.setcentrocosto_descripcion(centrocostoestructura.getcentrocosto_descripcion());	
		centrocostoestructuraAsignar.setporcentaje(centrocostoestructura.getporcentaje());	
	}
	
	public static void inicializarCentroCostoEstructura(CentroCostoEstructura centrocostoestructura) throws Exception {
		try {
				centrocostoestructura.setId(0L);	
					
				centrocostoestructura.setid_empresa(-1L);	
				centrocostoestructura.setid_sucursal(-1L);	
				centrocostoestructura.setid_estructura(-1L);	
				centrocostoestructura.setid_centro_costo(null);	
				centrocostoestructura.setporcentaje(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCentroCostoEstructura(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoEstructuraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoEstructuraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoEstructuraConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoEstructuraConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoEstructuraConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCentroCostoEstructura(String sTipo,Row row,Workbook workbook,CentroCostoEstructura centrocostoestructura,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostoestructura.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostoestructura.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostoestructura.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostoestructura.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostoestructura.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCentroCostoEstructura=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCentroCostoEstructura() {
		return this.sFinalQueryCentroCostoEstructura;
	}
	
	public void setsFinalQueryCentroCostoEstructura(String sFinalQueryCentroCostoEstructura) {
		this.sFinalQueryCentroCostoEstructura= sFinalQueryCentroCostoEstructura;
	}
	
	public Border resaltarSeleccionarCentroCostoEstructura=null;
	
	public Border setResaltarSeleccionarCentroCostoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoEstructuraBeanSwingJInternalFrame centrocostoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//centrocostoestructuraBeanSwingJInternalFrame.jTtoolBarCentroCostoEstructura.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCentroCostoEstructura= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCentroCostoEstructura() {
		return this.resaltarSeleccionarCentroCostoEstructura;
	}
	
	public void setResaltarSeleccionarCentroCostoEstructura(Border borderResaltarSeleccionarCentroCostoEstructura) {
		this.resaltarSeleccionarCentroCostoEstructura= borderResaltarSeleccionarCentroCostoEstructura;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCentroCostoEstructura=null;
	public Boolean mostraridCentroCostoEstructura=true;
	public Boolean activaridCentroCostoEstructura=true;

	public Border resaltarid_empresaCentroCostoEstructura=null;
	public Boolean mostrarid_empresaCentroCostoEstructura=true;
	public Boolean activarid_empresaCentroCostoEstructura=true;
	public Boolean cargarid_empresaCentroCostoEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCentroCostoEstructura=false;//ConEventDepend=true

	public Border resaltarid_sucursalCentroCostoEstructura=null;
	public Boolean mostrarid_sucursalCentroCostoEstructura=true;
	public Boolean activarid_sucursalCentroCostoEstructura=true;
	public Boolean cargarid_sucursalCentroCostoEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCentroCostoEstructura=false;//ConEventDepend=true

	public Border resaltarid_estructuraCentroCostoEstructura=null;
	public Boolean mostrarid_estructuraCentroCostoEstructura=true;
	public Boolean activarid_estructuraCentroCostoEstructura=true;
	public Boolean cargarid_estructuraCentroCostoEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraCentroCostoEstructura=false;//ConEventDepend=true

	public Border resaltarid_centro_costoCentroCostoEstructura=null;
	public Boolean mostrarid_centro_costoCentroCostoEstructura=true;
	public Boolean activarid_centro_costoCentroCostoEstructura=true;
	public Boolean cargarid_centro_costoCentroCostoEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoCentroCostoEstructura=false;//ConEventDepend=true

	public Border resaltarporcentajeCentroCostoEstructura=null;
	public Boolean mostrarporcentajeCentroCostoEstructura=true;
	public Boolean activarporcentajeCentroCostoEstructura=true;

	
	

	public Border setResaltaridCentroCostoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoEstructuraBeanSwingJInternalFrame centrocostoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoestructuraBeanSwingJInternalFrame.jTtoolBarCentroCostoEstructura.setBorder(borderResaltar);
		
		this.resaltaridCentroCostoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCentroCostoEstructura() {
		return this.resaltaridCentroCostoEstructura;
	}

	public void setResaltaridCentroCostoEstructura(Border borderResaltar) {
		this.resaltaridCentroCostoEstructura= borderResaltar;
	}

	public Boolean getMostraridCentroCostoEstructura() {
		return this.mostraridCentroCostoEstructura;
	}

	public void setMostraridCentroCostoEstructura(Boolean mostraridCentroCostoEstructura) {
		this.mostraridCentroCostoEstructura= mostraridCentroCostoEstructura;
	}

	public Boolean getActivaridCentroCostoEstructura() {
		return this.activaridCentroCostoEstructura;
	}

	public void setActivaridCentroCostoEstructura(Boolean activaridCentroCostoEstructura) {
		this.activaridCentroCostoEstructura= activaridCentroCostoEstructura;
	}

	public Border setResaltarid_empresaCentroCostoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoEstructuraBeanSwingJInternalFrame centrocostoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoestructuraBeanSwingJInternalFrame.jTtoolBarCentroCostoEstructura.setBorder(borderResaltar);
		
		this.resaltarid_empresaCentroCostoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCentroCostoEstructura() {
		return this.resaltarid_empresaCentroCostoEstructura;
	}

	public void setResaltarid_empresaCentroCostoEstructura(Border borderResaltar) {
		this.resaltarid_empresaCentroCostoEstructura= borderResaltar;
	}

	public Boolean getMostrarid_empresaCentroCostoEstructura() {
		return this.mostrarid_empresaCentroCostoEstructura;
	}

	public void setMostrarid_empresaCentroCostoEstructura(Boolean mostrarid_empresaCentroCostoEstructura) {
		this.mostrarid_empresaCentroCostoEstructura= mostrarid_empresaCentroCostoEstructura;
	}

	public Boolean getActivarid_empresaCentroCostoEstructura() {
		return this.activarid_empresaCentroCostoEstructura;
	}

	public void setActivarid_empresaCentroCostoEstructura(Boolean activarid_empresaCentroCostoEstructura) {
		this.activarid_empresaCentroCostoEstructura= activarid_empresaCentroCostoEstructura;
	}

	public Boolean getCargarid_empresaCentroCostoEstructura() {
		return this.cargarid_empresaCentroCostoEstructura;
	}

	public void setCargarid_empresaCentroCostoEstructura(Boolean cargarid_empresaCentroCostoEstructura) {
		this.cargarid_empresaCentroCostoEstructura= cargarid_empresaCentroCostoEstructura;
	}

	public Border setResaltarid_sucursalCentroCostoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoEstructuraBeanSwingJInternalFrame centrocostoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoestructuraBeanSwingJInternalFrame.jTtoolBarCentroCostoEstructura.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCentroCostoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCentroCostoEstructura() {
		return this.resaltarid_sucursalCentroCostoEstructura;
	}

	public void setResaltarid_sucursalCentroCostoEstructura(Border borderResaltar) {
		this.resaltarid_sucursalCentroCostoEstructura= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCentroCostoEstructura() {
		return this.mostrarid_sucursalCentroCostoEstructura;
	}

	public void setMostrarid_sucursalCentroCostoEstructura(Boolean mostrarid_sucursalCentroCostoEstructura) {
		this.mostrarid_sucursalCentroCostoEstructura= mostrarid_sucursalCentroCostoEstructura;
	}

	public Boolean getActivarid_sucursalCentroCostoEstructura() {
		return this.activarid_sucursalCentroCostoEstructura;
	}

	public void setActivarid_sucursalCentroCostoEstructura(Boolean activarid_sucursalCentroCostoEstructura) {
		this.activarid_sucursalCentroCostoEstructura= activarid_sucursalCentroCostoEstructura;
	}

	public Boolean getCargarid_sucursalCentroCostoEstructura() {
		return this.cargarid_sucursalCentroCostoEstructura;
	}

	public void setCargarid_sucursalCentroCostoEstructura(Boolean cargarid_sucursalCentroCostoEstructura) {
		this.cargarid_sucursalCentroCostoEstructura= cargarid_sucursalCentroCostoEstructura;
	}

	public Border setResaltarid_estructuraCentroCostoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoEstructuraBeanSwingJInternalFrame centrocostoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoestructuraBeanSwingJInternalFrame.jTtoolBarCentroCostoEstructura.setBorder(borderResaltar);
		
		this.resaltarid_estructuraCentroCostoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraCentroCostoEstructura() {
		return this.resaltarid_estructuraCentroCostoEstructura;
	}

	public void setResaltarid_estructuraCentroCostoEstructura(Border borderResaltar) {
		this.resaltarid_estructuraCentroCostoEstructura= borderResaltar;
	}

	public Boolean getMostrarid_estructuraCentroCostoEstructura() {
		return this.mostrarid_estructuraCentroCostoEstructura;
	}

	public void setMostrarid_estructuraCentroCostoEstructura(Boolean mostrarid_estructuraCentroCostoEstructura) {
		this.mostrarid_estructuraCentroCostoEstructura= mostrarid_estructuraCentroCostoEstructura;
	}

	public Boolean getActivarid_estructuraCentroCostoEstructura() {
		return this.activarid_estructuraCentroCostoEstructura;
	}

	public void setActivarid_estructuraCentroCostoEstructura(Boolean activarid_estructuraCentroCostoEstructura) {
		this.activarid_estructuraCentroCostoEstructura= activarid_estructuraCentroCostoEstructura;
	}

	public Boolean getCargarid_estructuraCentroCostoEstructura() {
		return this.cargarid_estructuraCentroCostoEstructura;
	}

	public void setCargarid_estructuraCentroCostoEstructura(Boolean cargarid_estructuraCentroCostoEstructura) {
		this.cargarid_estructuraCentroCostoEstructura= cargarid_estructuraCentroCostoEstructura;
	}

	public Border setResaltarid_centro_costoCentroCostoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoEstructuraBeanSwingJInternalFrame centrocostoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoestructuraBeanSwingJInternalFrame.jTtoolBarCentroCostoEstructura.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoCentroCostoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoCentroCostoEstructura() {
		return this.resaltarid_centro_costoCentroCostoEstructura;
	}

	public void setResaltarid_centro_costoCentroCostoEstructura(Border borderResaltar) {
		this.resaltarid_centro_costoCentroCostoEstructura= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoCentroCostoEstructura() {
		return this.mostrarid_centro_costoCentroCostoEstructura;
	}

	public void setMostrarid_centro_costoCentroCostoEstructura(Boolean mostrarid_centro_costoCentroCostoEstructura) {
		this.mostrarid_centro_costoCentroCostoEstructura= mostrarid_centro_costoCentroCostoEstructura;
	}

	public Boolean getActivarid_centro_costoCentroCostoEstructura() {
		return this.activarid_centro_costoCentroCostoEstructura;
	}

	public void setActivarid_centro_costoCentroCostoEstructura(Boolean activarid_centro_costoCentroCostoEstructura) {
		this.activarid_centro_costoCentroCostoEstructura= activarid_centro_costoCentroCostoEstructura;
	}

	public Boolean getCargarid_centro_costoCentroCostoEstructura() {
		return this.cargarid_centro_costoCentroCostoEstructura;
	}

	public void setCargarid_centro_costoCentroCostoEstructura(Boolean cargarid_centro_costoCentroCostoEstructura) {
		this.cargarid_centro_costoCentroCostoEstructura= cargarid_centro_costoCentroCostoEstructura;
	}

	public Border setResaltarporcentajeCentroCostoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoEstructuraBeanSwingJInternalFrame centrocostoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoestructuraBeanSwingJInternalFrame.jTtoolBarCentroCostoEstructura.setBorder(borderResaltar);
		
		this.resaltarporcentajeCentroCostoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeCentroCostoEstructura() {
		return this.resaltarporcentajeCentroCostoEstructura;
	}

	public void setResaltarporcentajeCentroCostoEstructura(Border borderResaltar) {
		this.resaltarporcentajeCentroCostoEstructura= borderResaltar;
	}

	public Boolean getMostrarporcentajeCentroCostoEstructura() {
		return this.mostrarporcentajeCentroCostoEstructura;
	}

	public void setMostrarporcentajeCentroCostoEstructura(Boolean mostrarporcentajeCentroCostoEstructura) {
		this.mostrarporcentajeCentroCostoEstructura= mostrarporcentajeCentroCostoEstructura;
	}

	public Boolean getActivarporcentajeCentroCostoEstructura() {
		return this.activarporcentajeCentroCostoEstructura;
	}

	public void setActivarporcentajeCentroCostoEstructura(Boolean activarporcentajeCentroCostoEstructura) {
		this.activarporcentajeCentroCostoEstructura= activarporcentajeCentroCostoEstructura;
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
		
		
		this.setMostraridCentroCostoEstructura(esInicial);
		this.setMostrarid_empresaCentroCostoEstructura(esInicial);
		this.setMostrarid_sucursalCentroCostoEstructura(esInicial);
		this.setMostrarid_estructuraCentroCostoEstructura(esInicial);
		this.setMostrarid_centro_costoCentroCostoEstructura(esInicial);
		this.setMostrarporcentajeCentroCostoEstructura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.ID)) {
				this.setMostraridCentroCostoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCentroCostoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCentroCostoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraCentroCostoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoCentroCostoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeCentroCostoEstructura(esAsigna);
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
		
		
		this.setActivaridCentroCostoEstructura(esInicial);
		this.setActivarid_empresaCentroCostoEstructura(esInicial);
		this.setActivarid_sucursalCentroCostoEstructura(esInicial);
		this.setActivarid_estructuraCentroCostoEstructura(esInicial);
		this.setActivarid_centro_costoCentroCostoEstructura(esInicial);
		this.setActivarporcentajeCentroCostoEstructura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.ID)) {
				this.setActivaridCentroCostoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCentroCostoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCentroCostoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraCentroCostoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoCentroCostoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeCentroCostoEstructura(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CentroCostoEstructuraBeanSwingJInternalFrame centrocostoestructuraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCentroCostoEstructura(esInicial);
		this.setResaltarid_empresaCentroCostoEstructura(esInicial);
		this.setResaltarid_sucursalCentroCostoEstructura(esInicial);
		this.setResaltarid_estructuraCentroCostoEstructura(esInicial);
		this.setResaltarid_centro_costoCentroCostoEstructura(esInicial);
		this.setResaltarporcentajeCentroCostoEstructura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.ID)) {
				this.setResaltaridCentroCostoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCentroCostoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCentroCostoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraCentroCostoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoCentroCostoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoEstructuraConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeCentroCostoEstructura(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CentroCostoEstructuraBeanSwingJInternalFrame centrocostoestructuraBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCentroCostoCentroCostoEstructura=true;

	public Boolean getMostrarFK_IdCentroCostoCentroCostoEstructura() {
		return this.mostrarFK_IdCentroCostoCentroCostoEstructura;
	}

	public void setMostrarFK_IdCentroCostoCentroCostoEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoCentroCostoEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCentroCostoEstructura=true;

	public Boolean getMostrarFK_IdEmpresaCentroCostoEstructura() {
		return this.mostrarFK_IdEmpresaCentroCostoEstructura;
	}

	public void setMostrarFK_IdEmpresaCentroCostoEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCentroCostoEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraCentroCostoEstructura=true;

	public Boolean getMostrarFK_IdEstructuraCentroCostoEstructura() {
		return this.mostrarFK_IdEstructuraCentroCostoEstructura;
	}

	public void setMostrarFK_IdEstructuraCentroCostoEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraCentroCostoEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCentroCostoEstructura=true;

	public Boolean getMostrarFK_IdSucursalCentroCostoEstructura() {
		return this.mostrarFK_IdSucursalCentroCostoEstructura;
	}

	public void setMostrarFK_IdSucursalCentroCostoEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCentroCostoEstructura= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCentroCostoCentroCostoEstructura=true;

	public Boolean getActivarFK_IdCentroCostoCentroCostoEstructura() {
		return this.activarFK_IdCentroCostoCentroCostoEstructura;
	}

	public void setActivarFK_IdCentroCostoCentroCostoEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoCentroCostoEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCentroCostoEstructura=true;

	public Boolean getActivarFK_IdEmpresaCentroCostoEstructura() {
		return this.activarFK_IdEmpresaCentroCostoEstructura;
	}

	public void setActivarFK_IdEmpresaCentroCostoEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCentroCostoEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraCentroCostoEstructura=true;

	public Boolean getActivarFK_IdEstructuraCentroCostoEstructura() {
		return this.activarFK_IdEstructuraCentroCostoEstructura;
	}

	public void setActivarFK_IdEstructuraCentroCostoEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraCentroCostoEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCentroCostoEstructura=true;

	public Boolean getActivarFK_IdSucursalCentroCostoEstructura() {
		return this.activarFK_IdSucursalCentroCostoEstructura;
	}

	public void setActivarFK_IdSucursalCentroCostoEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCentroCostoEstructura= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCentroCostoCentroCostoEstructura=null;

	public Border getResaltarFK_IdCentroCostoCentroCostoEstructura() {
		return this.resaltarFK_IdCentroCostoCentroCostoEstructura;
	}

	public void setResaltarFK_IdCentroCostoCentroCostoEstructura(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoCentroCostoEstructura= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoCentroCostoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoEstructuraBeanSwingJInternalFrame centrocostoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoCentroCostoEstructura= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCentroCostoEstructura=null;

	public Border getResaltarFK_IdEmpresaCentroCostoEstructura() {
		return this.resaltarFK_IdEmpresaCentroCostoEstructura;
	}

	public void setResaltarFK_IdEmpresaCentroCostoEstructura(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCentroCostoEstructura= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCentroCostoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoEstructuraBeanSwingJInternalFrame centrocostoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCentroCostoEstructura= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraCentroCostoEstructura=null;

	public Border getResaltarFK_IdEstructuraCentroCostoEstructura() {
		return this.resaltarFK_IdEstructuraCentroCostoEstructura;
	}

	public void setResaltarFK_IdEstructuraCentroCostoEstructura(Border borderResaltar) {
		this.resaltarFK_IdEstructuraCentroCostoEstructura= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraCentroCostoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoEstructuraBeanSwingJInternalFrame centrocostoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraCentroCostoEstructura= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCentroCostoEstructura=null;

	public Border getResaltarFK_IdSucursalCentroCostoEstructura() {
		return this.resaltarFK_IdSucursalCentroCostoEstructura;
	}

	public void setResaltarFK_IdSucursalCentroCostoEstructura(Border borderResaltar) {
		this.resaltarFK_IdSucursalCentroCostoEstructura= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCentroCostoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoEstructuraBeanSwingJInternalFrame centrocostoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCentroCostoEstructura= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}