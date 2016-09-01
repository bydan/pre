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


import com.bydan.erp.seguridad.util.GrupoOpcionConstantesFunciones;
import com.bydan.erp.seguridad.util.GrupoOpcionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.GrupoOpcionParameterGeneral;

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
final public class GrupoOpcionConstantesFunciones extends GrupoOpcionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="GrupoOpcion";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="GrupoOpcion"+GrupoOpcionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="GrupoOpcionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="GrupoOpcionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=GrupoOpcionConstantesFunciones.SCHEMA+"_"+GrupoOpcionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/GrupoOpcionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=GrupoOpcionConstantesFunciones.SCHEMA+"_"+GrupoOpcionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=GrupoOpcionConstantesFunciones.SCHEMA+"_"+GrupoOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/GrupoOpcionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=GrupoOpcionConstantesFunciones.SCHEMA+"_"+GrupoOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GrupoOpcionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GrupoOpcionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoOpcionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=GrupoOpcionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+GrupoOpcionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=GrupoOpcionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+GrupoOpcionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Grupo Opcions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Grupo Opcion";
	public static final String SCLASSWEBTITULO_LOWER="Grupo Opcion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="GrupoOpcion";
	public static final String OBJECTNAME="grupoopcion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="grupo_opcion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select grupoopcion from "+GrupoOpcionConstantesFunciones.SPERSISTENCENAME+" grupoopcion";
	public static String QUERYSELECTNATIVE="select "+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".id,"+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".version_row,"+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".id_modulo,"+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".codigo,"+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".nombre_principal,"+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".orden,"+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".estado from "+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME;//+" as "+GrupoOpcionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=true;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected GrupoOpcionConstantesFuncionesAdditional grupoopcionConstantesFuncionesAdditional=null;
	
	public GrupoOpcionConstantesFuncionesAdditional getGrupoOpcionConstantesFuncionesAdditional() {
		return this.grupoopcionConstantesFuncionesAdditional;
	}
	
	public void setGrupoOpcionConstantesFuncionesAdditional(GrupoOpcionConstantesFuncionesAdditional grupoopcionConstantesFuncionesAdditional) {
		try {
			this.grupoopcionConstantesFuncionesAdditional=grupoopcionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDMODULO= "id_modulo";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre_principal";
    public static final String ORDEN= "orden";
    public static final String ESTADO= "estado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "A";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "A";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre Principal";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
    	public static final String LABEL_ESTADO= "Estado";
		public static final String LABEL_ESTADO_LOWER= "Estado";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRINCIPAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRINCIPAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getGrupoOpcionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(GrupoOpcionConstantesFunciones.IDMODULO)) {sLabelColumna=GrupoOpcionConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(GrupoOpcionConstantesFunciones.CODIGO)) {sLabelColumna=GrupoOpcionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(GrupoOpcionConstantesFunciones.NOMBRE)) {sLabelColumna=GrupoOpcionConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(GrupoOpcionConstantesFunciones.ORDEN)) {sLabelColumna=GrupoOpcionConstantesFunciones.LABEL_ORDEN;}
		if(sNombreColumna.equals(GrupoOpcionConstantesFunciones.ESTADO)) {sLabelColumna=GrupoOpcionConstantesFunciones.LABEL_ESTADO;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getestadoDescripcion(GrupoOpcion grupoopcion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!grupoopcion.getestado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getestadoHtmlDescripcion(GrupoOpcion grupoopcion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(grupoopcion.getId(),grupoopcion.getestado());

		return sDescripcion;
	}	
	
	public static String getGrupoOpcionDescripcion(GrupoOpcion grupoopcion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(grupoopcion !=null/* && grupoopcion.getId()!=0*/) {
			sDescripcion=grupoopcion.getnombre_principal();//grupoopciongrupoopcion.getnombre_principal().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getGrupoOpcionDescripcionDetallado(GrupoOpcion grupoopcion) {
		String sDescripcion="";
			
		sDescripcion+=GrupoOpcionConstantesFunciones.ID+"=";
		sDescripcion+=grupoopcion.getId().toString()+",";
		sDescripcion+=GrupoOpcionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=grupoopcion.getVersionRow().toString()+",";
		sDescripcion+=GrupoOpcionConstantesFunciones.IDMODULO+"=";
		sDescripcion+=grupoopcion.getid_modulo().toString()+",";
		sDescripcion+=GrupoOpcionConstantesFunciones.CODIGO+"=";
		sDescripcion+=grupoopcion.getcodigo()+",";
		sDescripcion+=GrupoOpcionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=grupoopcion.getnombre_principal()+",";
		sDescripcion+=GrupoOpcionConstantesFunciones.ORDEN+"=";
		sDescripcion+=grupoopcion.getorden().toString()+",";
		sDescripcion+=GrupoOpcionConstantesFunciones.ESTADO+"=";
		sDescripcion+=grupoopcion.getestado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setGrupoOpcionDescripcion(GrupoOpcion grupoopcion,String sValor) throws Exception {			
		if(grupoopcion !=null) {
			grupoopcion.setnombre_principal(sValor);;//grupoopciongrupoopcion.getnombre_principal().trim();
		}		
	}
	
		

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaIdModuloPorNombre")) {
			sNombreIndice="Tipo=  Por Modulo Por Nombre Principal";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("PorIdModuloPorCodigo")) {
			sNombreIndice="Tipo=  Por Modulo Por Codigo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaIdModuloPorNombre(Long id_modulo,String nombre_principal) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(nombre_principal!=null) {sDetalleIndice+=" Nombre Principal="+nombre_principal;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdModuloPorCodigo(Long id_modulo,String codigo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosGrupoOpcion(GrupoOpcion grupoopcion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		grupoopcion.setcodigo(grupoopcion.getcodigo().trim());
		grupoopcion.setnombre_principal(grupoopcion.getnombre_principal().trim());
	}
	
	public static void quitarEspaciosGrupoOpcions(List<GrupoOpcion> grupoopcions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GrupoOpcion grupoopcion: grupoopcions) {
			grupoopcion.setcodigo(grupoopcion.getcodigo().trim());
			grupoopcion.setnombre_principal(grupoopcion.getnombre_principal().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGrupoOpcion(GrupoOpcion grupoopcion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && grupoopcion.getConCambioAuxiliar()) {
			grupoopcion.setIsDeleted(grupoopcion.getIsDeletedAuxiliar());	
			grupoopcion.setIsNew(grupoopcion.getIsNewAuxiliar());	
			grupoopcion.setIsChanged(grupoopcion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			grupoopcion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			grupoopcion.setIsDeletedAuxiliar(false);	
			grupoopcion.setIsNewAuxiliar(false);	
			grupoopcion.setIsChangedAuxiliar(false);
			
			grupoopcion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGrupoOpcions(List<GrupoOpcion> grupoopcions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(GrupoOpcion grupoopcion : grupoopcions) {
			if(conAsignarBase && grupoopcion.getConCambioAuxiliar()) {
				grupoopcion.setIsDeleted(grupoopcion.getIsDeletedAuxiliar());	
				grupoopcion.setIsNew(grupoopcion.getIsNewAuxiliar());	
				grupoopcion.setIsChanged(grupoopcion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				grupoopcion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				grupoopcion.setIsDeletedAuxiliar(false);	
				grupoopcion.setIsNewAuxiliar(false);	
				grupoopcion.setIsChangedAuxiliar(false);
				
				grupoopcion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresGrupoOpcion(GrupoOpcion grupoopcion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			grupoopcion.setorden(0);
		}
	}		
	
	public static void InicializarValoresGrupoOpcions(List<GrupoOpcion> grupoopcions,Boolean conEnteros) throws Exception  {
		
		for(GrupoOpcion grupoopcion: grupoopcions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				grupoopcion.setorden(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaGrupoOpcion(List<GrupoOpcion> grupoopcions,GrupoOpcion grupoopcionAux) throws Exception  {
		GrupoOpcionConstantesFunciones.InicializarValoresGrupoOpcion(grupoopcionAux,true);
		
		for(GrupoOpcion grupoopcion: grupoopcions) {
			if(grupoopcion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			grupoopcionAux.setorden(grupoopcionAux.getorden()+grupoopcion.getorden());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGrupoOpcion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=GrupoOpcionConstantesFunciones.getArrayColumnasGlobalesGrupoOpcion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesGrupoOpcion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GrupoOpcionConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GrupoOpcionConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoGrupoOpcion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GrupoOpcion> grupoopcions,GrupoOpcion grupoopcion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GrupoOpcion grupoopcionAux: grupoopcions) {
			if(grupoopcionAux!=null && grupoopcion!=null) {
				if((grupoopcionAux.getId()==null && grupoopcion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(grupoopcionAux.getId()!=null && grupoopcion.getId()!=null){
					if(grupoopcionAux.getId().equals(grupoopcion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGrupoOpcion(List<GrupoOpcion> grupoopcions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(GrupoOpcion grupoopcion: grupoopcions) {			
			if(grupoopcion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaGrupoOpcion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,GrupoOpcionConstantesFunciones.LABEL_ID, GrupoOpcionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoOpcionConstantesFunciones.LABEL_VERSIONROW, GrupoOpcionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoOpcionConstantesFunciones.LABEL_IDMODULO, GrupoOpcionConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoOpcionConstantesFunciones.LABEL_CODIGO, GrupoOpcionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoOpcionConstantesFunciones.LABEL_NOMBRE, GrupoOpcionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoOpcionConstantesFunciones.LABEL_ORDEN, GrupoOpcionConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoOpcionConstantesFunciones.LABEL_ESTADO, GrupoOpcionConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasGrupoOpcion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=GrupoOpcionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoOpcionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoOpcionConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoOpcionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoOpcionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoOpcionConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoOpcionConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoOpcion() throws Exception  {
		return GrupoOpcionConstantesFunciones.getTiposSeleccionarGrupoOpcion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoOpcion(Boolean conFk) throws Exception  {
		return GrupoOpcionConstantesFunciones.getTiposSeleccionarGrupoOpcion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoOpcion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoOpcionConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(GrupoOpcionConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoOpcionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(GrupoOpcionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoOpcionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(GrupoOpcionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoOpcionConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(GrupoOpcionConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoOpcionConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(GrupoOpcionConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesGrupoOpcion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesGrupoOpcion(GrupoOpcion grupoopcionAux) throws Exception {
		
			grupoopcionAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(grupoopcionAux.getModulo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesGrupoOpcion(List<GrupoOpcion> grupoopcionsTemp) throws Exception {
		for(GrupoOpcion grupoopcionAux:grupoopcionsTemp) {
			
			grupoopcionAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(grupoopcionAux.getModulo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfGrupoOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Modulo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfGrupoOpcion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return GrupoOpcionConstantesFunciones.getClassesRelationshipsOfGrupoOpcion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(UsuarioOpcion.class));
				classes.add(new Classe(Opcion.class));
				classes.add(new Classe(PerfilOpcion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(UsuarioOpcion.class)) {
						classes.add(new Classe(UsuarioOpcion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Opcion.class)) {
						classes.add(new Classe(Opcion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PerfilOpcion.class)) {
						classes.add(new Classe(PerfilOpcion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGrupoOpcion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return GrupoOpcionConstantesFunciones.getClassesRelationshipsFromStringsOfGrupoOpcion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGrupoOpcion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(UsuarioOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UsuarioOpcion.class)); continue;
					}

					if(Opcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Opcion.class)); continue;
					}

					if(PerfilOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilOpcion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(UsuarioOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UsuarioOpcion.class)); continue;
					}

					if(Opcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Opcion.class)); continue;
					}

					if(PerfilOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilOpcion.class)); continue;
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
	public static void actualizarLista(GrupoOpcion grupoopcion,List<GrupoOpcion> grupoopcions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			GrupoOpcion grupoopcionEncontrado=null;
			
			for(GrupoOpcion grupoopcionLocal:grupoopcions) {
				if(grupoopcionLocal.getId().equals(grupoopcion.getId())) {
					grupoopcionEncontrado=grupoopcionLocal;
					
					grupoopcionLocal.setIsChanged(grupoopcion.getIsChanged());
					grupoopcionLocal.setIsNew(grupoopcion.getIsNew());
					grupoopcionLocal.setIsDeleted(grupoopcion.getIsDeleted());
					
					grupoopcionLocal.setGeneralEntityOriginal(grupoopcion.getGeneralEntityOriginal());
					
					grupoopcionLocal.setId(grupoopcion.getId());	
					grupoopcionLocal.setVersionRow(grupoopcion.getVersionRow());	
					grupoopcionLocal.setid_modulo(grupoopcion.getid_modulo());	
					grupoopcionLocal.setcodigo(grupoopcion.getcodigo());	
					grupoopcionLocal.setnombre_principal(grupoopcion.getnombre_principal());	
					grupoopcionLocal.setorden(grupoopcion.getorden());	
					grupoopcionLocal.setestado(grupoopcion.getestado());	
					
					
					grupoopcionLocal.setUsuarioOpcions(grupoopcion.getUsuarioOpcions());
					grupoopcionLocal.setOpcions(grupoopcion.getOpcions());
					grupoopcionLocal.setPerfilOpcions(grupoopcion.getPerfilOpcions());
					
					existe=true;
					break;
				}
			}
			
			if(!grupoopcion.getIsDeleted()) {
				if(!existe) {
					grupoopcions.add(grupoopcion);
				}
			} else {
				if(grupoopcionEncontrado!=null && permiteQuitar)  {
					grupoopcions.remove(grupoopcionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(GrupoOpcion grupoopcion,List<GrupoOpcion> grupoopcions) throws Exception {
		try	{			
			for(GrupoOpcion grupoopcionLocal:grupoopcions) {
				if(grupoopcionLocal.getId().equals(grupoopcion.getId())) {
					grupoopcionLocal.setIsSelected(grupoopcion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesGrupoOpcion(List<GrupoOpcion> grupoopcionsAux) throws Exception {
		//this.grupoopcionsAux=grupoopcionsAux;
		
		for(GrupoOpcion grupoopcionAux:grupoopcionsAux) {
			if(grupoopcionAux.getIsChanged()) {
				grupoopcionAux.setIsChanged(false);
			}		
			
			if(grupoopcionAux.getIsNew()) {
				grupoopcionAux.setIsNew(false);
			}	
			
			if(grupoopcionAux.getIsDeleted()) {
				grupoopcionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesGrupoOpcion(GrupoOpcion grupoopcionAux) throws Exception {
		//this.grupoopcionAux=grupoopcionAux;
		
			if(grupoopcionAux.getIsChanged()) {
				grupoopcionAux.setIsChanged(false);
			}		
			
			if(grupoopcionAux.getIsNew()) {
				grupoopcionAux.setIsNew(false);
			}	
			
			if(grupoopcionAux.getIsDeleted()) {
				grupoopcionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(GrupoOpcion grupoopcionAsignar,GrupoOpcion grupoopcion) throws Exception {
		grupoopcionAsignar.setId(grupoopcion.getId());	
		grupoopcionAsignar.setVersionRow(grupoopcion.getVersionRow());	
		grupoopcionAsignar.setid_modulo(grupoopcion.getid_modulo());
		grupoopcionAsignar.setmodulo_descripcion(grupoopcion.getmodulo_descripcion());	
		grupoopcionAsignar.setcodigo(grupoopcion.getcodigo());	
		grupoopcionAsignar.setnombre_principal(grupoopcion.getnombre_principal());	
		grupoopcionAsignar.setorden(grupoopcion.getorden());	
		grupoopcionAsignar.setestado(grupoopcion.getestado());	
	}
	
	public static void inicializarGrupoOpcion(GrupoOpcion grupoopcion) throws Exception {
		try {
				grupoopcion.setId(0L);	
					
				grupoopcion.setid_modulo(-1L);	
				grupoopcion.setcodigo("");	
				grupoopcion.setnombre_principal("");	
				grupoopcion.setorden(0);	
				grupoopcion.setestado(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderGrupoOpcion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoOpcionConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoOpcionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoOpcionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoOpcionConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoOpcionConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataGrupoOpcion(String sTipo,Row row,Workbook workbook,GrupoOpcion grupoopcion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(grupoopcion.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupoopcion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupoopcion.getnombre_principal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupoopcion.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(grupoopcion.getestado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryGrupoOpcion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryGrupoOpcion() {
		return this.sFinalQueryGrupoOpcion;
	}
	
	public void setsFinalQueryGrupoOpcion(String sFinalQueryGrupoOpcion) {
		this.sFinalQueryGrupoOpcion= sFinalQueryGrupoOpcion;
	}
	
	public Border resaltarSeleccionarGrupoOpcion=null;
	
	public Border setResaltarSeleccionarGrupoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoOpcionBeanSwingJInternalFrame grupoopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//grupoopcionBeanSwingJInternalFrame.jTtoolBarGrupoOpcion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarGrupoOpcion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarGrupoOpcion() {
		return this.resaltarSeleccionarGrupoOpcion;
	}
	
	public void setResaltarSeleccionarGrupoOpcion(Border borderResaltarSeleccionarGrupoOpcion) {
		this.resaltarSeleccionarGrupoOpcion= borderResaltarSeleccionarGrupoOpcion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridGrupoOpcion=null;
	public Boolean mostraridGrupoOpcion=true;
	public Boolean activaridGrupoOpcion=true;

	public Border resaltarid_moduloGrupoOpcion=null;
	public Boolean mostrarid_moduloGrupoOpcion=true;
	public Boolean activarid_moduloGrupoOpcion=true;
	public Boolean cargarid_moduloGrupoOpcion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloGrupoOpcion=false;//ConEventDepend=true

	public Border resaltarcodigoGrupoOpcion=null;
	public Boolean mostrarcodigoGrupoOpcion=true;
	public Boolean activarcodigoGrupoOpcion=true;

	public Border resaltarnombre_principalGrupoOpcion=null;
	public Boolean mostrarnombre_principalGrupoOpcion=true;
	public Boolean activarnombre_principalGrupoOpcion=true;

	public Border resaltarordenGrupoOpcion=null;
	public Boolean mostrarordenGrupoOpcion=true;
	public Boolean activarordenGrupoOpcion=true;

	public Border resaltarestadoGrupoOpcion=null;
	public Boolean mostrarestadoGrupoOpcion=true;
	public Boolean activarestadoGrupoOpcion=true;

	
	

	public Border setResaltaridGrupoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoOpcionBeanSwingJInternalFrame grupoopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoopcionBeanSwingJInternalFrame.jTtoolBarGrupoOpcion.setBorder(borderResaltar);
		
		this.resaltaridGrupoOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridGrupoOpcion() {
		return this.resaltaridGrupoOpcion;
	}

	public void setResaltaridGrupoOpcion(Border borderResaltar) {
		this.resaltaridGrupoOpcion= borderResaltar;
	}

	public Boolean getMostraridGrupoOpcion() {
		return this.mostraridGrupoOpcion;
	}

	public void setMostraridGrupoOpcion(Boolean mostraridGrupoOpcion) {
		this.mostraridGrupoOpcion= mostraridGrupoOpcion;
	}

	public Boolean getActivaridGrupoOpcion() {
		return this.activaridGrupoOpcion;
	}

	public void setActivaridGrupoOpcion(Boolean activaridGrupoOpcion) {
		this.activaridGrupoOpcion= activaridGrupoOpcion;
	}

	public Border setResaltarid_moduloGrupoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoOpcionBeanSwingJInternalFrame grupoopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoopcionBeanSwingJInternalFrame.jTtoolBarGrupoOpcion.setBorder(borderResaltar);
		
		this.resaltarid_moduloGrupoOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloGrupoOpcion() {
		return this.resaltarid_moduloGrupoOpcion;
	}

	public void setResaltarid_moduloGrupoOpcion(Border borderResaltar) {
		this.resaltarid_moduloGrupoOpcion= borderResaltar;
	}

	public Boolean getMostrarid_moduloGrupoOpcion() {
		return this.mostrarid_moduloGrupoOpcion;
	}

	public void setMostrarid_moduloGrupoOpcion(Boolean mostrarid_moduloGrupoOpcion) {
		this.mostrarid_moduloGrupoOpcion= mostrarid_moduloGrupoOpcion;
	}

	public Boolean getActivarid_moduloGrupoOpcion() {
		return this.activarid_moduloGrupoOpcion;
	}

	public void setActivarid_moduloGrupoOpcion(Boolean activarid_moduloGrupoOpcion) {
		this.activarid_moduloGrupoOpcion= activarid_moduloGrupoOpcion;
	}

	public Boolean getCargarid_moduloGrupoOpcion() {
		return this.cargarid_moduloGrupoOpcion;
	}

	public void setCargarid_moduloGrupoOpcion(Boolean cargarid_moduloGrupoOpcion) {
		this.cargarid_moduloGrupoOpcion= cargarid_moduloGrupoOpcion;
	}

	public Border setResaltarcodigoGrupoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoOpcionBeanSwingJInternalFrame grupoopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoopcionBeanSwingJInternalFrame.jTtoolBarGrupoOpcion.setBorder(borderResaltar);
		
		this.resaltarcodigoGrupoOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoGrupoOpcion() {
		return this.resaltarcodigoGrupoOpcion;
	}

	public void setResaltarcodigoGrupoOpcion(Border borderResaltar) {
		this.resaltarcodigoGrupoOpcion= borderResaltar;
	}

	public Boolean getMostrarcodigoGrupoOpcion() {
		return this.mostrarcodigoGrupoOpcion;
	}

	public void setMostrarcodigoGrupoOpcion(Boolean mostrarcodigoGrupoOpcion) {
		this.mostrarcodigoGrupoOpcion= mostrarcodigoGrupoOpcion;
	}

	public Boolean getActivarcodigoGrupoOpcion() {
		return this.activarcodigoGrupoOpcion;
	}

	public void setActivarcodigoGrupoOpcion(Boolean activarcodigoGrupoOpcion) {
		this.activarcodigoGrupoOpcion= activarcodigoGrupoOpcion;
	}

	public Border setResaltarnombre_principalGrupoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoOpcionBeanSwingJInternalFrame grupoopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoopcionBeanSwingJInternalFrame.jTtoolBarGrupoOpcion.setBorder(borderResaltar);
		
		this.resaltarnombre_principalGrupoOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_principalGrupoOpcion() {
		return this.resaltarnombre_principalGrupoOpcion;
	}

	public void setResaltarnombre_principalGrupoOpcion(Border borderResaltar) {
		this.resaltarnombre_principalGrupoOpcion= borderResaltar;
	}

	public Boolean getMostrarnombre_principalGrupoOpcion() {
		return this.mostrarnombre_principalGrupoOpcion;
	}

	public void setMostrarnombre_principalGrupoOpcion(Boolean mostrarnombre_principalGrupoOpcion) {
		this.mostrarnombre_principalGrupoOpcion= mostrarnombre_principalGrupoOpcion;
	}

	public Boolean getActivarnombre_principalGrupoOpcion() {
		return this.activarnombre_principalGrupoOpcion;
	}

	public void setActivarnombre_principalGrupoOpcion(Boolean activarnombre_principalGrupoOpcion) {
		this.activarnombre_principalGrupoOpcion= activarnombre_principalGrupoOpcion;
	}

	public Border setResaltarordenGrupoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoOpcionBeanSwingJInternalFrame grupoopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoopcionBeanSwingJInternalFrame.jTtoolBarGrupoOpcion.setBorder(borderResaltar);
		
		this.resaltarordenGrupoOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenGrupoOpcion() {
		return this.resaltarordenGrupoOpcion;
	}

	public void setResaltarordenGrupoOpcion(Border borderResaltar) {
		this.resaltarordenGrupoOpcion= borderResaltar;
	}

	public Boolean getMostrarordenGrupoOpcion() {
		return this.mostrarordenGrupoOpcion;
	}

	public void setMostrarordenGrupoOpcion(Boolean mostrarordenGrupoOpcion) {
		this.mostrarordenGrupoOpcion= mostrarordenGrupoOpcion;
	}

	public Boolean getActivarordenGrupoOpcion() {
		return this.activarordenGrupoOpcion;
	}

	public void setActivarordenGrupoOpcion(Boolean activarordenGrupoOpcion) {
		this.activarordenGrupoOpcion= activarordenGrupoOpcion;
	}

	public Border setResaltarestadoGrupoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoOpcionBeanSwingJInternalFrame grupoopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoopcionBeanSwingJInternalFrame.jTtoolBarGrupoOpcion.setBorder(borderResaltar);
		
		this.resaltarestadoGrupoOpcion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoGrupoOpcion() {
		return this.resaltarestadoGrupoOpcion;
	}

	public void setResaltarestadoGrupoOpcion(Border borderResaltar) {
		this.resaltarestadoGrupoOpcion= borderResaltar;
	}

	public Boolean getMostrarestadoGrupoOpcion() {
		return this.mostrarestadoGrupoOpcion;
	}

	public void setMostrarestadoGrupoOpcion(Boolean mostrarestadoGrupoOpcion) {
		this.mostrarestadoGrupoOpcion= mostrarestadoGrupoOpcion;
	}

	public Boolean getActivarestadoGrupoOpcion() {
		return this.activarestadoGrupoOpcion;
	}

	public void setActivarestadoGrupoOpcion(Boolean activarestadoGrupoOpcion) {
		this.activarestadoGrupoOpcion= activarestadoGrupoOpcion;
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
		
		
		this.setMostraridGrupoOpcion(esInicial);
		this.setMostrarid_moduloGrupoOpcion(esInicial);
		this.setMostrarcodigoGrupoOpcion(esInicial);
		this.setMostrarnombre_principalGrupoOpcion(esInicial);
		this.setMostrarordenGrupoOpcion(esInicial);
		this.setMostrarestadoGrupoOpcion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.ID)) {
				this.setMostraridGrupoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloGrupoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoGrupoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombre_principalGrupoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.ORDEN)) {
				this.setMostrarordenGrupoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.ESTADO)) {
				this.setMostrarestadoGrupoOpcion(esAsigna);
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
		
		
		this.setActivaridGrupoOpcion(esInicial);
		this.setActivarid_moduloGrupoOpcion(esInicial);
		this.setActivarcodigoGrupoOpcion(esInicial);
		this.setActivarnombre_principalGrupoOpcion(esInicial);
		this.setActivarordenGrupoOpcion(esInicial);
		this.setActivarestadoGrupoOpcion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.ID)) {
				this.setActivaridGrupoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloGrupoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoGrupoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.NOMBRE)) {
				this.setActivarnombre_principalGrupoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.ORDEN)) {
				this.setActivarordenGrupoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.ESTADO)) {
				this.setActivarestadoGrupoOpcion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,GrupoOpcionBeanSwingJInternalFrame grupoopcionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridGrupoOpcion(esInicial);
		this.setResaltarid_moduloGrupoOpcion(esInicial);
		this.setResaltarcodigoGrupoOpcion(esInicial);
		this.setResaltarnombre_principalGrupoOpcion(esInicial);
		this.setResaltarordenGrupoOpcion(esInicial);
		this.setResaltarestadoGrupoOpcion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.ID)) {
				this.setResaltaridGrupoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloGrupoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoGrupoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombre_principalGrupoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.ORDEN)) {
				this.setResaltarordenGrupoOpcion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoOpcionConstantesFunciones.ESTADO)) {
				this.setResaltarestadoGrupoOpcion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarUsuarioOpcionGrupoOpcion=null;

	public Border getResaltarUsuarioOpcionGrupoOpcion() {
		return this.resaltarUsuarioOpcionGrupoOpcion;
	}

	public void setResaltarUsuarioOpcionGrupoOpcion(Border borderResaltarUsuarioOpcion) {
		if(borderResaltarUsuarioOpcion!=null) {
			this.resaltarUsuarioOpcionGrupoOpcion= borderResaltarUsuarioOpcion;
		}
	}

	public Border setResaltarUsuarioOpcionGrupoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoOpcionBeanSwingJInternalFrame grupoopcionBeanSwingJInternalFrame*/) {
		Border borderResaltarUsuarioOpcion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//grupoopcionBeanSwingJInternalFrame.jTtoolBarGrupoOpcion.setBorder(borderResaltarUsuarioOpcion);
			
		this.resaltarUsuarioOpcionGrupoOpcion= borderResaltarUsuarioOpcion;

		 return borderResaltarUsuarioOpcion;
	}



	public Boolean mostrarUsuarioOpcionGrupoOpcion=true;

	public Boolean getMostrarUsuarioOpcionGrupoOpcion() {
		return this.mostrarUsuarioOpcionGrupoOpcion;
	}

	public void setMostrarUsuarioOpcionGrupoOpcion(Boolean visibilidadResaltarUsuarioOpcion) {
		this.mostrarUsuarioOpcionGrupoOpcion= visibilidadResaltarUsuarioOpcion;
	}



	public Boolean activarUsuarioOpcionGrupoOpcion=true;

	public Boolean gethabilitarResaltarUsuarioOpcionGrupoOpcion() {
		return this.activarUsuarioOpcionGrupoOpcion;
	}

	public void setActivarUsuarioOpcionGrupoOpcion(Boolean habilitarResaltarUsuarioOpcion) {
		this.activarUsuarioOpcionGrupoOpcion= habilitarResaltarUsuarioOpcion;
	}


	public Border resaltarOpcionGrupoOpcion=null;

	public Border getResaltarOpcionGrupoOpcion() {
		return this.resaltarOpcionGrupoOpcion;
	}

	public void setResaltarOpcionGrupoOpcion(Border borderResaltarOpcion) {
		if(borderResaltarOpcion!=null) {
			this.resaltarOpcionGrupoOpcion= borderResaltarOpcion;
		}
	}

	public Border setResaltarOpcionGrupoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoOpcionBeanSwingJInternalFrame grupoopcionBeanSwingJInternalFrame*/) {
		Border borderResaltarOpcion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//grupoopcionBeanSwingJInternalFrame.jTtoolBarGrupoOpcion.setBorder(borderResaltarOpcion);
			
		this.resaltarOpcionGrupoOpcion= borderResaltarOpcion;

		 return borderResaltarOpcion;
	}



	public Boolean mostrarOpcionGrupoOpcion=true;

	public Boolean getMostrarOpcionGrupoOpcion() {
		return this.mostrarOpcionGrupoOpcion;
	}

	public void setMostrarOpcionGrupoOpcion(Boolean visibilidadResaltarOpcion) {
		this.mostrarOpcionGrupoOpcion= visibilidadResaltarOpcion;
	}



	public Boolean activarOpcionGrupoOpcion=true;

	public Boolean gethabilitarResaltarOpcionGrupoOpcion() {
		return this.activarOpcionGrupoOpcion;
	}

	public void setActivarOpcionGrupoOpcion(Boolean habilitarResaltarOpcion) {
		this.activarOpcionGrupoOpcion= habilitarResaltarOpcion;
	}


	public Border resaltarPerfilOpcionGrupoOpcion=null;

	public Border getResaltarPerfilOpcionGrupoOpcion() {
		return this.resaltarPerfilOpcionGrupoOpcion;
	}

	public void setResaltarPerfilOpcionGrupoOpcion(Border borderResaltarPerfilOpcion) {
		if(borderResaltarPerfilOpcion!=null) {
			this.resaltarPerfilOpcionGrupoOpcion= borderResaltarPerfilOpcion;
		}
	}

	public Border setResaltarPerfilOpcionGrupoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoOpcionBeanSwingJInternalFrame grupoopcionBeanSwingJInternalFrame*/) {
		Border borderResaltarPerfilOpcion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//grupoopcionBeanSwingJInternalFrame.jTtoolBarGrupoOpcion.setBorder(borderResaltarPerfilOpcion);
			
		this.resaltarPerfilOpcionGrupoOpcion= borderResaltarPerfilOpcion;

		 return borderResaltarPerfilOpcion;
	}



	public Boolean mostrarPerfilOpcionGrupoOpcion=true;

	public Boolean getMostrarPerfilOpcionGrupoOpcion() {
		return this.mostrarPerfilOpcionGrupoOpcion;
	}

	public void setMostrarPerfilOpcionGrupoOpcion(Boolean visibilidadResaltarPerfilOpcion) {
		this.mostrarPerfilOpcionGrupoOpcion= visibilidadResaltarPerfilOpcion;
	}



	public Boolean activarPerfilOpcionGrupoOpcion=true;

	public Boolean gethabilitarResaltarPerfilOpcionGrupoOpcion() {
		return this.activarPerfilOpcionGrupoOpcion;
	}

	public void setActivarPerfilOpcionGrupoOpcion(Boolean habilitarResaltarPerfilOpcion) {
		this.activarPerfilOpcionGrupoOpcion= habilitarResaltarPerfilOpcion;
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

		this.setMostrarUsuarioOpcionGrupoOpcion(esInicial);
		this.setMostrarOpcionGrupoOpcion(esInicial);
		this.setMostrarPerfilOpcionGrupoOpcion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(UsuarioOpcion.class)) {
				this.setMostrarUsuarioOpcionGrupoOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Opcion.class)) {
				this.setMostrarOpcionGrupoOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(PerfilOpcion.class)) {
				this.setMostrarPerfilOpcionGrupoOpcion(esAsigna);
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

		this.setActivarUsuarioOpcionGrupoOpcion(esInicial);
		this.setActivarOpcionGrupoOpcion(esInicial);
		this.setActivarPerfilOpcionGrupoOpcion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(UsuarioOpcion.class)) {
				this.setActivarUsuarioOpcionGrupoOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Opcion.class)) {
				this.setActivarOpcionGrupoOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(PerfilOpcion.class)) {
				this.setActivarPerfilOpcionGrupoOpcion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,GrupoOpcionBeanSwingJInternalFrame grupoopcionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarUsuarioOpcionGrupoOpcion(esInicial);
		this.setResaltarOpcionGrupoOpcion(esInicial);
		this.setResaltarPerfilOpcionGrupoOpcion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(UsuarioOpcion.class)) {
				this.setResaltarUsuarioOpcionGrupoOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Opcion.class)) {
				this.setResaltarOpcionGrupoOpcion(esAsigna);
				continue;
			}

			if(clase.clas.equals(PerfilOpcion.class)) {
				this.setResaltarPerfilOpcionGrupoOpcion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaIdModuloPorNombreGrupoOpcion=true;

	public Boolean getMostrarBusquedaIdModuloPorNombreGrupoOpcion() {
		return this.mostrarBusquedaIdModuloPorNombreGrupoOpcion;
	}

	public void setMostrarBusquedaIdModuloPorNombreGrupoOpcion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaIdModuloPorNombreGrupoOpcion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloGrupoOpcion=true;

	public Boolean getMostrarFK_IdModuloGrupoOpcion() {
		return this.mostrarFK_IdModuloGrupoOpcion;
	}

	public void setMostrarFK_IdModuloGrupoOpcion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloGrupoOpcion= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaIdModuloPorNombreGrupoOpcion=true;

	public Boolean getActivarBusquedaIdModuloPorNombreGrupoOpcion() {
		return this.activarBusquedaIdModuloPorNombreGrupoOpcion;
	}

	public void setActivarBusquedaIdModuloPorNombreGrupoOpcion(Boolean habilitarResaltar) {
		this.activarBusquedaIdModuloPorNombreGrupoOpcion= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloGrupoOpcion=true;

	public Boolean getActivarFK_IdModuloGrupoOpcion() {
		return this.activarFK_IdModuloGrupoOpcion;
	}

	public void setActivarFK_IdModuloGrupoOpcion(Boolean habilitarResaltar) {
		this.activarFK_IdModuloGrupoOpcion= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaIdModuloPorNombreGrupoOpcion=null;

	public Border getResaltarBusquedaIdModuloPorNombreGrupoOpcion() {
		return this.resaltarBusquedaIdModuloPorNombreGrupoOpcion;
	}

	public void setResaltarBusquedaIdModuloPorNombreGrupoOpcion(Border borderResaltar) {
		this.resaltarBusquedaIdModuloPorNombreGrupoOpcion= borderResaltar;
	}

	public void setResaltarBusquedaIdModuloPorNombreGrupoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoOpcionBeanSwingJInternalFrame grupoopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaIdModuloPorNombreGrupoOpcion= borderResaltar;
	}

	public Border resaltarFK_IdModuloGrupoOpcion=null;

	public Border getResaltarFK_IdModuloGrupoOpcion() {
		return this.resaltarFK_IdModuloGrupoOpcion;
	}

	public void setResaltarFK_IdModuloGrupoOpcion(Border borderResaltar) {
		this.resaltarFK_IdModuloGrupoOpcion= borderResaltar;
	}

	public void setResaltarFK_IdModuloGrupoOpcion(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoOpcionBeanSwingJInternalFrame grupoopcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloGrupoOpcion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}