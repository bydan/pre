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


import com.bydan.erp.seguridad.util.LunaSistemaSolarConstantesFunciones;
import com.bydan.erp.seguridad.util.LunaSistemaSolarParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.LunaSistemaSolarParameterGeneral;

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
final public class LunaSistemaSolarConstantesFunciones extends LunaSistemaSolarConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="LunaSistemaSolar";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="LunaSistemaSolar"+LunaSistemaSolarConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="LunaSistemaSolarHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="LunaSistemaSolarHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=LunaSistemaSolarConstantesFunciones.SCHEMA+"_"+LunaSistemaSolarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/LunaSistemaSolarHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=LunaSistemaSolarConstantesFunciones.SCHEMA+"_"+LunaSistemaSolarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=LunaSistemaSolarConstantesFunciones.SCHEMA+"_"+LunaSistemaSolarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/LunaSistemaSolarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=LunaSistemaSolarConstantesFunciones.SCHEMA+"_"+LunaSistemaSolarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LunaSistemaSolarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LunaSistemaSolarHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LunaSistemaSolarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LunaSistemaSolarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LunaSistemaSolarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LunaSistemaSolarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=LunaSistemaSolarConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+LunaSistemaSolarConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=LunaSistemaSolarConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+LunaSistemaSolarConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Luna Sistema Solares";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Luna Sistema Solar";
	public static final String SCLASSWEBTITULO_LOWER="Luna Sistema Solar";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="LunaSistemaSolar";
	public static final String OBJECTNAME="lunasistemasolar";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="luna_sistema_solar";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select lunasistemasolar from "+LunaSistemaSolarConstantesFunciones.SPERSISTENCENAME+" lunasistemasolar";
	public static String QUERYSELECTNATIVE="select "+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+".id,"+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+".version_row,"+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+".id_tipo_valoracion,"+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+".codigo,"+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+".nombre,"+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+".descripcion from "+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME;//+" as "+LunaSistemaSolarConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected LunaSistemaSolarConstantesFuncionesAdditional lunasistemasolarConstantesFuncionesAdditional=null;
	
	public LunaSistemaSolarConstantesFuncionesAdditional getLunaSistemaSolarConstantesFuncionesAdditional() {
		return this.lunasistemasolarConstantesFuncionesAdditional;
	}
	
	public void setLunaSistemaSolarConstantesFuncionesAdditional(LunaSistemaSolarConstantesFuncionesAdditional lunasistemasolarConstantesFuncionesAdditional) {
		try {
			this.lunasistemasolarConstantesFuncionesAdditional=lunasistemasolarConstantesFuncionesAdditional;
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
    	public static final String LABEL_IDTIPOVALORACION= "Idtipo Valoracion";
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
	
	public static String getLunaSistemaSolarLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(LunaSistemaSolarConstantesFunciones.IDTIPOVALORACION)) {sLabelColumna=LunaSistemaSolarConstantesFunciones.LABEL_IDTIPOVALORACION;}
		if(sNombreColumna.equals(LunaSistemaSolarConstantesFunciones.CODIGO)) {sLabelColumna=LunaSistemaSolarConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(LunaSistemaSolarConstantesFunciones.NOMBRE)) {sLabelColumna=LunaSistemaSolarConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(LunaSistemaSolarConstantesFunciones.DESCRIPCION)) {sLabelColumna=LunaSistemaSolarConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getLunaSistemaSolarDescripcion(LunaSistemaSolar lunasistemasolar) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(lunasistemasolar !=null/* && lunasistemasolar.getId()!=0*/) {
			sDescripcion=lunasistemasolar.getcodigo();//lunasistemasolarlunasistemasolar.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getLunaSistemaSolarDescripcionDetallado(LunaSistemaSolar lunasistemasolar) {
		String sDescripcion="";
			
		sDescripcion+=LunaSistemaSolarConstantesFunciones.ID+"=";
		sDescripcion+=lunasistemasolar.getId().toString()+",";
		sDescripcion+=LunaSistemaSolarConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=lunasistemasolar.getVersionRow().toString()+",";
		sDescripcion+=LunaSistemaSolarConstantesFunciones.IDTIPOVALORACION+"=";
		sDescripcion+=lunasistemasolar.getid_tipo_valoracion().toString()+",";
		sDescripcion+=LunaSistemaSolarConstantesFunciones.CODIGO+"=";
		sDescripcion+=lunasistemasolar.getcodigo()+",";
		sDescripcion+=LunaSistemaSolarConstantesFunciones.NOMBRE+"=";
		sDescripcion+=lunasistemasolar.getnombre()+",";
		sDescripcion+=LunaSistemaSolarConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=lunasistemasolar.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setLunaSistemaSolarDescripcion(LunaSistemaSolar lunasistemasolar,String sValor) throws Exception {			
		if(lunasistemasolar !=null) {
			lunasistemasolar.setcodigo(sValor);;//lunasistemasolarlunasistemasolar.getcodigo().trim();
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
		} else if(sNombreIndice.equals("FK_IdTipoValoracion")) {
			sNombreIndice="Tipo=  Por Idtipo Valoracion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdTipoValoracion(Long id_tipo_valoracion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_valoracion!=null) {sDetalleIndice+=" Codigo Unico De Idtipo Valoracion="+id_tipo_valoracion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosLunaSistemaSolar(LunaSistemaSolar lunasistemasolar,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		lunasistemasolar.setcodigo(lunasistemasolar.getcodigo().trim());
		lunasistemasolar.setnombre(lunasistemasolar.getnombre().trim());
		lunasistemasolar.setdescripcion(lunasistemasolar.getdescripcion().trim());
	}
	
	public static void quitarEspaciosLunaSistemaSolars(List<LunaSistemaSolar> lunasistemasolars,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(LunaSistemaSolar lunasistemasolar: lunasistemasolars) {
			lunasistemasolar.setcodigo(lunasistemasolar.getcodigo().trim());
			lunasistemasolar.setnombre(lunasistemasolar.getnombre().trim());
			lunasistemasolar.setdescripcion(lunasistemasolar.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLunaSistemaSolar(LunaSistemaSolar lunasistemasolar,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && lunasistemasolar.getConCambioAuxiliar()) {
			lunasistemasolar.setIsDeleted(lunasistemasolar.getIsDeletedAuxiliar());	
			lunasistemasolar.setIsNew(lunasistemasolar.getIsNewAuxiliar());	
			lunasistemasolar.setIsChanged(lunasistemasolar.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			lunasistemasolar.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			lunasistemasolar.setIsDeletedAuxiliar(false);	
			lunasistemasolar.setIsNewAuxiliar(false);	
			lunasistemasolar.setIsChangedAuxiliar(false);
			
			lunasistemasolar.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLunaSistemaSolars(List<LunaSistemaSolar> lunasistemasolars,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(LunaSistemaSolar lunasistemasolar : lunasistemasolars) {
			if(conAsignarBase && lunasistemasolar.getConCambioAuxiliar()) {
				lunasistemasolar.setIsDeleted(lunasistemasolar.getIsDeletedAuxiliar());	
				lunasistemasolar.setIsNew(lunasistemasolar.getIsNewAuxiliar());	
				lunasistemasolar.setIsChanged(lunasistemasolar.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				lunasistemasolar.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				lunasistemasolar.setIsDeletedAuxiliar(false);	
				lunasistemasolar.setIsNewAuxiliar(false);	
				lunasistemasolar.setIsChangedAuxiliar(false);
				
				lunasistemasolar.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresLunaSistemaSolar(LunaSistemaSolar lunasistemasolar,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresLunaSistemaSolars(List<LunaSistemaSolar> lunasistemasolars,Boolean conEnteros) throws Exception  {
		
		for(LunaSistemaSolar lunasistemasolar: lunasistemasolars) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaLunaSistemaSolar(List<LunaSistemaSolar> lunasistemasolars,LunaSistemaSolar lunasistemasolarAux) throws Exception  {
		LunaSistemaSolarConstantesFunciones.InicializarValoresLunaSistemaSolar(lunasistemasolarAux,true);
		
		for(LunaSistemaSolar lunasistemasolar: lunasistemasolars) {
			if(lunasistemasolar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesLunaSistemaSolar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=LunaSistemaSolarConstantesFunciones.getArrayColumnasGlobalesLunaSistemaSolar(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesLunaSistemaSolar(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoLunaSistemaSolar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<LunaSistemaSolar> lunasistemasolars,LunaSistemaSolar lunasistemasolar,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(LunaSistemaSolar lunasistemasolarAux: lunasistemasolars) {
			if(lunasistemasolarAux!=null && lunasistemasolar!=null) {
				if((lunasistemasolarAux.getId()==null && lunasistemasolar.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(lunasistemasolarAux.getId()!=null && lunasistemasolar.getId()!=null){
					if(lunasistemasolarAux.getId().equals(lunasistemasolar.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaLunaSistemaSolar(List<LunaSistemaSolar> lunasistemasolars) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(LunaSistemaSolar lunasistemasolar: lunasistemasolars) {			
			if(lunasistemasolar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaLunaSistemaSolar() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,LunaSistemaSolarConstantesFunciones.LABEL_ID, LunaSistemaSolarConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LunaSistemaSolarConstantesFunciones.LABEL_VERSIONROW, LunaSistemaSolarConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LunaSistemaSolarConstantesFunciones.LABEL_IDTIPOVALORACION, LunaSistemaSolarConstantesFunciones.IDTIPOVALORACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LunaSistemaSolarConstantesFunciones.LABEL_CODIGO, LunaSistemaSolarConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LunaSistemaSolarConstantesFunciones.LABEL_NOMBRE, LunaSistemaSolarConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LunaSistemaSolarConstantesFunciones.LABEL_DESCRIPCION, LunaSistemaSolarConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasLunaSistemaSolar() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=LunaSistemaSolarConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LunaSistemaSolarConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LunaSistemaSolarConstantesFunciones.IDTIPOVALORACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LunaSistemaSolarConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LunaSistemaSolarConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LunaSistemaSolarConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLunaSistemaSolar() throws Exception  {
		return LunaSistemaSolarConstantesFunciones.getTiposSeleccionarLunaSistemaSolar(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLunaSistemaSolar(Boolean conFk) throws Exception  {
		return LunaSistemaSolarConstantesFunciones.getTiposSeleccionarLunaSistemaSolar(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLunaSistemaSolar(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LunaSistemaSolarConstantesFunciones.LABEL_IDTIPOVALORACION);
			reporte.setsDescripcion(LunaSistemaSolarConstantesFunciones.LABEL_IDTIPOVALORACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LunaSistemaSolarConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(LunaSistemaSolarConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LunaSistemaSolarConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(LunaSistemaSolarConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LunaSistemaSolarConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(LunaSistemaSolarConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesLunaSistemaSolar(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesLunaSistemaSolar(LunaSistemaSolar lunasistemasolarAux) throws Exception {
		
			lunasistemasolarAux.settipovaloracion_descripcion(TipoValoracionConstantesFunciones.getTipoValoracionDescripcion(lunasistemasolarAux.getTipoValoracion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesLunaSistemaSolar(List<LunaSistemaSolar> lunasistemasolarsTemp) throws Exception {
		for(LunaSistemaSolar lunasistemasolarAux:lunasistemasolarsTemp) {
			
			lunasistemasolarAux.settipovaloracion_descripcion(TipoValoracionConstantesFunciones.getTipoValoracionDescripcion(lunasistemasolarAux.getTipoValoracion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfLunaSistemaSolar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfLunaSistemaSolar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfLunaSistemaSolar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return LunaSistemaSolarConstantesFunciones.getClassesRelationshipsOfLunaSistemaSolar(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLunaSistemaSolar(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLunaSistemaSolar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return LunaSistemaSolarConstantesFunciones.getClassesRelationshipsFromStringsOfLunaSistemaSolar(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLunaSistemaSolar(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(LunaSistemaSolar lunasistemasolar,List<LunaSistemaSolar> lunasistemasolars,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			LunaSistemaSolar lunasistemasolarEncontrado=null;
			
			for(LunaSistemaSolar lunasistemasolarLocal:lunasistemasolars) {
				if(lunasistemasolarLocal.getId().equals(lunasistemasolar.getId())) {
					lunasistemasolarEncontrado=lunasistemasolarLocal;
					
					lunasistemasolarLocal.setIsChanged(lunasistemasolar.getIsChanged());
					lunasistemasolarLocal.setIsNew(lunasistemasolar.getIsNew());
					lunasistemasolarLocal.setIsDeleted(lunasistemasolar.getIsDeleted());
					
					lunasistemasolarLocal.setGeneralEntityOriginal(lunasistemasolar.getGeneralEntityOriginal());
					
					lunasistemasolarLocal.setId(lunasistemasolar.getId());	
					lunasistemasolarLocal.setVersionRow(lunasistemasolar.getVersionRow());	
					lunasistemasolarLocal.setid_tipo_valoracion(lunasistemasolar.getid_tipo_valoracion());	
					lunasistemasolarLocal.setcodigo(lunasistemasolar.getcodigo());	
					lunasistemasolarLocal.setnombre(lunasistemasolar.getnombre());	
					lunasistemasolarLocal.setdescripcion(lunasistemasolar.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!lunasistemasolar.getIsDeleted()) {
				if(!existe) {
					lunasistemasolars.add(lunasistemasolar);
				}
			} else {
				if(lunasistemasolarEncontrado!=null && permiteQuitar)  {
					lunasistemasolars.remove(lunasistemasolarEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(LunaSistemaSolar lunasistemasolar,List<LunaSistemaSolar> lunasistemasolars) throws Exception {
		try	{			
			for(LunaSistemaSolar lunasistemasolarLocal:lunasistemasolars) {
				if(lunasistemasolarLocal.getId().equals(lunasistemasolar.getId())) {
					lunasistemasolarLocal.setIsSelected(lunasistemasolar.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesLunaSistemaSolar(List<LunaSistemaSolar> lunasistemasolarsAux) throws Exception {
		//this.lunasistemasolarsAux=lunasistemasolarsAux;
		
		for(LunaSistemaSolar lunasistemasolarAux:lunasistemasolarsAux) {
			if(lunasistemasolarAux.getIsChanged()) {
				lunasistemasolarAux.setIsChanged(false);
			}		
			
			if(lunasistemasolarAux.getIsNew()) {
				lunasistemasolarAux.setIsNew(false);
			}	
			
			if(lunasistemasolarAux.getIsDeleted()) {
				lunasistemasolarAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesLunaSistemaSolar(LunaSistemaSolar lunasistemasolarAux) throws Exception {
		//this.lunasistemasolarAux=lunasistemasolarAux;
		
			if(lunasistemasolarAux.getIsChanged()) {
				lunasistemasolarAux.setIsChanged(false);
			}		
			
			if(lunasistemasolarAux.getIsNew()) {
				lunasistemasolarAux.setIsNew(false);
			}	
			
			if(lunasistemasolarAux.getIsDeleted()) {
				lunasistemasolarAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(LunaSistemaSolar lunasistemasolarAsignar,LunaSistemaSolar lunasistemasolar) throws Exception {
		lunasistemasolarAsignar.setId(lunasistemasolar.getId());	
		lunasistemasolarAsignar.setVersionRow(lunasistemasolar.getVersionRow());	
		lunasistemasolarAsignar.setid_tipo_valoracion(lunasistemasolar.getid_tipo_valoracion());
		lunasistemasolarAsignar.settipovaloracion_descripcion(lunasistemasolar.gettipovaloracion_descripcion());	
		lunasistemasolarAsignar.setcodigo(lunasistemasolar.getcodigo());	
		lunasistemasolarAsignar.setnombre(lunasistemasolar.getnombre());	
		lunasistemasolarAsignar.setdescripcion(lunasistemasolar.getdescripcion());	
	}
	
	public static void inicializarLunaSistemaSolar(LunaSistemaSolar lunasistemasolar) throws Exception {
		try {
				lunasistemasolar.setId(0L);	
					
				lunasistemasolar.setid_tipo_valoracion(-1L);	
				lunasistemasolar.setcodigo("");	
				lunasistemasolar.setnombre("");	
				lunasistemasolar.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderLunaSistemaSolar(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(LunaSistemaSolarConstantesFunciones.LABEL_IDTIPOVALORACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LunaSistemaSolarConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LunaSistemaSolarConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LunaSistemaSolarConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataLunaSistemaSolar(String sTipo,Row row,Workbook workbook,LunaSistemaSolar lunasistemasolar,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(lunasistemasolar.gettipovaloracion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(lunasistemasolar.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(lunasistemasolar.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(lunasistemasolar.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryLunaSistemaSolar=Constantes.SFINALQUERY;
	
	public String getsFinalQueryLunaSistemaSolar() {
		return this.sFinalQueryLunaSistemaSolar;
	}
	
	public void setsFinalQueryLunaSistemaSolar(String sFinalQueryLunaSistemaSolar) {
		this.sFinalQueryLunaSistemaSolar= sFinalQueryLunaSistemaSolar;
	}
	
	public Border resaltarSeleccionarLunaSistemaSolar=null;
	
	public Border setResaltarSeleccionarLunaSistemaSolar(ParametroGeneralUsuario parametroGeneralUsuario/*LunaSistemaSolarBeanSwingJInternalFrame lunasistemasolarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//lunasistemasolarBeanSwingJInternalFrame.jTtoolBarLunaSistemaSolar.setBorder(borderResaltar);
		
		this.resaltarSeleccionarLunaSistemaSolar= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarLunaSistemaSolar() {
		return this.resaltarSeleccionarLunaSistemaSolar;
	}
	
	public void setResaltarSeleccionarLunaSistemaSolar(Border borderResaltarSeleccionarLunaSistemaSolar) {
		this.resaltarSeleccionarLunaSistemaSolar= borderResaltarSeleccionarLunaSistemaSolar;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridLunaSistemaSolar=null;
	public Boolean mostraridLunaSistemaSolar=true;
	public Boolean activaridLunaSistemaSolar=true;

	public Border resaltarid_tipo_valoracionLunaSistemaSolar=null;
	public Boolean mostrarid_tipo_valoracionLunaSistemaSolar=true;
	public Boolean activarid_tipo_valoracionLunaSistemaSolar=true;
	public Boolean cargarid_tipo_valoracionLunaSistemaSolar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_valoracionLunaSistemaSolar=false;//ConEventDepend=true

	public Border resaltarcodigoLunaSistemaSolar=null;
	public Boolean mostrarcodigoLunaSistemaSolar=true;
	public Boolean activarcodigoLunaSistemaSolar=true;

	public Border resaltarnombreLunaSistemaSolar=null;
	public Boolean mostrarnombreLunaSistemaSolar=true;
	public Boolean activarnombreLunaSistemaSolar=true;

	public Border resaltardescripcionLunaSistemaSolar=null;
	public Boolean mostrardescripcionLunaSistemaSolar=true;
	public Boolean activardescripcionLunaSistemaSolar=true;

	
	

	public Border setResaltaridLunaSistemaSolar(ParametroGeneralUsuario parametroGeneralUsuario/*LunaSistemaSolarBeanSwingJInternalFrame lunasistemasolarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lunasistemasolarBeanSwingJInternalFrame.jTtoolBarLunaSistemaSolar.setBorder(borderResaltar);
		
		this.resaltaridLunaSistemaSolar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridLunaSistemaSolar() {
		return this.resaltaridLunaSistemaSolar;
	}

	public void setResaltaridLunaSistemaSolar(Border borderResaltar) {
		this.resaltaridLunaSistemaSolar= borderResaltar;
	}

	public Boolean getMostraridLunaSistemaSolar() {
		return this.mostraridLunaSistemaSolar;
	}

	public void setMostraridLunaSistemaSolar(Boolean mostraridLunaSistemaSolar) {
		this.mostraridLunaSistemaSolar= mostraridLunaSistemaSolar;
	}

	public Boolean getActivaridLunaSistemaSolar() {
		return this.activaridLunaSistemaSolar;
	}

	public void setActivaridLunaSistemaSolar(Boolean activaridLunaSistemaSolar) {
		this.activaridLunaSistemaSolar= activaridLunaSistemaSolar;
	}

	public Border setResaltarid_tipo_valoracionLunaSistemaSolar(ParametroGeneralUsuario parametroGeneralUsuario/*LunaSistemaSolarBeanSwingJInternalFrame lunasistemasolarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lunasistemasolarBeanSwingJInternalFrame.jTtoolBarLunaSistemaSolar.setBorder(borderResaltar);
		
		this.resaltarid_tipo_valoracionLunaSistemaSolar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_valoracionLunaSistemaSolar() {
		return this.resaltarid_tipo_valoracionLunaSistemaSolar;
	}

	public void setResaltarid_tipo_valoracionLunaSistemaSolar(Border borderResaltar) {
		this.resaltarid_tipo_valoracionLunaSistemaSolar= borderResaltar;
	}

	public Boolean getMostrarid_tipo_valoracionLunaSistemaSolar() {
		return this.mostrarid_tipo_valoracionLunaSistemaSolar;
	}

	public void setMostrarid_tipo_valoracionLunaSistemaSolar(Boolean mostrarid_tipo_valoracionLunaSistemaSolar) {
		this.mostrarid_tipo_valoracionLunaSistemaSolar= mostrarid_tipo_valoracionLunaSistemaSolar;
	}

	public Boolean getActivarid_tipo_valoracionLunaSistemaSolar() {
		return this.activarid_tipo_valoracionLunaSistemaSolar;
	}

	public void setActivarid_tipo_valoracionLunaSistemaSolar(Boolean activarid_tipo_valoracionLunaSistemaSolar) {
		this.activarid_tipo_valoracionLunaSistemaSolar= activarid_tipo_valoracionLunaSistemaSolar;
	}

	public Boolean getCargarid_tipo_valoracionLunaSistemaSolar() {
		return this.cargarid_tipo_valoracionLunaSistemaSolar;
	}

	public void setCargarid_tipo_valoracionLunaSistemaSolar(Boolean cargarid_tipo_valoracionLunaSistemaSolar) {
		this.cargarid_tipo_valoracionLunaSistemaSolar= cargarid_tipo_valoracionLunaSistemaSolar;
	}

	public Border setResaltarcodigoLunaSistemaSolar(ParametroGeneralUsuario parametroGeneralUsuario/*LunaSistemaSolarBeanSwingJInternalFrame lunasistemasolarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lunasistemasolarBeanSwingJInternalFrame.jTtoolBarLunaSistemaSolar.setBorder(borderResaltar);
		
		this.resaltarcodigoLunaSistemaSolar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoLunaSistemaSolar() {
		return this.resaltarcodigoLunaSistemaSolar;
	}

	public void setResaltarcodigoLunaSistemaSolar(Border borderResaltar) {
		this.resaltarcodigoLunaSistemaSolar= borderResaltar;
	}

	public Boolean getMostrarcodigoLunaSistemaSolar() {
		return this.mostrarcodigoLunaSistemaSolar;
	}

	public void setMostrarcodigoLunaSistemaSolar(Boolean mostrarcodigoLunaSistemaSolar) {
		this.mostrarcodigoLunaSistemaSolar= mostrarcodigoLunaSistemaSolar;
	}

	public Boolean getActivarcodigoLunaSistemaSolar() {
		return this.activarcodigoLunaSistemaSolar;
	}

	public void setActivarcodigoLunaSistemaSolar(Boolean activarcodigoLunaSistemaSolar) {
		this.activarcodigoLunaSistemaSolar= activarcodigoLunaSistemaSolar;
	}

	public Border setResaltarnombreLunaSistemaSolar(ParametroGeneralUsuario parametroGeneralUsuario/*LunaSistemaSolarBeanSwingJInternalFrame lunasistemasolarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lunasistemasolarBeanSwingJInternalFrame.jTtoolBarLunaSistemaSolar.setBorder(borderResaltar);
		
		this.resaltarnombreLunaSistemaSolar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreLunaSistemaSolar() {
		return this.resaltarnombreLunaSistemaSolar;
	}

	public void setResaltarnombreLunaSistemaSolar(Border borderResaltar) {
		this.resaltarnombreLunaSistemaSolar= borderResaltar;
	}

	public Boolean getMostrarnombreLunaSistemaSolar() {
		return this.mostrarnombreLunaSistemaSolar;
	}

	public void setMostrarnombreLunaSistemaSolar(Boolean mostrarnombreLunaSistemaSolar) {
		this.mostrarnombreLunaSistemaSolar= mostrarnombreLunaSistemaSolar;
	}

	public Boolean getActivarnombreLunaSistemaSolar() {
		return this.activarnombreLunaSistemaSolar;
	}

	public void setActivarnombreLunaSistemaSolar(Boolean activarnombreLunaSistemaSolar) {
		this.activarnombreLunaSistemaSolar= activarnombreLunaSistemaSolar;
	}

	public Border setResaltardescripcionLunaSistemaSolar(ParametroGeneralUsuario parametroGeneralUsuario/*LunaSistemaSolarBeanSwingJInternalFrame lunasistemasolarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lunasistemasolarBeanSwingJInternalFrame.jTtoolBarLunaSistemaSolar.setBorder(borderResaltar);
		
		this.resaltardescripcionLunaSistemaSolar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionLunaSistemaSolar() {
		return this.resaltardescripcionLunaSistemaSolar;
	}

	public void setResaltardescripcionLunaSistemaSolar(Border borderResaltar) {
		this.resaltardescripcionLunaSistemaSolar= borderResaltar;
	}

	public Boolean getMostrardescripcionLunaSistemaSolar() {
		return this.mostrardescripcionLunaSistemaSolar;
	}

	public void setMostrardescripcionLunaSistemaSolar(Boolean mostrardescripcionLunaSistemaSolar) {
		this.mostrardescripcionLunaSistemaSolar= mostrardescripcionLunaSistemaSolar;
	}

	public Boolean getActivardescripcionLunaSistemaSolar() {
		return this.activardescripcionLunaSistemaSolar;
	}

	public void setActivardescripcionLunaSistemaSolar(Boolean activardescripcionLunaSistemaSolar) {
		this.activardescripcionLunaSistemaSolar= activardescripcionLunaSistemaSolar;
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
		
		
		this.setMostraridLunaSistemaSolar(esInicial);
		this.setMostrarid_tipo_valoracionLunaSistemaSolar(esInicial);
		this.setMostrarcodigoLunaSistemaSolar(esInicial);
		this.setMostrarnombreLunaSistemaSolar(esInicial);
		this.setMostrardescripcionLunaSistemaSolar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LunaSistemaSolarConstantesFunciones.ID)) {
				this.setMostraridLunaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(LunaSistemaSolarConstantesFunciones.IDTIPOVALORACION)) {
				this.setMostrarid_tipo_valoracionLunaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(LunaSistemaSolarConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoLunaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(LunaSistemaSolarConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreLunaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(LunaSistemaSolarConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionLunaSistemaSolar(esAsigna);
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
		
		
		this.setActivaridLunaSistemaSolar(esInicial);
		this.setActivarid_tipo_valoracionLunaSistemaSolar(esInicial);
		this.setActivarcodigoLunaSistemaSolar(esInicial);
		this.setActivarnombreLunaSistemaSolar(esInicial);
		this.setActivardescripcionLunaSistemaSolar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LunaSistemaSolarConstantesFunciones.ID)) {
				this.setActivaridLunaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(LunaSistemaSolarConstantesFunciones.IDTIPOVALORACION)) {
				this.setActivarid_tipo_valoracionLunaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(LunaSistemaSolarConstantesFunciones.CODIGO)) {
				this.setActivarcodigoLunaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(LunaSistemaSolarConstantesFunciones.NOMBRE)) {
				this.setActivarnombreLunaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(LunaSistemaSolarConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionLunaSistemaSolar(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,LunaSistemaSolarBeanSwingJInternalFrame lunasistemasolarBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridLunaSistemaSolar(esInicial);
		this.setResaltarid_tipo_valoracionLunaSistemaSolar(esInicial);
		this.setResaltarcodigoLunaSistemaSolar(esInicial);
		this.setResaltarnombreLunaSistemaSolar(esInicial);
		this.setResaltardescripcionLunaSistemaSolar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LunaSistemaSolarConstantesFunciones.ID)) {
				this.setResaltaridLunaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(LunaSistemaSolarConstantesFunciones.IDTIPOVALORACION)) {
				this.setResaltarid_tipo_valoracionLunaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(LunaSistemaSolarConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoLunaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(LunaSistemaSolarConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreLunaSistemaSolar(esAsigna);
				continue;
			}

			if(campo.clase.equals(LunaSistemaSolarConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionLunaSistemaSolar(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,LunaSistemaSolarBeanSwingJInternalFrame lunasistemasolarBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdTipoValoracionLunaSistemaSolar=true;

	public Boolean getMostrarFK_IdTipoValoracionLunaSistemaSolar() {
		return this.mostrarFK_IdTipoValoracionLunaSistemaSolar;
	}

	public void setMostrarFK_IdTipoValoracionLunaSistemaSolar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoValoracionLunaSistemaSolar= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdTipoValoracionLunaSistemaSolar=true;

	public Boolean getActivarFK_IdTipoValoracionLunaSistemaSolar() {
		return this.activarFK_IdTipoValoracionLunaSistemaSolar;
	}

	public void setActivarFK_IdTipoValoracionLunaSistemaSolar(Boolean habilitarResaltar) {
		this.activarFK_IdTipoValoracionLunaSistemaSolar= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdTipoValoracionLunaSistemaSolar=null;

	public Border getResaltarFK_IdTipoValoracionLunaSistemaSolar() {
		return this.resaltarFK_IdTipoValoracionLunaSistemaSolar;
	}

	public void setResaltarFK_IdTipoValoracionLunaSistemaSolar(Border borderResaltar) {
		this.resaltarFK_IdTipoValoracionLunaSistemaSolar= borderResaltar;
	}

	public void setResaltarFK_IdTipoValoracionLunaSistemaSolar(ParametroGeneralUsuario parametroGeneralUsuario/*LunaSistemaSolarBeanSwingJInternalFrame lunasistemasolarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoValoracionLunaSistemaSolar= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}