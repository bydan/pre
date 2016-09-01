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


import com.bydan.erp.seguridad.util.PlanetaSistemaSolarConstantesFunciones;
import com.bydan.erp.seguridad.util.PlanetaSistemaSolarParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.PlanetaSistemaSolarParameterGeneral;

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
final public class PlanetaSistemaSolarConstantesFunciones extends PlanetaSistemaSolarConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PlanetaSistemaSolar";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PlanetaSistemaSolar"+PlanetaSistemaSolarConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PlanetaSistemaSolarHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PlanetaSistemaSolarHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PlanetaSistemaSolarConstantesFunciones.SCHEMA+"_"+PlanetaSistemaSolarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PlanetaSistemaSolarHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PlanetaSistemaSolarConstantesFunciones.SCHEMA+"_"+PlanetaSistemaSolarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PlanetaSistemaSolarConstantesFunciones.SCHEMA+"_"+PlanetaSistemaSolarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PlanetaSistemaSolarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PlanetaSistemaSolarConstantesFunciones.SCHEMA+"_"+PlanetaSistemaSolarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlanetaSistemaSolarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PlanetaSistemaSolarHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlanetaSistemaSolarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlanetaSistemaSolarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PlanetaSistemaSolarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlanetaSistemaSolarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PlanetaSistemaSolarConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PlanetaSistemaSolarConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PlanetaSistemaSolarConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PlanetaSistemaSolarConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Planeta Sistema Solares";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Planeta Sistema Solar";
	public static final String SCLASSWEBTITULO_LOWER="Planeta Sistema Solar";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PlanetaSistemaSolar";
	public static final String OBJECTNAME="planetasistemasolar";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="planeta_sistema_solar";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select planetasistemasolar from "+PlanetaSistemaSolarConstantesFunciones.SPERSISTENCENAME+" planetasistemasolar";
	public static String QUERYSELECTNATIVE="select "+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+".id,"+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+".version_row,"+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+".id_tipo_valoracion,"+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+".codigo,"+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+".nombre,"+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+".descripcion from "+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME;//+" as "+PlanetaSistemaSolarConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PlanetaSistemaSolarConstantesFuncionesAdditional planetasistemasolarConstantesFuncionesAdditional=null;
	
	public PlanetaSistemaSolarConstantesFuncionesAdditional getPlanetaSistemaSolarConstantesFuncionesAdditional() {
		return this.planetasistemasolarConstantesFuncionesAdditional;
	}
	
	public void setPlanetaSistemaSolarConstantesFuncionesAdditional(PlanetaSistemaSolarConstantesFuncionesAdditional planetasistemasolarConstantesFuncionesAdditional) {
		try {
			this.planetasistemasolarConstantesFuncionesAdditional=planetasistemasolarConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDTIPOVALORACION= "id_tipo_valoracion";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDTIPOVALORACION= "Tipo Valoracion";
		public static final String LABEL_IDTIPOVALORACION_LOWER= "Tipo Valoracion";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPlanetaSistemaSolarLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PlanetaSistemaSolarConstantesFunciones.IDTIPOVALORACION)) {sLabelColumna=PlanetaSistemaSolarConstantesFunciones.LABEL_IDTIPOVALORACION;}
		if(sNombreColumna.equals(PlanetaSistemaSolarConstantesFunciones.CODIGO)) {sLabelColumna=PlanetaSistemaSolarConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(PlanetaSistemaSolarConstantesFunciones.NOMBRE)) {sLabelColumna=PlanetaSistemaSolarConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(PlanetaSistemaSolarConstantesFunciones.DESCRIPCION)) {sLabelColumna=PlanetaSistemaSolarConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getPlanetaSistemaSolarDescripcion(PlanetaSistemaSolar planetasistemasolar) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(planetasistemasolar !=null/* && planetasistemasolar.getId()!=0*/) {
			sDescripcion=planetasistemasolar.getcodigo();//planetasistemasolarplanetasistemasolar.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPlanetaSistemaSolarDescripcionDetallado(PlanetaSistemaSolar planetasistemasolar) {
		String sDescripcion="";
			
		sDescripcion+=PlanetaSistemaSolarConstantesFunciones.ID+"=";
		sDescripcion+=planetasistemasolar.getId().toString()+",";
		sDescripcion+=PlanetaSistemaSolarConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=planetasistemasolar.getVersionRow().toString()+",";
		sDescripcion+=PlanetaSistemaSolarConstantesFunciones.IDTIPOVALORACION+"=";
		sDescripcion+=planetasistemasolar.getid_tipo_valoracion().toString()+",";
		sDescripcion+=PlanetaSistemaSolarConstantesFunciones.CODIGO+"=";
		sDescripcion+=planetasistemasolar.getcodigo()+",";
		sDescripcion+=PlanetaSistemaSolarConstantesFunciones.NOMBRE+"=";
		sDescripcion+=planetasistemasolar.getnombre()+",";
		sDescripcion+=PlanetaSistemaSolarConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=planetasistemasolar.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setPlanetaSistemaSolarDescripcion(PlanetaSistemaSolar planetasistemasolar,String sValor) throws Exception {			
		if(planetasistemasolar !=null) {
			planetasistemasolar.setcodigo(sValor);;//planetasistemasolarplanetasistemasolar.getcodigo().trim();
		}		
	}
	
		

	public static String getTipoValoracionDescripcion(TipoValoracion tipovaloracion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipovaloracion!=null/*&&tipovaloracion.getId()>0*/) {
			sDescripcion=TipoValoracionConstantesFunciones.getTipoValoracionDescripcion(tipovaloracion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("FK_IdTipoValoracion")) {
			sNombreIndice="Tipo=  Por Tipo Valoracion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoValoracion(Long id_tipo_valoracion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_valoracion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Valoracion="+id_tipo_valoracion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPlanetaSistemaSolar(PlanetaSistemaSolar planetasistemasolar,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		planetasistemasolar.setcodigo(planetasistemasolar.getcodigo().trim());
		planetasistemasolar.setnombre(planetasistemasolar.getnombre().trim());
		planetasistemasolar.setdescripcion(planetasistemasolar.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPlanetaSistemaSolars(List<PlanetaSistemaSolar> planetasistemasolars,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PlanetaSistemaSolar planetasistemasolar: planetasistemasolars) {
			planetasistemasolar.setcodigo(planetasistemasolar.getcodigo().trim());
			planetasistemasolar.setnombre(planetasistemasolar.getnombre().trim());
			planetasistemasolar.setdescripcion(planetasistemasolar.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPlanetaSistemaSolar(PlanetaSistemaSolar planetasistemasolar,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && planetasistemasolar.getConCambioAuxiliar()) {
			planetasistemasolar.setIsDeleted(planetasistemasolar.getIsDeletedAuxiliar());	
			planetasistemasolar.setIsNew(planetasistemasolar.getIsNewAuxiliar());	
			planetasistemasolar.setIsChanged(planetasistemasolar.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			planetasistemasolar.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			planetasistemasolar.setIsDeletedAuxiliar(false);	
			planetasistemasolar.setIsNewAuxiliar(false);	
			planetasistemasolar.setIsChangedAuxiliar(false);
			
			planetasistemasolar.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPlanetaSistemaSolars(List<PlanetaSistemaSolar> planetasistemasolars,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PlanetaSistemaSolar planetasistemasolar : planetasistemasolars) {
			if(conAsignarBase && planetasistemasolar.getConCambioAuxiliar()) {
				planetasistemasolar.setIsDeleted(planetasistemasolar.getIsDeletedAuxiliar());	
				planetasistemasolar.setIsNew(planetasistemasolar.getIsNewAuxiliar());	
				planetasistemasolar.setIsChanged(planetasistemasolar.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				planetasistemasolar.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				planetasistemasolar.setIsDeletedAuxiliar(false);	
				planetasistemasolar.setIsNewAuxiliar(false);	
				planetasistemasolar.setIsChangedAuxiliar(false);
				
				planetasistemasolar.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPlanetaSistemaSolar(PlanetaSistemaSolar planetasistemasolar,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPlanetaSistemaSolars(List<PlanetaSistemaSolar> planetasistemasolars,Boolean conEnteros) throws Exception  {
		
		for(PlanetaSistemaSolar planetasistemasolar: planetasistemasolars) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPlanetaSistemaSolar(List<PlanetaSistemaSolar> planetasistemasolars,PlanetaSistemaSolar planetasistemasolarAux) throws Exception  {
		PlanetaSistemaSolarConstantesFunciones.InicializarValoresPlanetaSistemaSolar(planetasistemasolarAux,true);
		
		for(PlanetaSistemaSolar planetasistemasolar: planetasistemasolars) {
			if(planetasistemasolar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPlanetaSistemaSolar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PlanetaSistemaSolarConstantesFunciones.getArrayColumnasGlobalesPlanetaSistemaSolar(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPlanetaSistemaSolar(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPlanetaSistemaSolar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PlanetaSistemaSolar> planetasistemasolars,PlanetaSistemaSolar planetasistemasolar,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PlanetaSistemaSolar planetasistemasolarAux: planetasistemasolars) {
			if(planetasistemasolarAux!=null && planetasistemasolar!=null) {
				if((planetasistemasolarAux.getId()==null && planetasistemasolar.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(planetasistemasolarAux.getId()!=null && planetasistemasolar.getId()!=null){
					if(planetasistemasolarAux.getId().equals(planetasistemasolar.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPlanetaSistemaSolar(List<PlanetaSistemaSolar> planetasistemasolars) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PlanetaSistemaSolar planetasistemasolar: planetasistemasolars) {			
			if(planetasistemasolar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPlanetaSistemaSolar() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PlanetaSistemaSolarConstantesFunciones.LABEL_ID, PlanetaSistemaSolarConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlanetaSistemaSolarConstantesFunciones.LABEL_VERSIONROW, PlanetaSistemaSolarConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlanetaSistemaSolarConstantesFunciones.LABEL_IDTIPOVALORACION, PlanetaSistemaSolarConstantesFunciones.IDTIPOVALORACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlanetaSistemaSolarConstantesFunciones.LABEL_CODIGO, PlanetaSistemaSolarConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlanetaSistemaSolarConstantesFunciones.LABEL_NOMBRE, PlanetaSistemaSolarConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlanetaSistemaSolarConstantesFunciones.LABEL_DESCRIPCION, PlanetaSistemaSolarConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPlanetaSistemaSolar() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PlanetaSistemaSolarConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlanetaSistemaSolarConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlanetaSistemaSolarConstantesFunciones.IDTIPOVALORACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlanetaSistemaSolarConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlanetaSistemaSolarConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlanetaSistemaSolarConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPlanetaSistemaSolar() throws Exception  {
		return PlanetaSistemaSolarConstantesFunciones.getTiposSeleccionarPlanetaSistemaSolar(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPlanetaSistemaSolar(Boolean conFk) throws Exception  {
		return PlanetaSistemaSolarConstantesFunciones.getTiposSeleccionarPlanetaSistemaSolar(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPlanetaSistemaSolar(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlanetaSistemaSolarConstantesFunciones.LABEL_IDTIPOVALORACION);
			reporte.setsDescripcion(PlanetaSistemaSolarConstantesFunciones.LABEL_IDTIPOVALORACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlanetaSistemaSolarConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PlanetaSistemaSolarConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlanetaSistemaSolarConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PlanetaSistemaSolarConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlanetaSistemaSolarConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PlanetaSistemaSolarConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPlanetaSistemaSolar(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPlanetaSistemaSolar(PlanetaSistemaSolar planetasistemasolarAux) throws Exception {
		
			planetasistemasolarAux.settipovaloracion_descripcion(TipoValoracionConstantesFunciones.getTipoValoracionDescripcion(planetasistemasolarAux.getTipoValoracion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPlanetaSistemaSolar(List<PlanetaSistemaSolar> planetasistemasolarsTemp) throws Exception {
		for(PlanetaSistemaSolar planetasistemasolarAux:planetasistemasolarsTemp) {
			
			planetasistemasolarAux.settipovaloracion_descripcion(TipoValoracionConstantesFunciones.getTipoValoracionDescripcion(planetasistemasolarAux.getTipoValoracion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPlanetaSistemaSolar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TipoValoracion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoValoracion.class)) {
						classes.add(new Classe(TipoValoracion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPlanetaSistemaSolar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoValoracion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoValoracion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoValoracion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoValoracion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPlanetaSistemaSolar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PlanetaSistemaSolarConstantesFunciones.getClassesRelationshipsOfPlanetaSistemaSolar(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPlanetaSistemaSolar(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPlanetaSistemaSolar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PlanetaSistemaSolarConstantesFunciones.getClassesRelationshipsFromStringsOfPlanetaSistemaSolar(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPlanetaSistemaSolar(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PlanetaSistemaSolar planetasistemasolar,List<PlanetaSistemaSolar> planetasistemasolars,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PlanetaSistemaSolar planetasistemasolarEncontrado=null;
			
			for(PlanetaSistemaSolar planetasistemasolarLocal:planetasistemasolars) {
				if(planetasistemasolarLocal.getId().equals(planetasistemasolar.getId())) {
					planetasistemasolarEncontrado=planetasistemasolarLocal;
					
					planetasistemasolarLocal.setIsChanged(planetasistemasolar.getIsChanged());
					planetasistemasolarLocal.setIsNew(planetasistemasolar.getIsNew());
					planetasistemasolarLocal.setIsDeleted(planetasistemasolar.getIsDeleted());
					
					planetasistemasolarLocal.setGeneralEntityOriginal(planetasistemasolar.getGeneralEntityOriginal());
					
					planetasistemasolarLocal.setId(planetasistemasolar.getId());	
					planetasistemasolarLocal.setVersionRow(planetasistemasolar.getVersionRow());	
					planetasistemasolarLocal.setid_tipo_valoracion(planetasistemasolar.getid_tipo_valoracion());	
					planetasistemasolarLocal.setcodigo(planetasistemasolar.getcodigo());	
					planetasistemasolarLocal.setnombre(planetasistemasolar.getnombre());	
					planetasistemasolarLocal.setdescripcion(planetasistemasolar.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!planetasistemasolar.getIsDeleted()) {
				if(!existe) {
					planetasistemasolars.add(planetasistemasolar);
				}
			} else {
				if(planetasistemasolarEncontrado!=null && permiteQuitar)  {
					planetasistemasolars.remove(planetasistemasolarEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PlanetaSistemaSolar planetasistemasolar,List<PlanetaSistemaSolar> planetasistemasolars) throws Exception {
		try	{			
			for(PlanetaSistemaSolar planetasistemasolarLocal:planetasistemasolars) {
				if(planetasistemasolarLocal.getId().equals(planetasistemasolar.getId())) {
					planetasistemasolarLocal.setIsSelected(planetasistemasolar.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPlanetaSistemaSolar(List<PlanetaSistemaSolar> planetasistemasolarsAux) throws Exception {
		//this.planetasistemasolarsAux=planetasistemasolarsAux;
		
		for(PlanetaSistemaSolar planetasistemasolarAux:planetasistemasolarsAux) {
			if(planetasistemasolarAux.getIsChanged()) {
				planetasistemasolarAux.setIsChanged(false);
			}		
			
			if(planetasistemasolarAux.getIsNew()) {
				planetasistemasolarAux.setIsNew(false);
			}	
			
			if(planetasistemasolarAux.getIsDeleted()) {
				planetasistemasolarAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPlanetaSistemaSolar(PlanetaSistemaSolar planetasistemasolarAux) throws Exception {
		//this.planetasistemasolarAux=planetasistemasolarAux;
		
			if(planetasistemasolarAux.getIsChanged()) {
				planetasistemasolarAux.setIsChanged(false);
			}		
			
			if(planetasistemasolarAux.getIsNew()) {
				planetasistemasolarAux.setIsNew(false);
			}	
			
			if(planetasistemasolarAux.getIsDeleted()) {
				planetasistemasolarAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PlanetaSistemaSolar planetasistemasolarAsignar,PlanetaSistemaSolar planetasistemasolar) throws Exception {
		planetasistemasolarAsignar.setId(planetasistemasolar.getId());	
		planetasistemasolarAsignar.setVersionRow(planetasistemasolar.getVersionRow());	
		planetasistemasolarAsignar.setid_tipo_valoracion(planetasistemasolar.getid_tipo_valoracion());
		planetasistemasolarAsignar.settipovaloracion_descripcion(planetasistemasolar.gettipovaloracion_descripcion());	
		planetasistemasolarAsignar.setcodigo(planetasistemasolar.getcodigo());	
		planetasistemasolarAsignar.setnombre(planetasistemasolar.getnombre());	
		planetasistemasolarAsignar.setdescripcion(planetasistemasolar.getdescripcion());	
	}
	
	public static void inicializarPlanetaSistemaSolar(PlanetaSistemaSolar planetasistemasolar) throws Exception {
		try {
				planetasistemasolar.setId(0L);	
					
				planetasistemasolar.setid_tipo_valoracion(-1L);	
				planetasistemasolar.setcodigo("");	
				planetasistemasolar.setnombre("");	
				planetasistemasolar.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPlanetaSistemaSolar(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PlanetaSistemaSolarConstantesFunciones.LABEL_IDTIPOVALORACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlanetaSistemaSolarConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlanetaSistemaSolarConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlanetaSistemaSolarConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPlanetaSistemaSolar(String sTipo,Row row,Workbook workbook,PlanetaSistemaSolar planetasistemasolar,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(planetasistemasolar.gettipovaloracion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planetasistemasolar.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planetasistemasolar.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planetasistemasolar.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPlanetaSistemaSolar=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPlanetaSistemaSolar() {
		return this.sFinalQueryPlanetaSistemaSolar;
	}
	
	public void setsFinalQueryPlanetaSistemaSolar(String sFinalQueryPlanetaSistemaSolar) {
		this.sFinalQueryPlanetaSistemaSolar= sFinalQueryPlanetaSistemaSolar;
	}
	
	public Border resaltarSeleccionarPlanetaSistemaSolar=null;
	
	public Border setResaltarSeleccionarPlanetaSistemaSolar(ParametroGeneralUsuario parametroGeneralUsuario/*PlanetaSistemaSolarBeanSwingJInternalFrame planetasistemasolarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//planetasistemasolarBeanSwingJInternalFrame.jTtoolBarPlanetaSistemaSolar.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPlanetaSistemaSolar= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPlanetaSistemaSolar() {
		return this.resaltarSeleccionarPlanetaSistemaSolar;
	}
	
	public void setResaltarSeleccionarPlanetaSistemaSolar(Border borderResaltarSeleccionarPlanetaSistemaSolar) {
		this.resaltarSeleccionarPlanetaSistemaSolar= borderResaltarSeleccionarPlanetaSistemaSolar;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPlanetaSistemaSolar=null;
	public Boolean mostraridPlanetaSistemaSolar=true;
	public Boolean activaridPlanetaSistemaSolar=true;

	public Border resaltarid_tipo_valoracionPlanetaSistemaSolar=null;
	public Boolean mostrarid_tipo_valoracionPlanetaSistemaSolar=true;
	public Boolean activarid_tipo_valoracionPlanetaSistemaSolar=true;
	public Boolean cargarid_tipo_valoracionPlanetaSistemaSolar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_valoracionPlanetaSistemaSolar=false;//ConEventDepend=true

	public Border resaltarcodigoPlanetaSistemaSolar=null;
	public Boolean mostrarcodigoPlanetaSistemaSolar=true;
	public Boolean activarcodigoPlanetaSistemaSolar=true;

	public Border resaltarnombrePlanetaSistemaSolar=null;
	public Boolean mostrarnombrePlanetaSistemaSolar=true;
	public Boolean activarnombrePlanetaSistemaSolar=true;

	public Border resaltardescripcionPlanetaSistemaSolar=null;
	public Boolean mostrardescripcionPlanetaSistemaSolar=true;
	public Boolean activardescripcionPlanetaSistemaSolar=true;

	
	

	public Border setResaltaridPlanetaSistemaSolar(ParametroGeneralUsuario parametroGeneralUsuario/*PlanetaSistemaSolarBeanSwingJInternalFrame planetasistemasolarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planetasistemasolarBeanSwingJInternalFrame.jTtoolBarPlanetaSistemaSolar.setBorder(borderResaltar);
		
		this.resaltaridPlanetaSistemaSolar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPlanetaSistemaSolar() {
		return this.resaltaridPlanetaSistemaSolar;
	}

	public void setResaltaridPlanetaSistemaSolar(Border borderResaltar) {
		this.resaltaridPlanetaSistemaSolar= borderResaltar;
	}

	public Boolean getMostraridPlanetaSistemaSolar() {
		return this.mostraridPlanetaSistemaSolar;
	}

	public void setMostraridPlanetaSistemaSolar(Boolean mostraridPlanetaSistemaSolar) {
		this.mostraridPlanetaSistemaSolar= mostraridPlanetaSistemaSolar;
	}

	public Boolean getActivaridPlanetaSistemaSolar() {
		return this.activaridPlanetaSistemaSolar;
	}

	public void setActivaridPlanetaSistemaSolar(Boolean activaridPlanetaSistemaSolar) {
		this.activaridPlanetaSistemaSolar= activaridPlanetaSistemaSolar;
	}

	public Border setResaltarid_tipo_valoracionPlanetaSistemaSolar(ParametroGeneralUsuario parametroGeneralUsuario/*PlanetaSistemaSolarBeanSwingJInternalFrame planetasistemasolarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planetasistemasolarBeanSwingJInternalFrame.jTtoolBarPlanetaSistemaSolar.setBorder(borderResaltar);
		
		this.resaltarid_tipo_valoracionPlanetaSistemaSolar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_valoracionPlanetaSistemaSolar() {
		return this.resaltarid_tipo_valoracionPlanetaSistemaSolar;
	}

	public void setResaltarid_tipo_valoracionPlanetaSistemaSolar(Border borderResaltar) {
		this.resaltarid_tipo_valoracionPlanetaSistemaSolar= borderResaltar;
	}

	public Boolean getMostrarid_tipo_valoracionPlanetaSistemaSolar() {
		return this.mostrarid_tipo_valoracionPlanetaSistemaSolar;
	}

	public void setMostrarid_tipo_valoracionPlanetaSistemaSolar(Boolean mostrarid_tipo_valoracionPlanetaSistemaSolar) {
		this.mostrarid_tipo_valoracionPlanetaSistemaSolar= mostrarid_tipo_valoracionPlanetaSistemaSolar;
	}

	public Boolean getActivarid_tipo_valoracionPlanetaSistemaSolar() {
		return this.activarid_tipo_valoracionPlanetaSistemaSolar;
	}

	public void setActivarid_tipo_valoracionPlanetaSistemaSolar(Boolean activarid_tipo_valoracionPlanetaSistemaSolar) {
		this.activarid_tipo_valoracionPlanetaSistemaSolar= activarid_tipo_valoracionPlanetaSistemaSolar;
	}

	public Boolean getCargarid_tipo_valoracionPlanetaSistemaSolar() {
		return this.cargarid_tipo_valoracionPlanetaSistemaSolar;
	}

	public void setCargarid_tipo_valoracionPlanetaSistemaSolar(Boolean cargarid_tipo_valoracionPlanetaSistemaSolar) {
		this.cargarid_tipo_valoracionPlanetaSistemaSolar= cargarid_tipo_valoracionPlanetaSistemaSolar;
	}

	public Border setResaltarcodigoPlanetaSistemaSolar(ParametroGeneralUsuario parametroGeneralUsuario/*PlanetaSistemaSolarBeanSwingJInternalFrame planetasistemasolarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planetasistemasolarBeanSwingJInternalFrame.jTtoolBarPlanetaSistemaSolar.setBorder(borderResaltar);
		
		this.resaltarcodigoPlanetaSistemaSolar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPlanetaSistemaSolar() {
		return this.resaltarcodigoPlanetaSistemaSolar;
	}

	public void setResaltarcodigoPlanetaSistemaSolar(Border borderResaltar) {
		this.resaltarcodigoPlanetaSistemaSolar= borderResaltar;
	}

	public Boolean getMostrarcodigoPlanetaSistemaSolar() {
		return this.mostrarcodigoPlanetaSistemaSolar;
	}

	public void setMostrarcodigoPlanetaSistemaSolar(Boolean mostrarcodigoPlanetaSistemaSolar) {
		this.mostrarcodigoPlanetaSistemaSolar= mostrarcodigoPlanetaSistemaSolar;
	}

	public Boolean getActivarcodigoPlanetaSistemaSolar() {
		return this.activarcodigoPlanetaSistemaSolar;
	}

	public void setActivarcodigoPlanetaSistemaSolar(Boolean activarcodigoPlanetaSistemaSolar) {
		this.activarcodigoPlanetaSistemaSolar= activarcodigoPlanetaSistemaSolar;
	}

	public Border setResaltarnombrePlanetaSistemaSolar(ParametroGeneralUsuario parametroGeneralUsuario/*PlanetaSistemaSolarBeanSwingJInternalFrame planetasistemasolarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planetasistemasolarBeanSwingJInternalFrame.jTtoolBarPlanetaSistemaSolar.setBorder(borderResaltar);
		
		this.resaltarnombrePlanetaSistemaSolar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePlanetaSistemaSolar() {
		return this.resaltarnombrePlanetaSistemaSolar;
	}

	public void setResaltarnombrePlanetaSistemaSolar(Border borderResaltar) {
		this.resaltarnombrePlanetaSistemaSolar= borderResaltar;
	}

	public Boolean getMostrarnombrePlanetaSistemaSolar() {
		return this.mostrarnombrePlanetaSistemaSolar;
	}

	public void setMostrarnombrePlanetaSistemaSolar(Boolean mostrarnombrePlanetaSistemaSolar) {
		this.mostrarnombrePlanetaSistemaSolar= mostrarnombrePlanetaSistemaSolar;
	}

	public Boolean getActivarnombrePlanetaSistemaSolar() {
		return this.activarnombrePlanetaSistemaSolar;
	}

	public void setActivarnombrePlanetaSistemaSolar(Boolean activarnombrePlanetaSistemaSolar) {
		this.activarnombrePlanetaSistemaSolar= activarnombrePlanetaSistemaSolar;
	}

	public Border setResaltardescripcionPlanetaSistemaSolar(ParametroGeneralUsuario parametroGeneralUsuario/*PlanetaSistemaSolarBeanSwingJInternalFrame planetasistemasolarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planetasistemasolarBeanSwingJInternalFrame.jTtoolBarPlanetaSistemaSolar.setBorder(borderResaltar);
		
		this.resaltardescripcionPlanetaSistemaSolar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPlanetaSistemaSolar() {
		return this.resaltardescripcionPlanetaSistemaSolar;
	}

	public void setResaltardescripcionPlanetaSistemaSolar(Border borderResaltar) {
		this.resaltardescripcionPlanetaSistemaSolar= borderResaltar;
	}

	public Boolean getMostrardescripcionPlanetaSistemaSolar() {
		return this.mostrardescripcionPlanetaSistemaSolar;
	}

	public void setMostrardescripcionPlanetaSistemaSolar(Boolean mostrardescripcionPlanetaSistemaSolar) {
		this.mostrardescripcionPlanetaSistemaSolar= mostrardescripcionPlanetaSistemaSolar;
	}

	public Boolean getActivardescripcionPlanetaSistemaSolar() {
		return this.activardescripcionPlanetaSistemaSolar;
	}

	public void setActivardescripcionPlanetaSistemaSolar(Boolean activardescripcionPlanetaSistemaSolar) {
		this.activardescripcionPlanetaSistemaSolar= activardescripcionPlanetaSistemaSolar;
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
		
		
		this.setMostraridPlanetaSistemaSolar(esInicial);
		this.setMostrarid_tipo_valoracionPlanetaSistemaSolar(esInicial);
		this.setMostrarcodigoPlanetaSistemaSolar(esInicial);
		this.setMostrarnombrePlanetaSistemaSolar(esInicial);
		this.setMostrardescripcionPlanetaSistemaSolar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PlanetaSistemaSolarConstantesFunciones.ID)) {
				this.setMostraridPlanetaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlanetaSistemaSolarConstantesFunciones.IDTIPOVALORACION)) {
				this.setMostrarid_tipo_valoracionPlanetaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlanetaSistemaSolarConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPlanetaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlanetaSistemaSolarConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePlanetaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlanetaSistemaSolarConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPlanetaSistemaSolar(esAsigna);
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
		
		
		this.setActivaridPlanetaSistemaSolar(esInicial);
		this.setActivarid_tipo_valoracionPlanetaSistemaSolar(esInicial);
		this.setActivarcodigoPlanetaSistemaSolar(esInicial);
		this.setActivarnombrePlanetaSistemaSolar(esInicial);
		this.setActivardescripcionPlanetaSistemaSolar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PlanetaSistemaSolarConstantesFunciones.ID)) {
				this.setActivaridPlanetaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlanetaSistemaSolarConstantesFunciones.IDTIPOVALORACION)) {
				this.setActivarid_tipo_valoracionPlanetaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlanetaSistemaSolarConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPlanetaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlanetaSistemaSolarConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePlanetaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlanetaSistemaSolarConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPlanetaSistemaSolar(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PlanetaSistemaSolarBeanSwingJInternalFrame planetasistemasolarBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPlanetaSistemaSolar(esInicial);
		this.setResaltarid_tipo_valoracionPlanetaSistemaSolar(esInicial);
		this.setResaltarcodigoPlanetaSistemaSolar(esInicial);
		this.setResaltarnombrePlanetaSistemaSolar(esInicial);
		this.setResaltardescripcionPlanetaSistemaSolar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PlanetaSistemaSolarConstantesFunciones.ID)) {
				this.setResaltaridPlanetaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlanetaSistemaSolarConstantesFunciones.IDTIPOVALORACION)) {
				this.setResaltarid_tipo_valoracionPlanetaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlanetaSistemaSolarConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPlanetaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlanetaSistemaSolarConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePlanetaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlanetaSistemaSolarConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPlanetaSistemaSolar(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PlanetaSistemaSolarBeanSwingJInternalFrame planetasistemasolarBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoPlanetaSistemaSolar=true;

	public Boolean getMostrarBusquedaPorCodigoPlanetaSistemaSolar() {
		return this.mostrarBusquedaPorCodigoPlanetaSistemaSolar;
	}

	public void setMostrarBusquedaPorCodigoPlanetaSistemaSolar(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoPlanetaSistemaSolar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoValoracionPlanetaSistemaSolar=true;

	public Boolean getMostrarFK_IdTipoValoracionPlanetaSistemaSolar() {
		return this.mostrarFK_IdTipoValoracionPlanetaSistemaSolar;
	}

	public void setMostrarFK_IdTipoValoracionPlanetaSistemaSolar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoValoracionPlanetaSistemaSolar= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoPlanetaSistemaSolar=true;

	public Boolean getActivarBusquedaPorCodigoPlanetaSistemaSolar() {
		return this.activarBusquedaPorCodigoPlanetaSistemaSolar;
	}

	public void setActivarBusquedaPorCodigoPlanetaSistemaSolar(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoPlanetaSistemaSolar= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoValoracionPlanetaSistemaSolar=true;

	public Boolean getActivarFK_IdTipoValoracionPlanetaSistemaSolar() {
		return this.activarFK_IdTipoValoracionPlanetaSistemaSolar;
	}

	public void setActivarFK_IdTipoValoracionPlanetaSistemaSolar(Boolean habilitarResaltar) {
		this.activarFK_IdTipoValoracionPlanetaSistemaSolar= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoPlanetaSistemaSolar=null;

	public Border getResaltarBusquedaPorCodigoPlanetaSistemaSolar() {
		return this.resaltarBusquedaPorCodigoPlanetaSistemaSolar;
	}

	public void setResaltarBusquedaPorCodigoPlanetaSistemaSolar(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoPlanetaSistemaSolar= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoPlanetaSistemaSolar(ParametroGeneralUsuario parametroGeneralUsuario/*PlanetaSistemaSolarBeanSwingJInternalFrame planetasistemasolarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoPlanetaSistemaSolar= borderResaltar;
	}

	public Border resaltarFK_IdTipoValoracionPlanetaSistemaSolar=null;

	public Border getResaltarFK_IdTipoValoracionPlanetaSistemaSolar() {
		return this.resaltarFK_IdTipoValoracionPlanetaSistemaSolar;
	}

	public void setResaltarFK_IdTipoValoracionPlanetaSistemaSolar(Border borderResaltar) {
		this.resaltarFK_IdTipoValoracionPlanetaSistemaSolar= borderResaltar;
	}

	public void setResaltarFK_IdTipoValoracionPlanetaSistemaSolar(ParametroGeneralUsuario parametroGeneralUsuario/*PlanetaSistemaSolarBeanSwingJInternalFrame planetasistemasolarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoValoracionPlanetaSistemaSolar= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}