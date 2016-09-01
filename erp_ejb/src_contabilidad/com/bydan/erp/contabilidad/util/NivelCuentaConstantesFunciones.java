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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.NivelCuentaConstantesFunciones;
import com.bydan.erp.contabilidad.util.NivelCuentaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.NivelCuentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class NivelCuentaConstantesFunciones extends NivelCuentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="NivelCuenta";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="NivelCuenta"+NivelCuentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NivelCuentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NivelCuentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NivelCuentaConstantesFunciones.SCHEMA+"_"+NivelCuentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NivelCuentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NivelCuentaConstantesFunciones.SCHEMA+"_"+NivelCuentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NivelCuentaConstantesFunciones.SCHEMA+"_"+NivelCuentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NivelCuentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NivelCuentaConstantesFunciones.SCHEMA+"_"+NivelCuentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelCuentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NivelCuentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelCuentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelCuentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NivelCuentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelCuentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NivelCuentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NivelCuentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NivelCuentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NivelCuentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Nivel Cuentas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Nivel Cuenta";
	public static final String SCLASSWEBTITULO_LOWER="Nivel Cuenta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="NivelCuenta";
	public static final String OBJECTNAME="nivelcuenta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="nivel_cuenta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select nivelcuenta from "+NivelCuentaConstantesFunciones.SPERSISTENCENAME+" nivelcuenta";
	public static String QUERYSELECTNATIVE="select "+NivelCuentaConstantesFunciones.SCHEMA+"."+NivelCuentaConstantesFunciones.TABLENAME+".id,"+NivelCuentaConstantesFunciones.SCHEMA+"."+NivelCuentaConstantesFunciones.TABLENAME+".version_row,"+NivelCuentaConstantesFunciones.SCHEMA+"."+NivelCuentaConstantesFunciones.TABLENAME+".nombre from "+NivelCuentaConstantesFunciones.SCHEMA+"."+NivelCuentaConstantesFunciones.TABLENAME;//+" as "+NivelCuentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected NivelCuentaConstantesFuncionesAdditional nivelcuentaConstantesFuncionesAdditional=null;
	
	public NivelCuentaConstantesFuncionesAdditional getNivelCuentaConstantesFuncionesAdditional() {
		return this.nivelcuentaConstantesFuncionesAdditional;
	}
	
	public void setNivelCuentaConstantesFuncionesAdditional(NivelCuentaConstantesFuncionesAdditional nivelcuentaConstantesFuncionesAdditional) {
		try {
			this.nivelcuentaConstantesFuncionesAdditional=nivelcuentaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getNivelCuentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NivelCuentaConstantesFunciones.NOMBRE)) {sLabelColumna=NivelCuentaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getNivelCuentaDescripcion(NivelCuenta nivelcuenta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(nivelcuenta !=null/* && nivelcuenta.getId()!=0*/) {
			sDescripcion=nivelcuenta.getnombre();//nivelcuentanivelcuenta.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getNivelCuentaDescripcionDetallado(NivelCuenta nivelcuenta) {
		String sDescripcion="";
			
		sDescripcion+=NivelCuentaConstantesFunciones.ID+"=";
		sDescripcion+=nivelcuenta.getId().toString()+",";
		sDescripcion+=NivelCuentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=nivelcuenta.getVersionRow().toString()+",";
		sDescripcion+=NivelCuentaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=nivelcuenta.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setNivelCuentaDescripcion(NivelCuenta nivelcuenta,String sValor) throws Exception {			
		if(nivelcuenta !=null) {
			nivelcuenta.setnombre(sValor);;//nivelcuentanivelcuenta.getnombre().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosNivelCuenta(NivelCuenta nivelcuenta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		nivelcuenta.setnombre(nivelcuenta.getnombre().trim());
	}
	
	public static void quitarEspaciosNivelCuentas(List<NivelCuenta> nivelcuentas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(NivelCuenta nivelcuenta: nivelcuentas) {
			nivelcuenta.setnombre(nivelcuenta.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNivelCuenta(NivelCuenta nivelcuenta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && nivelcuenta.getConCambioAuxiliar()) {
			nivelcuenta.setIsDeleted(nivelcuenta.getIsDeletedAuxiliar());	
			nivelcuenta.setIsNew(nivelcuenta.getIsNewAuxiliar());	
			nivelcuenta.setIsChanged(nivelcuenta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			nivelcuenta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			nivelcuenta.setIsDeletedAuxiliar(false);	
			nivelcuenta.setIsNewAuxiliar(false);	
			nivelcuenta.setIsChangedAuxiliar(false);
			
			nivelcuenta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNivelCuentas(List<NivelCuenta> nivelcuentas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(NivelCuenta nivelcuenta : nivelcuentas) {
			if(conAsignarBase && nivelcuenta.getConCambioAuxiliar()) {
				nivelcuenta.setIsDeleted(nivelcuenta.getIsDeletedAuxiliar());	
				nivelcuenta.setIsNew(nivelcuenta.getIsNewAuxiliar());	
				nivelcuenta.setIsChanged(nivelcuenta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				nivelcuenta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				nivelcuenta.setIsDeletedAuxiliar(false);	
				nivelcuenta.setIsNewAuxiliar(false);	
				nivelcuenta.setIsChangedAuxiliar(false);
				
				nivelcuenta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNivelCuenta(NivelCuenta nivelcuenta,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresNivelCuentas(List<NivelCuenta> nivelcuentas,Boolean conEnteros) throws Exception  {
		
		for(NivelCuenta nivelcuenta: nivelcuentas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaNivelCuenta(List<NivelCuenta> nivelcuentas,NivelCuenta nivelcuentaAux) throws Exception  {
		NivelCuentaConstantesFunciones.InicializarValoresNivelCuenta(nivelcuentaAux,true);
		
		for(NivelCuenta nivelcuenta: nivelcuentas) {
			if(nivelcuenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNivelCuenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NivelCuentaConstantesFunciones.getArrayColumnasGlobalesNivelCuenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNivelCuenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNivelCuenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<NivelCuenta> nivelcuentas,NivelCuenta nivelcuenta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(NivelCuenta nivelcuentaAux: nivelcuentas) {
			if(nivelcuentaAux!=null && nivelcuenta!=null) {
				if((nivelcuentaAux.getId()==null && nivelcuenta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(nivelcuentaAux.getId()!=null && nivelcuenta.getId()!=null){
					if(nivelcuentaAux.getId().equals(nivelcuenta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNivelCuenta(List<NivelCuenta> nivelcuentas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(NivelCuenta nivelcuenta: nivelcuentas) {			
			if(nivelcuenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNivelCuenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,NivelCuentaConstantesFunciones.LABEL_ID, NivelCuentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NivelCuentaConstantesFunciones.LABEL_VERSIONROW, NivelCuentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NivelCuentaConstantesFunciones.LABEL_NOMBRE, NivelCuentaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNivelCuenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=NivelCuentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NivelCuentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NivelCuentaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNivelCuenta() throws Exception  {
		return NivelCuentaConstantesFunciones.getTiposSeleccionarNivelCuenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNivelCuenta(Boolean conFk) throws Exception  {
		return NivelCuentaConstantesFunciones.getTiposSeleccionarNivelCuenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNivelCuenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NivelCuentaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(NivelCuentaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNivelCuenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNivelCuenta(NivelCuenta nivelcuentaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesNivelCuenta(List<NivelCuenta> nivelcuentasTemp) throws Exception {
		for(NivelCuenta nivelcuentaAux:nivelcuentasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNivelCuenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNivelCuenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfNivelCuenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NivelCuentaConstantesFunciones.getClassesRelationshipsOfNivelCuenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNivelCuenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNivelCuenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NivelCuentaConstantesFunciones.getClassesRelationshipsFromStringsOfNivelCuenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNivelCuenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(NivelCuenta nivelcuenta,List<NivelCuenta> nivelcuentas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			NivelCuenta nivelcuentaEncontrado=null;
			
			for(NivelCuenta nivelcuentaLocal:nivelcuentas) {
				if(nivelcuentaLocal.getId().equals(nivelcuenta.getId())) {
					nivelcuentaEncontrado=nivelcuentaLocal;
					
					nivelcuentaLocal.setIsChanged(nivelcuenta.getIsChanged());
					nivelcuentaLocal.setIsNew(nivelcuenta.getIsNew());
					nivelcuentaLocal.setIsDeleted(nivelcuenta.getIsDeleted());
					
					nivelcuentaLocal.setGeneralEntityOriginal(nivelcuenta.getGeneralEntityOriginal());
					
					nivelcuentaLocal.setId(nivelcuenta.getId());	
					nivelcuentaLocal.setVersionRow(nivelcuenta.getVersionRow());	
					nivelcuentaLocal.setnombre(nivelcuenta.getnombre());	
					
					
					nivelcuentaLocal.setCuentaContables(nivelcuenta.getCuentaContables());
					
					existe=true;
					break;
				}
			}
			
			if(!nivelcuenta.getIsDeleted()) {
				if(!existe) {
					nivelcuentas.add(nivelcuenta);
				}
			} else {
				if(nivelcuentaEncontrado!=null && permiteQuitar)  {
					nivelcuentas.remove(nivelcuentaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(NivelCuenta nivelcuenta,List<NivelCuenta> nivelcuentas) throws Exception {
		try	{			
			for(NivelCuenta nivelcuentaLocal:nivelcuentas) {
				if(nivelcuentaLocal.getId().equals(nivelcuenta.getId())) {
					nivelcuentaLocal.setIsSelected(nivelcuenta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNivelCuenta(List<NivelCuenta> nivelcuentasAux) throws Exception {
		//this.nivelcuentasAux=nivelcuentasAux;
		
		for(NivelCuenta nivelcuentaAux:nivelcuentasAux) {
			if(nivelcuentaAux.getIsChanged()) {
				nivelcuentaAux.setIsChanged(false);
			}		
			
			if(nivelcuentaAux.getIsNew()) {
				nivelcuentaAux.setIsNew(false);
			}	
			
			if(nivelcuentaAux.getIsDeleted()) {
				nivelcuentaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNivelCuenta(NivelCuenta nivelcuentaAux) throws Exception {
		//this.nivelcuentaAux=nivelcuentaAux;
		
			if(nivelcuentaAux.getIsChanged()) {
				nivelcuentaAux.setIsChanged(false);
			}		
			
			if(nivelcuentaAux.getIsNew()) {
				nivelcuentaAux.setIsNew(false);
			}	
			
			if(nivelcuentaAux.getIsDeleted()) {
				nivelcuentaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(NivelCuenta nivelcuentaAsignar,NivelCuenta nivelcuenta) throws Exception {
		nivelcuentaAsignar.setId(nivelcuenta.getId());	
		nivelcuentaAsignar.setVersionRow(nivelcuenta.getVersionRow());	
		nivelcuentaAsignar.setnombre(nivelcuenta.getnombre());	
	}
	
	public static void inicializarNivelCuenta(NivelCuenta nivelcuenta) throws Exception {
		try {
				nivelcuenta.setId(0L);	
					
				nivelcuenta.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNivelCuenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NivelCuentaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNivelCuenta(String sTipo,Row row,Workbook workbook,NivelCuenta nivelcuenta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(nivelcuenta.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNivelCuenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryNivelCuenta() {
		return this.sFinalQueryNivelCuenta;
	}
	
	public void setsFinalQueryNivelCuenta(String sFinalQueryNivelCuenta) {
		this.sFinalQueryNivelCuenta= sFinalQueryNivelCuenta;
	}
	
	public Border resaltarSeleccionarNivelCuenta=null;
	
	public Border setResaltarSeleccionarNivelCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCuentaBeanSwingJInternalFrame nivelcuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//nivelcuentaBeanSwingJInternalFrame.jTtoolBarNivelCuenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNivelCuenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNivelCuenta() {
		return this.resaltarSeleccionarNivelCuenta;
	}
	
	public void setResaltarSeleccionarNivelCuenta(Border borderResaltarSeleccionarNivelCuenta) {
		this.resaltarSeleccionarNivelCuenta= borderResaltarSeleccionarNivelCuenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNivelCuenta=null;
	public Boolean mostraridNivelCuenta=true;
	public Boolean activaridNivelCuenta=true;

	public Border resaltarnombreNivelCuenta=null;
	public Boolean mostrarnombreNivelCuenta=true;
	public Boolean activarnombreNivelCuenta=true;

	
	

	public Border setResaltaridNivelCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCuentaBeanSwingJInternalFrame nivelcuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//nivelcuentaBeanSwingJInternalFrame.jTtoolBarNivelCuenta.setBorder(borderResaltar);
		
		this.resaltaridNivelCuenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNivelCuenta() {
		return this.resaltaridNivelCuenta;
	}

	public void setResaltaridNivelCuenta(Border borderResaltar) {
		this.resaltaridNivelCuenta= borderResaltar;
	}

	public Boolean getMostraridNivelCuenta() {
		return this.mostraridNivelCuenta;
	}

	public void setMostraridNivelCuenta(Boolean mostraridNivelCuenta) {
		this.mostraridNivelCuenta= mostraridNivelCuenta;
	}

	public Boolean getActivaridNivelCuenta() {
		return this.activaridNivelCuenta;
	}

	public void setActivaridNivelCuenta(Boolean activaridNivelCuenta) {
		this.activaridNivelCuenta= activaridNivelCuenta;
	}

	public Border setResaltarnombreNivelCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCuentaBeanSwingJInternalFrame nivelcuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//nivelcuentaBeanSwingJInternalFrame.jTtoolBarNivelCuenta.setBorder(borderResaltar);
		
		this.resaltarnombreNivelCuenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreNivelCuenta() {
		return this.resaltarnombreNivelCuenta;
	}

	public void setResaltarnombreNivelCuenta(Border borderResaltar) {
		this.resaltarnombreNivelCuenta= borderResaltar;
	}

	public Boolean getMostrarnombreNivelCuenta() {
		return this.mostrarnombreNivelCuenta;
	}

	public void setMostrarnombreNivelCuenta(Boolean mostrarnombreNivelCuenta) {
		this.mostrarnombreNivelCuenta= mostrarnombreNivelCuenta;
	}

	public Boolean getActivarnombreNivelCuenta() {
		return this.activarnombreNivelCuenta;
	}

	public void setActivarnombreNivelCuenta(Boolean activarnombreNivelCuenta) {
		this.activarnombreNivelCuenta= activarnombreNivelCuenta;
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
		
		
		this.setMostraridNivelCuenta(esInicial);
		this.setMostrarnombreNivelCuenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NivelCuentaConstantesFunciones.ID)) {
				this.setMostraridNivelCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCuentaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreNivelCuenta(esAsigna);
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
		
		
		this.setActivaridNivelCuenta(esInicial);
		this.setActivarnombreNivelCuenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NivelCuentaConstantesFunciones.ID)) {
				this.setActivaridNivelCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCuentaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreNivelCuenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NivelCuentaBeanSwingJInternalFrame nivelcuentaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNivelCuenta(esInicial);
		this.setResaltarnombreNivelCuenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NivelCuentaConstantesFunciones.ID)) {
				this.setResaltaridNivelCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelCuentaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreNivelCuenta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCuentaContableNivelCuenta=null;

	public Border getResaltarCuentaContableNivelCuenta() {
		return this.resaltarCuentaContableNivelCuenta;
	}

	public void setResaltarCuentaContableNivelCuenta(Border borderResaltarCuentaContable) {
		if(borderResaltarCuentaContable!=null) {
			this.resaltarCuentaContableNivelCuenta= borderResaltarCuentaContable;
		}
	}

	public Border setResaltarCuentaContableNivelCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*NivelCuentaBeanSwingJInternalFrame nivelcuentaBeanSwingJInternalFrame*/) {
		Border borderResaltarCuentaContable=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//nivelcuentaBeanSwingJInternalFrame.jTtoolBarNivelCuenta.setBorder(borderResaltarCuentaContable);
			
		this.resaltarCuentaContableNivelCuenta= borderResaltarCuentaContable;

		 return borderResaltarCuentaContable;
	}



	public Boolean mostrarCuentaContableNivelCuenta=true;

	public Boolean getMostrarCuentaContableNivelCuenta() {
		return this.mostrarCuentaContableNivelCuenta;
	}

	public void setMostrarCuentaContableNivelCuenta(Boolean visibilidadResaltarCuentaContable) {
		this.mostrarCuentaContableNivelCuenta= visibilidadResaltarCuentaContable;
	}



	public Boolean activarCuentaContableNivelCuenta=true;

	public Boolean gethabilitarResaltarCuentaContableNivelCuenta() {
		return this.activarCuentaContableNivelCuenta;
	}

	public void setActivarCuentaContableNivelCuenta(Boolean habilitarResaltarCuentaContable) {
		this.activarCuentaContableNivelCuenta= habilitarResaltarCuentaContable;
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

		this.setMostrarCuentaContableNivelCuenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaContable.class)) {
				this.setMostrarCuentaContableNivelCuenta(esAsigna);
				continue;
			}
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

		this.setActivarCuentaContableNivelCuenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaContable.class)) {
				this.setActivarCuentaContableNivelCuenta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NivelCuentaBeanSwingJInternalFrame nivelcuentaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCuentaContableNivelCuenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaContable.class)) {
				this.setResaltarCuentaContableNivelCuenta(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}