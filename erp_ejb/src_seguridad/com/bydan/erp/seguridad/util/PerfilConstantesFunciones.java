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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.PerfilConstantesFunciones;
import com.bydan.erp.seguridad.util.PerfilParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.PerfilParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PerfilConstantesFunciones extends PerfilConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Perfil";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Perfil"+PerfilConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PerfilHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PerfilHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PerfilConstantesFunciones.SCHEMA+"_"+PerfilConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PerfilHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PerfilConstantesFunciones.SCHEMA+"_"+PerfilConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PerfilConstantesFunciones.SCHEMA+"_"+PerfilConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PerfilHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PerfilConstantesFunciones.SCHEMA+"_"+PerfilConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PerfilHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PerfilHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PerfilConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PerfilConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PerfilConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PerfilConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PerfilConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Perfiles";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Perfil";
	public static final String SCLASSWEBTITULO_LOWER="Perfil";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Perfil";
	public static final String OBJECTNAME="perfil";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="perfil";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select perfil from "+PerfilConstantesFunciones.SPERSISTENCENAME+" perfil";
	public static String QUERYSELECTNATIVE="select "+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".id,"+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".version_row,"+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".id_sistema,"+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".codigo,"+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".nombre,"+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".nombre2,"+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".estado from "+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME;//+" as "+PerfilConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=true;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PerfilConstantesFuncionesAdditional perfilConstantesFuncionesAdditional=null;
	
	public PerfilConstantesFuncionesAdditional getPerfilConstantesFuncionesAdditional() {
		return this.perfilConstantesFuncionesAdditional;
	}
	
	public void setPerfilConstantesFuncionesAdditional(PerfilConstantesFuncionesAdditional perfilConstantesFuncionesAdditional) {
		try {
			this.perfilConstantesFuncionesAdditional=perfilConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDSISTEMA= "id_sistema";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String NOMBRE2= "nombre2";
    public static final String ESTADO= "estado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "A";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "A";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDSISTEMA= "Sistema";
		public static final String LABEL_IDSISTEMA_LOWER= "Sistema";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NOMBRE2= "Nombre Alterno";
		public static final String LABEL_NOMBRE2_LOWER= "Nombre2";
    	public static final String LABEL_ESTADO= "Estado";
		public static final String LABEL_ESTADO_LOWER= "Estado";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE2=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE2=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getPerfilLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PerfilConstantesFunciones.IDSISTEMA)) {sLabelColumna=PerfilConstantesFunciones.LABEL_IDSISTEMA;}
		if(sNombreColumna.equals(PerfilConstantesFunciones.CODIGO)) {sLabelColumna=PerfilConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(PerfilConstantesFunciones.NOMBRE)) {sLabelColumna=PerfilConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(PerfilConstantesFunciones.NOMBRE2)) {sLabelColumna=PerfilConstantesFunciones.LABEL_NOMBRE2;}
		if(sNombreColumna.equals(PerfilConstantesFunciones.ESTADO)) {sLabelColumna=PerfilConstantesFunciones.LABEL_ESTADO;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getestadoDescripcion(Perfil perfil) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!perfil.getestado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getestadoHtmlDescripcion(Perfil perfil) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(perfil.getId(),perfil.getestado());

		return sDescripcion;
	}	
	
	public static String getPerfilDescripcion(Perfil perfil) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(perfil !=null/* && perfil.getId()!=0*/) {
			sDescripcion=perfil.getnombre();//perfilperfil.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPerfilDescripcionDetallado(Perfil perfil) {
		String sDescripcion="";
			
		sDescripcion+=PerfilConstantesFunciones.ID+"=";
		sDescripcion+=perfil.getId().toString()+",";
		sDescripcion+=PerfilConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=perfil.getVersionRow().toString()+",";
		sDescripcion+=PerfilConstantesFunciones.IDSISTEMA+"=";
		sDescripcion+=perfil.getid_sistema().toString()+",";
		sDescripcion+=PerfilConstantesFunciones.CODIGO+"=";
		sDescripcion+=perfil.getcodigo()+",";
		sDescripcion+=PerfilConstantesFunciones.NOMBRE+"=";
		sDescripcion+=perfil.getnombre()+",";
		sDescripcion+=PerfilConstantesFunciones.NOMBRE2+"=";
		sDescripcion+=perfil.getnombre2()+",";
		sDescripcion+=PerfilConstantesFunciones.ESTADO+"=";
		sDescripcion+=perfil.getestado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPerfilDescripcion(Perfil perfil,String sValor) throws Exception {			
		if(perfil !=null) {
			perfil.setnombre(sValor);;//perfilperfil.getnombre().trim();
		}		
	}
	
		

	public static String getSistemaDescripcion(Sistema sistema) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sistema!=null/*&&sistema.getId()>0*/) {
			sDescripcion=SistemaConstantesFunciones.getSistemaDescripcion(sistema);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorNombre2")) {
			sNombreIndice="Tipo=  Por Nombre Alterno";
		} else if(sNombreIndice.equals("FK_IdSistema")) {
			sNombreIndice="Tipo=  Por Sistema";
		} else if(sNombreIndice.equals("PorIdSistemaPorNombre")) {
			sNombreIndice="Tipo=  Por Sistema Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre2(String nombre2) {
		String sDetalleIndice=" Parametros->";
		if(nombre2!=null) {sDetalleIndice+=" Nombre Alterno="+nombre2;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSistema(Long id_sistema) {
		String sDetalleIndice=" Parametros->";
		if(id_sistema!=null) {sDetalleIndice+=" Codigo Unico De Sistema="+id_sistema.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdSistemaPorNombre(Long id_sistema,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_sistema!=null) {sDetalleIndice+=" Codigo Unico De Sistema="+id_sistema.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPerfil(Perfil perfil,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		perfil.setcodigo(perfil.getcodigo().trim());
		perfil.setnombre(perfil.getnombre().trim());
		perfil.setnombre2(perfil.getnombre2().trim());
	}
	
	public static void quitarEspaciosPerfils(List<Perfil> perfils,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Perfil perfil: perfils) {
			perfil.setcodigo(perfil.getcodigo().trim());
			perfil.setnombre(perfil.getnombre().trim());
			perfil.setnombre2(perfil.getnombre2().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPerfil(Perfil perfil,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && perfil.getConCambioAuxiliar()) {
			perfil.setIsDeleted(perfil.getIsDeletedAuxiliar());	
			perfil.setIsNew(perfil.getIsNewAuxiliar());	
			perfil.setIsChanged(perfil.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			perfil.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			perfil.setIsDeletedAuxiliar(false);	
			perfil.setIsNewAuxiliar(false);	
			perfil.setIsChangedAuxiliar(false);
			
			perfil.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPerfils(List<Perfil> perfils,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Perfil perfil : perfils) {
			if(conAsignarBase && perfil.getConCambioAuxiliar()) {
				perfil.setIsDeleted(perfil.getIsDeletedAuxiliar());	
				perfil.setIsNew(perfil.getIsNewAuxiliar());	
				perfil.setIsChanged(perfil.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				perfil.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				perfil.setIsDeletedAuxiliar(false);	
				perfil.setIsNewAuxiliar(false);	
				perfil.setIsChangedAuxiliar(false);
				
				perfil.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPerfil(Perfil perfil,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPerfils(List<Perfil> perfils,Boolean conEnteros) throws Exception  {
		
		for(Perfil perfil: perfils) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPerfil(List<Perfil> perfils,Perfil perfilAux) throws Exception  {
		PerfilConstantesFunciones.InicializarValoresPerfil(perfilAux,true);
		
		for(Perfil perfil: perfils) {
			if(perfil.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPerfil(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PerfilConstantesFunciones.getArrayColumnasGlobalesPerfil(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPerfil(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPerfil(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Perfil> perfils,Perfil perfil,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Perfil perfilAux: perfils) {
			if(perfilAux!=null && perfil!=null) {
				if((perfilAux.getId()==null && perfil.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(perfilAux.getId()!=null && perfil.getId()!=null){
					if(perfilAux.getId().equals(perfil.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPerfil(List<Perfil> perfils) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Perfil perfil: perfils) {			
			if(perfil.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPerfil() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PerfilConstantesFunciones.LABEL_ID, PerfilConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilConstantesFunciones.LABEL_VERSIONROW, PerfilConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilConstantesFunciones.LABEL_IDSISTEMA, PerfilConstantesFunciones.IDSISTEMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilConstantesFunciones.LABEL_CODIGO, PerfilConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilConstantesFunciones.LABEL_NOMBRE, PerfilConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilConstantesFunciones.LABEL_NOMBRE2, PerfilConstantesFunciones.NOMBRE2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PerfilConstantesFunciones.LABEL_ESTADO, PerfilConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPerfil() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PerfilConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilConstantesFunciones.IDSISTEMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilConstantesFunciones.NOMBRE2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PerfilConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPerfil() throws Exception  {
		return PerfilConstantesFunciones.getTiposSeleccionarPerfil(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPerfil(Boolean conFk) throws Exception  {
		return PerfilConstantesFunciones.getTiposSeleccionarPerfil(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPerfil(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilConstantesFunciones.LABEL_IDSISTEMA);
			reporte.setsDescripcion(PerfilConstantesFunciones.LABEL_IDSISTEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PerfilConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PerfilConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilConstantesFunciones.LABEL_NOMBRE2);
			reporte.setsDescripcion(PerfilConstantesFunciones.LABEL_NOMBRE2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PerfilConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(PerfilConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPerfil(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPerfil(Perfil perfilAux) throws Exception {
		
			perfilAux.setsistema_descripcion(SistemaConstantesFunciones.getSistemaDescripcion(perfilAux.getSistema()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPerfil(List<Perfil> perfilsTemp) throws Exception {
		for(Perfil perfilAux:perfilsTemp) {
			
			perfilAux.setsistema_descripcion(SistemaConstantesFunciones.getSistemaDescripcion(perfilAux.getSistema()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPerfil(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Sistema.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Sistema.class)) {
						classes.add(new Classe(Sistema.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPerfil(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Sistema.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sistema.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Sistema.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sistema.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPerfil(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PerfilConstantesFunciones.getClassesRelationshipsOfPerfil(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPerfil(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PerfilAccion.class));
				classes.add(new Classe(PerfilCampo.class));
				if(conMuchosAMuchos) {classes.add(new Classe(Accion.class));}
				classes.add(new Classe(PerfilOpcion.class));
				classes.add(new Classe(PerfilUsuario.class));
				if(conMuchosAMuchos) {classes.add(new Classe(Campo.class));}
				if(conMuchosAMuchos) {classes.add(new Classe(Usuario.class));}
				classes.add(new Classe(UsuarioOpcion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PerfilAccion.class)) {
						classes.add(new Classe(PerfilAccion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PerfilCampo.class)) {
						classes.add(new Classe(PerfilCampo.class)); break;
					}
				}

				if(conMuchosAMuchos) {
				for(Classe clas:classesP) {
					if(clas.clas.equals(Accion.class)) {
						classes.add(new Classe(Accion.class)); break;
					}
				}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PerfilOpcion.class)) {
						classes.add(new Classe(PerfilOpcion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PerfilUsuario.class)) {
						classes.add(new Classe(PerfilUsuario.class)); break;
					}
				}

				if(conMuchosAMuchos) {
				for(Classe clas:classesP) {
					if(clas.clas.equals(Campo.class)) {
						classes.add(new Classe(Campo.class)); break;
					}
				}
				}

				if(conMuchosAMuchos) {
				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class)); break;
					}
				}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(UsuarioOpcion.class)) {
						classes.add(new Classe(UsuarioOpcion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPerfil(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PerfilConstantesFunciones.getClassesRelationshipsFromStringsOfPerfil(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPerfil(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PerfilAccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilAccion.class)); continue;
					}

					if(PerfilCampo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilCampo.class)); continue;
					}

					if(conMuchosAMuchos && Accion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Accion.class)); continue;
					}

					if(PerfilOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilOpcion.class)); continue;
					}

					if(PerfilUsuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilUsuario.class)); continue;
					}

					if(conMuchosAMuchos && Campo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Campo.class)); continue;
					}

					if(conMuchosAMuchos && Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(UsuarioOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UsuarioOpcion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PerfilAccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilAccion.class)); continue;
					}

					if(PerfilCampo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilCampo.class)); continue;
					}

					if(conMuchosAMuchos && Accion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Accion.class)); continue;
					}

					if(PerfilOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilOpcion.class)); continue;
					}

					if(PerfilUsuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilUsuario.class)); continue;
					}

					if(conMuchosAMuchos && Campo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Campo.class)); continue;
					}

					if(conMuchosAMuchos && Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(UsuarioOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UsuarioOpcion.class)); continue;
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
	public static void actualizarLista(Perfil perfil,List<Perfil> perfils,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Perfil perfilEncontrado=null;
			
			for(Perfil perfilLocal:perfils) {
				if(perfilLocal.getId().equals(perfil.getId())) {
					perfilEncontrado=perfilLocal;
					
					perfilLocal.setIsChanged(perfil.getIsChanged());
					perfilLocal.setIsNew(perfil.getIsNew());
					perfilLocal.setIsDeleted(perfil.getIsDeleted());
					
					perfilLocal.setGeneralEntityOriginal(perfil.getGeneralEntityOriginal());
					
					perfilLocal.setId(perfil.getId());	
					perfilLocal.setVersionRow(perfil.getVersionRow());	
					perfilLocal.setid_sistema(perfil.getid_sistema());	
					perfilLocal.setcodigo(perfil.getcodigo());	
					perfilLocal.setnombre(perfil.getnombre());	
					perfilLocal.setnombre2(perfil.getnombre2());	
					perfilLocal.setestado(perfil.getestado());	
					
					
					perfilLocal.setUsuarioOpcions(perfil.getUsuarioOpcions());
					perfilLocal.setPerfilUsuarios(perfil.getPerfilUsuarios());
					perfilLocal.setPerfilOpcions(perfil.getPerfilOpcions());
					
					existe=true;
					break;
				}
			}
			
			if(!perfil.getIsDeleted()) {
				if(!existe) {
					perfils.add(perfil);
				}
			} else {
				if(perfilEncontrado!=null && permiteQuitar)  {
					perfils.remove(perfilEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Perfil perfil,List<Perfil> perfils) throws Exception {
		try	{			
			for(Perfil perfilLocal:perfils) {
				if(perfilLocal.getId().equals(perfil.getId())) {
					perfilLocal.setIsSelected(perfil.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPerfil(List<Perfil> perfilsAux) throws Exception {
		//this.perfilsAux=perfilsAux;
		
		for(Perfil perfilAux:perfilsAux) {
			if(perfilAux.getIsChanged()) {
				perfilAux.setIsChanged(false);
			}		
			
			if(perfilAux.getIsNew()) {
				perfilAux.setIsNew(false);
			}	
			
			if(perfilAux.getIsDeleted()) {
				perfilAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPerfil(Perfil perfilAux) throws Exception {
		//this.perfilAux=perfilAux;
		
			if(perfilAux.getIsChanged()) {
				perfilAux.setIsChanged(false);
			}		
			
			if(perfilAux.getIsNew()) {
				perfilAux.setIsNew(false);
			}	
			
			if(perfilAux.getIsDeleted()) {
				perfilAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Perfil perfilAsignar,Perfil perfil) throws Exception {
		perfilAsignar.setId(perfil.getId());	
		perfilAsignar.setVersionRow(perfil.getVersionRow());	
		perfilAsignar.setid_sistema(perfil.getid_sistema());
		perfilAsignar.setsistema_descripcion(perfil.getsistema_descripcion());	
		perfilAsignar.setcodigo(perfil.getcodigo());	
		perfilAsignar.setnombre(perfil.getnombre());	
		perfilAsignar.setnombre2(perfil.getnombre2());	
		perfilAsignar.setestado(perfil.getestado());	
	}
	
	public static void inicializarPerfil(Perfil perfil) throws Exception {
		try {
				perfil.setId(0L);	
					
				perfil.setid_sistema(-1L);	
				perfil.setcodigo("");	
				perfil.setnombre("");	
				perfil.setnombre2("");	
				perfil.setestado(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPerfil(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilConstantesFunciones.LABEL_IDSISTEMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilConstantesFunciones.LABEL_NOMBRE2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PerfilConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPerfil(String sTipo,Row row,Workbook workbook,Perfil perfil,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(perfil.getsistema_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(perfil.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(perfil.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(perfil.getnombre2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(perfil.getestado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPerfil=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPerfil() {
		return this.sFinalQueryPerfil;
	}
	
	public void setsFinalQueryPerfil(String sFinalQueryPerfil) {
		this.sFinalQueryPerfil= sFinalQueryPerfil;
	}
	
	public Border resaltarSeleccionarPerfil=null;
	
	public Border setResaltarSeleccionarPerfil(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilBeanSwingJInternalFrame perfilBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//perfilBeanSwingJInternalFrame.jTtoolBarPerfil.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPerfil= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPerfil() {
		return this.resaltarSeleccionarPerfil;
	}
	
	public void setResaltarSeleccionarPerfil(Border borderResaltarSeleccionarPerfil) {
		this.resaltarSeleccionarPerfil= borderResaltarSeleccionarPerfil;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPerfil=null;
	public Boolean mostraridPerfil=true;
	public Boolean activaridPerfil=true;

	public Border resaltarid_sistemaPerfil=null;
	public Boolean mostrarid_sistemaPerfil=true;
	public Boolean activarid_sistemaPerfil=true;
	public Boolean cargarid_sistemaPerfil=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sistemaPerfil=false;//ConEventDepend=true

	public Border resaltarcodigoPerfil=null;
	public Boolean mostrarcodigoPerfil=true;
	public Boolean activarcodigoPerfil=true;

	public Border resaltarnombrePerfil=null;
	public Boolean mostrarnombrePerfil=true;
	public Boolean activarnombrePerfil=true;

	public Border resaltarnombre2Perfil=null;
	public Boolean mostrarnombre2Perfil=true;
	public Boolean activarnombre2Perfil=true;

	public Border resaltarestadoPerfil=null;
	public Boolean mostrarestadoPerfil=true;
	public Boolean activarestadoPerfil=true;

	
	

	public Border setResaltaridPerfil(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilBeanSwingJInternalFrame perfilBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilBeanSwingJInternalFrame.jTtoolBarPerfil.setBorder(borderResaltar);
		
		this.resaltaridPerfil= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPerfil() {
		return this.resaltaridPerfil;
	}

	public void setResaltaridPerfil(Border borderResaltar) {
		this.resaltaridPerfil= borderResaltar;
	}

	public Boolean getMostraridPerfil() {
		return this.mostraridPerfil;
	}

	public void setMostraridPerfil(Boolean mostraridPerfil) {
		this.mostraridPerfil= mostraridPerfil;
	}

	public Boolean getActivaridPerfil() {
		return this.activaridPerfil;
	}

	public void setActivaridPerfil(Boolean activaridPerfil) {
		this.activaridPerfil= activaridPerfil;
	}

	public Border setResaltarid_sistemaPerfil(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilBeanSwingJInternalFrame perfilBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilBeanSwingJInternalFrame.jTtoolBarPerfil.setBorder(borderResaltar);
		
		this.resaltarid_sistemaPerfil= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sistemaPerfil() {
		return this.resaltarid_sistemaPerfil;
	}

	public void setResaltarid_sistemaPerfil(Border borderResaltar) {
		this.resaltarid_sistemaPerfil= borderResaltar;
	}

	public Boolean getMostrarid_sistemaPerfil() {
		return this.mostrarid_sistemaPerfil;
	}

	public void setMostrarid_sistemaPerfil(Boolean mostrarid_sistemaPerfil) {
		this.mostrarid_sistemaPerfil= mostrarid_sistemaPerfil;
	}

	public Boolean getActivarid_sistemaPerfil() {
		return this.activarid_sistemaPerfil;
	}

	public void setActivarid_sistemaPerfil(Boolean activarid_sistemaPerfil) {
		this.activarid_sistemaPerfil= activarid_sistemaPerfil;
	}

	public Boolean getCargarid_sistemaPerfil() {
		return this.cargarid_sistemaPerfil;
	}

	public void setCargarid_sistemaPerfil(Boolean cargarid_sistemaPerfil) {
		this.cargarid_sistemaPerfil= cargarid_sistemaPerfil;
	}

	public Border setResaltarcodigoPerfil(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilBeanSwingJInternalFrame perfilBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilBeanSwingJInternalFrame.jTtoolBarPerfil.setBorder(borderResaltar);
		
		this.resaltarcodigoPerfil= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPerfil() {
		return this.resaltarcodigoPerfil;
	}

	public void setResaltarcodigoPerfil(Border borderResaltar) {
		this.resaltarcodigoPerfil= borderResaltar;
	}

	public Boolean getMostrarcodigoPerfil() {
		return this.mostrarcodigoPerfil;
	}

	public void setMostrarcodigoPerfil(Boolean mostrarcodigoPerfil) {
		this.mostrarcodigoPerfil= mostrarcodigoPerfil;
	}

	public Boolean getActivarcodigoPerfil() {
		return this.activarcodigoPerfil;
	}

	public void setActivarcodigoPerfil(Boolean activarcodigoPerfil) {
		this.activarcodigoPerfil= activarcodigoPerfil;
	}

	public Border setResaltarnombrePerfil(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilBeanSwingJInternalFrame perfilBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilBeanSwingJInternalFrame.jTtoolBarPerfil.setBorder(borderResaltar);
		
		this.resaltarnombrePerfil= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePerfil() {
		return this.resaltarnombrePerfil;
	}

	public void setResaltarnombrePerfil(Border borderResaltar) {
		this.resaltarnombrePerfil= borderResaltar;
	}

	public Boolean getMostrarnombrePerfil() {
		return this.mostrarnombrePerfil;
	}

	public void setMostrarnombrePerfil(Boolean mostrarnombrePerfil) {
		this.mostrarnombrePerfil= mostrarnombrePerfil;
	}

	public Boolean getActivarnombrePerfil() {
		return this.activarnombrePerfil;
	}

	public void setActivarnombrePerfil(Boolean activarnombrePerfil) {
		this.activarnombrePerfil= activarnombrePerfil;
	}

	public Border setResaltarnombre2Perfil(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilBeanSwingJInternalFrame perfilBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilBeanSwingJInternalFrame.jTtoolBarPerfil.setBorder(borderResaltar);
		
		this.resaltarnombre2Perfil= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre2Perfil() {
		return this.resaltarnombre2Perfil;
	}

	public void setResaltarnombre2Perfil(Border borderResaltar) {
		this.resaltarnombre2Perfil= borderResaltar;
	}

	public Boolean getMostrarnombre2Perfil() {
		return this.mostrarnombre2Perfil;
	}

	public void setMostrarnombre2Perfil(Boolean mostrarnombre2Perfil) {
		this.mostrarnombre2Perfil= mostrarnombre2Perfil;
	}

	public Boolean getActivarnombre2Perfil() {
		return this.activarnombre2Perfil;
	}

	public void setActivarnombre2Perfil(Boolean activarnombre2Perfil) {
		this.activarnombre2Perfil= activarnombre2Perfil;
	}

	public Border setResaltarestadoPerfil(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilBeanSwingJInternalFrame perfilBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//perfilBeanSwingJInternalFrame.jTtoolBarPerfil.setBorder(borderResaltar);
		
		this.resaltarestadoPerfil= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoPerfil() {
		return this.resaltarestadoPerfil;
	}

	public void setResaltarestadoPerfil(Border borderResaltar) {
		this.resaltarestadoPerfil= borderResaltar;
	}

	public Boolean getMostrarestadoPerfil() {
		return this.mostrarestadoPerfil;
	}

	public void setMostrarestadoPerfil(Boolean mostrarestadoPerfil) {
		this.mostrarestadoPerfil= mostrarestadoPerfil;
	}

	public Boolean getActivarestadoPerfil() {
		return this.activarestadoPerfil;
	}

	public void setActivarestadoPerfil(Boolean activarestadoPerfil) {
		this.activarestadoPerfil= activarestadoPerfil;
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
		
		
		this.setMostraridPerfil(esInicial);
		this.setMostrarid_sistemaPerfil(esInicial);
		this.setMostrarcodigoPerfil(esInicial);
		this.setMostrarnombrePerfil(esInicial);
		this.setMostrarnombre2Perfil(esInicial);
		this.setMostrarestadoPerfil(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PerfilConstantesFunciones.ID)) {
				this.setMostraridPerfil(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilConstantesFunciones.IDSISTEMA)) {
				this.setMostrarid_sistemaPerfil(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPerfil(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePerfil(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilConstantesFunciones.NOMBRE2)) {
				this.setMostrarnombre2Perfil(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilConstantesFunciones.ESTADO)) {
				this.setMostrarestadoPerfil(esAsigna);
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
		
		
		this.setActivaridPerfil(esInicial);
		this.setActivarid_sistemaPerfil(esInicial);
		this.setActivarcodigoPerfil(esInicial);
		this.setActivarnombrePerfil(esInicial);
		this.setActivarnombre2Perfil(esInicial);
		this.setActivarestadoPerfil(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PerfilConstantesFunciones.ID)) {
				this.setActivaridPerfil(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilConstantesFunciones.IDSISTEMA)) {
				this.setActivarid_sistemaPerfil(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPerfil(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePerfil(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilConstantesFunciones.NOMBRE2)) {
				this.setActivarnombre2Perfil(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilConstantesFunciones.ESTADO)) {
				this.setActivarestadoPerfil(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PerfilBeanSwingJInternalFrame perfilBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPerfil(esInicial);
		this.setResaltarid_sistemaPerfil(esInicial);
		this.setResaltarcodigoPerfil(esInicial);
		this.setResaltarnombrePerfil(esInicial);
		this.setResaltarnombre2Perfil(esInicial);
		this.setResaltarestadoPerfil(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PerfilConstantesFunciones.ID)) {
				this.setResaltaridPerfil(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilConstantesFunciones.IDSISTEMA)) {
				this.setResaltarid_sistemaPerfil(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPerfil(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePerfil(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilConstantesFunciones.NOMBRE2)) {
				this.setResaltarnombre2Perfil(esAsigna);
				continue;
			}

			if(campo.clase.equals(PerfilConstantesFunciones.ESTADO)) {
				this.setResaltarestadoPerfil(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPerfilOpcionPerfil=null;

	public Border getResaltarPerfilOpcionPerfil() {
		return this.resaltarPerfilOpcionPerfil;
	}

	public void setResaltarPerfilOpcionPerfil(Border borderResaltarPerfilOpcion) {
		if(borderResaltarPerfilOpcion!=null) {
			this.resaltarPerfilOpcionPerfil= borderResaltarPerfilOpcion;
		}
	}

	public Border setResaltarPerfilOpcionPerfil(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilBeanSwingJInternalFrame perfilBeanSwingJInternalFrame*/) {
		Border borderResaltarPerfilOpcion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//perfilBeanSwingJInternalFrame.jTtoolBarPerfil.setBorder(borderResaltarPerfilOpcion);
			
		this.resaltarPerfilOpcionPerfil= borderResaltarPerfilOpcion;

		 return borderResaltarPerfilOpcion;
	}



	public Boolean mostrarPerfilOpcionPerfil=true;

	public Boolean getMostrarPerfilOpcionPerfil() {
		return this.mostrarPerfilOpcionPerfil;
	}

	public void setMostrarPerfilOpcionPerfil(Boolean visibilidadResaltarPerfilOpcion) {
		this.mostrarPerfilOpcionPerfil= visibilidadResaltarPerfilOpcion;
	}



	public Boolean activarPerfilOpcionPerfil=true;

	public Boolean gethabilitarResaltarPerfilOpcionPerfil() {
		return this.activarPerfilOpcionPerfil;
	}

	public void setActivarPerfilOpcionPerfil(Boolean habilitarResaltarPerfilOpcion) {
		this.activarPerfilOpcionPerfil= habilitarResaltarPerfilOpcion;
	}


	public Border resaltarPerfilUsuarioPerfil=null;

	public Border getResaltarPerfilUsuarioPerfil() {
		return this.resaltarPerfilUsuarioPerfil;
	}

	public void setResaltarPerfilUsuarioPerfil(Border borderResaltarPerfilUsuario) {
		if(borderResaltarPerfilUsuario!=null) {
			this.resaltarPerfilUsuarioPerfil= borderResaltarPerfilUsuario;
		}
	}

	public Border setResaltarPerfilUsuarioPerfil(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilBeanSwingJInternalFrame perfilBeanSwingJInternalFrame*/) {
		Border borderResaltarPerfilUsuario=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//perfilBeanSwingJInternalFrame.jTtoolBarPerfil.setBorder(borderResaltarPerfilUsuario);
			
		this.resaltarPerfilUsuarioPerfil= borderResaltarPerfilUsuario;

		 return borderResaltarPerfilUsuario;
	}



	public Boolean mostrarPerfilUsuarioPerfil=true;

	public Boolean getMostrarPerfilUsuarioPerfil() {
		return this.mostrarPerfilUsuarioPerfil;
	}

	public void setMostrarPerfilUsuarioPerfil(Boolean visibilidadResaltarPerfilUsuario) {
		this.mostrarPerfilUsuarioPerfil= visibilidadResaltarPerfilUsuario;
	}



	public Boolean activarPerfilUsuarioPerfil=true;

	public Boolean gethabilitarResaltarPerfilUsuarioPerfil() {
		return this.activarPerfilUsuarioPerfil;
	}

	public void setActivarPerfilUsuarioPerfil(Boolean habilitarResaltarPerfilUsuario) {
		this.activarPerfilUsuarioPerfil= habilitarResaltarPerfilUsuario;
	}


	public Border resaltarUsuarioOpcionPerfil=null;

	public Border getResaltarUsuarioOpcionPerfil() {
		return this.resaltarUsuarioOpcionPerfil;
	}

	public void setResaltarUsuarioOpcionPerfil(Border borderResaltarUsuarioOpcion) {
		if(borderResaltarUsuarioOpcion!=null) {
			this.resaltarUsuarioOpcionPerfil= borderResaltarUsuarioOpcion;
		}
	}

	public Border setResaltarUsuarioOpcionPerfil(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilBeanSwingJInternalFrame perfilBeanSwingJInternalFrame*/) {
		Border borderResaltarUsuarioOpcion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//perfilBeanSwingJInternalFrame.jTtoolBarPerfil.setBorder(borderResaltarUsuarioOpcion);
			
		this.resaltarUsuarioOpcionPerfil= borderResaltarUsuarioOpcion;

		 return borderResaltarUsuarioOpcion;
	}



	public Boolean mostrarUsuarioOpcionPerfil=true;

	public Boolean getMostrarUsuarioOpcionPerfil() {
		return this.mostrarUsuarioOpcionPerfil;
	}

	public void setMostrarUsuarioOpcionPerfil(Boolean visibilidadResaltarUsuarioOpcion) {
		this.mostrarUsuarioOpcionPerfil= visibilidadResaltarUsuarioOpcion;
	}



	public Boolean activarUsuarioOpcionPerfil=true;

	public Boolean gethabilitarResaltarUsuarioOpcionPerfil() {
		return this.activarUsuarioOpcionPerfil;
	}

	public void setActivarUsuarioOpcionPerfil(Boolean habilitarResaltarUsuarioOpcion) {
		this.activarUsuarioOpcionPerfil= habilitarResaltarUsuarioOpcion;
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

		this.setMostrarPerfilOpcionPerfil(esInicial);
		this.setMostrarPerfilUsuarioPerfil(esInicial);
		this.setMostrarUsuarioOpcionPerfil(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PerfilOpcion.class)) {
				this.setMostrarPerfilOpcionPerfil(esAsigna);
				continue;
			}

			if(clase.clas.equals(PerfilUsuario.class)) {
				this.setMostrarPerfilUsuarioPerfil(esAsigna);
				continue;
			}

			if(clase.clas.equals(UsuarioOpcion.class)) {
				this.setMostrarUsuarioOpcionPerfil(esAsigna);
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

		this.setActivarPerfilOpcionPerfil(esInicial);
		this.setActivarPerfilUsuarioPerfil(esInicial);
		this.setActivarUsuarioOpcionPerfil(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PerfilOpcion.class)) {
				this.setActivarPerfilOpcionPerfil(esAsigna);
				continue;
			}

			if(clase.clas.equals(PerfilUsuario.class)) {
				this.setActivarPerfilUsuarioPerfil(esAsigna);
				continue;
			}

			if(clase.clas.equals(UsuarioOpcion.class)) {
				this.setActivarUsuarioOpcionPerfil(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PerfilBeanSwingJInternalFrame perfilBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPerfilOpcionPerfil(esInicial);
		this.setResaltarPerfilUsuarioPerfil(esInicial);
		this.setResaltarUsuarioOpcionPerfil(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PerfilOpcion.class)) {
				this.setResaltarPerfilOpcionPerfil(esAsigna);
				continue;
			}

			if(clase.clas.equals(PerfilUsuario.class)) {
				this.setResaltarPerfilUsuarioPerfil(esAsigna);
				continue;
			}

			if(clase.clas.equals(UsuarioOpcion.class)) {
				this.setResaltarUsuarioOpcionPerfil(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombrePerfil=true;

	public Boolean getMostrarBusquedaPorNombrePerfil() {
		return this.mostrarBusquedaPorNombrePerfil;
	}

	public void setMostrarBusquedaPorNombrePerfil(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombrePerfil= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombre2Perfil=true;

	public Boolean getMostrarBusquedaPorNombre2Perfil() {
		return this.mostrarBusquedaPorNombre2Perfil;
	}

	public void setMostrarBusquedaPorNombre2Perfil(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombre2Perfil= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSistemaPerfil=true;

	public Boolean getMostrarFK_IdSistemaPerfil() {
		return this.mostrarFK_IdSistemaPerfil;
	}

	public void setMostrarFK_IdSistemaPerfil(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSistemaPerfil= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombrePerfil=true;

	public Boolean getActivarBusquedaPorNombrePerfil() {
		return this.activarBusquedaPorNombrePerfil;
	}

	public void setActivarBusquedaPorNombrePerfil(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombrePerfil= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombre2Perfil=true;

	public Boolean getActivarBusquedaPorNombre2Perfil() {
		return this.activarBusquedaPorNombre2Perfil;
	}

	public void setActivarBusquedaPorNombre2Perfil(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombre2Perfil= habilitarResaltar;
	}

	public Boolean activarFK_IdSistemaPerfil=true;

	public Boolean getActivarFK_IdSistemaPerfil() {
		return this.activarFK_IdSistemaPerfil;
	}

	public void setActivarFK_IdSistemaPerfil(Boolean habilitarResaltar) {
		this.activarFK_IdSistemaPerfil= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombrePerfil=null;

	public Border getResaltarBusquedaPorNombrePerfil() {
		return this.resaltarBusquedaPorNombrePerfil;
	}

	public void setResaltarBusquedaPorNombrePerfil(Border borderResaltar) {
		this.resaltarBusquedaPorNombrePerfil= borderResaltar;
	}

	public void setResaltarBusquedaPorNombrePerfil(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilBeanSwingJInternalFrame perfilBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombrePerfil= borderResaltar;
	}

	public Border resaltarBusquedaPorNombre2Perfil=null;

	public Border getResaltarBusquedaPorNombre2Perfil() {
		return this.resaltarBusquedaPorNombre2Perfil;
	}

	public void setResaltarBusquedaPorNombre2Perfil(Border borderResaltar) {
		this.resaltarBusquedaPorNombre2Perfil= borderResaltar;
	}

	public void setResaltarBusquedaPorNombre2Perfil(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilBeanSwingJInternalFrame perfilBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombre2Perfil= borderResaltar;
	}

	public Border resaltarFK_IdSistemaPerfil=null;

	public Border getResaltarFK_IdSistemaPerfil() {
		return this.resaltarFK_IdSistemaPerfil;
	}

	public void setResaltarFK_IdSistemaPerfil(Border borderResaltar) {
		this.resaltarFK_IdSistemaPerfil= borderResaltar;
	}

	public void setResaltarFK_IdSistemaPerfil(ParametroGeneralUsuario parametroGeneralUsuario/*PerfilBeanSwingJInternalFrame perfilBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSistemaPerfil= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}