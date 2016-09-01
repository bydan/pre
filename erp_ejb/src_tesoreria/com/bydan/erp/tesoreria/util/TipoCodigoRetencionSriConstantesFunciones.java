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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.TipoCodigoRetencionSriConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoCodigoRetencionSriParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoCodigoRetencionSriParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoCodigoRetencionSriConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCodigoRetencionSri";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCodigoRetencionSri"+TipoCodigoRetencionSriConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCodigoRetencionSriHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCodigoRetencionSriHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"_"+TipoCodigoRetencionSriConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCodigoRetencionSriHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"_"+TipoCodigoRetencionSriConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"_"+TipoCodigoRetencionSriConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCodigoRetencionSriHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"_"+TipoCodigoRetencionSriConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCodigoRetencionSriConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCodigoRetencionSriHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCodigoRetencionSriConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCodigoRetencionSriConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCodigoRetencionSriHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCodigoRetencionSriConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCodigoRetencionSriConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCodigoRetencionSriConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCodigoRetencionSriConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCodigoRetencionSriConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Codigo Retencion Sris";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Codigo Retencion Sri";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Codigo Retencion Sri";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCodigoRetencionSri";
	public static final String OBJECTNAME="tipocodigoretencionsri";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="tipo_codigo_retencion_sri";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocodigoretencionsri from "+TipoCodigoRetencionSriConstantesFunciones.SPERSISTENCENAME+" tipocodigoretencionsri";
	public static String QUERYSELECTNATIVE="select "+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+".id,"+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+".version_row,"+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+".id_pais,"+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+".codigo,"+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+".nombre from "+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME;//+" as "+TipoCodigoRetencionSriConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoCodigoRetencionSriLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCodigoRetencionSriConstantesFunciones.IDPAIS)) {sLabelColumna=TipoCodigoRetencionSriConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoCodigoRetencionSriConstantesFunciones.CODIGO)) {sLabelColumna=TipoCodigoRetencionSriConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoCodigoRetencionSriConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCodigoRetencionSriConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoCodigoRetencionSriDescripcion(TipoCodigoRetencionSri tipocodigoretencionsri) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocodigoretencionsri !=null/* && tipocodigoretencionsri.getId()!=0*/) {
			sDescripcion=tipocodigoretencionsri.getcodigo();//tipocodigoretencionsritipocodigoretencionsri.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCodigoRetencionSriDescripcionDetallado(TipoCodigoRetencionSri tipocodigoretencionsri) {
		String sDescripcion="";
			
		sDescripcion+=TipoCodigoRetencionSriConstantesFunciones.ID+"=";
		sDescripcion+=tipocodigoretencionsri.getId().toString()+",";
		sDescripcion+=TipoCodigoRetencionSriConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocodigoretencionsri.getVersionRow().toString()+",";
		sDescripcion+=TipoCodigoRetencionSriConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tipocodigoretencionsri.getid_pais().toString()+",";
		sDescripcion+=TipoCodigoRetencionSriConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocodigoretencionsri.getcodigo()+",";
		sDescripcion+=TipoCodigoRetencionSriConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocodigoretencionsri.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCodigoRetencionSriDescripcion(TipoCodigoRetencionSri tipocodigoretencionsri,String sValor) throws Exception {			
		if(tipocodigoretencionsri !=null) {
			tipocodigoretencionsri.setcodigo(sValor);;//tipocodigoretencionsritipocodigoretencionsri.getcodigo().trim();
		}		
	}
	
		

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
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
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
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

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoCodigoRetencionSri(TipoCodigoRetencionSri tipocodigoretencionsri,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocodigoretencionsri.setcodigo(tipocodigoretencionsri.getcodigo().trim());
		tipocodigoretencionsri.setnombre(tipocodigoretencionsri.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCodigoRetencionSris(List<TipoCodigoRetencionSri> tipocodigoretencionsris,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCodigoRetencionSri tipocodigoretencionsri: tipocodigoretencionsris) {
			tipocodigoretencionsri.setcodigo(tipocodigoretencionsri.getcodigo().trim());
			tipocodigoretencionsri.setnombre(tipocodigoretencionsri.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCodigoRetencionSri(TipoCodigoRetencionSri tipocodigoretencionsri,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocodigoretencionsri.getConCambioAuxiliar()) {
			tipocodigoretencionsri.setIsDeleted(tipocodigoretencionsri.getIsDeletedAuxiliar());	
			tipocodigoretencionsri.setIsNew(tipocodigoretencionsri.getIsNewAuxiliar());	
			tipocodigoretencionsri.setIsChanged(tipocodigoretencionsri.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocodigoretencionsri.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocodigoretencionsri.setIsDeletedAuxiliar(false);	
			tipocodigoretencionsri.setIsNewAuxiliar(false);	
			tipocodigoretencionsri.setIsChangedAuxiliar(false);
			
			tipocodigoretencionsri.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCodigoRetencionSris(List<TipoCodigoRetencionSri> tipocodigoretencionsris,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCodigoRetencionSri tipocodigoretencionsri : tipocodigoretencionsris) {
			if(conAsignarBase && tipocodigoretencionsri.getConCambioAuxiliar()) {
				tipocodigoretencionsri.setIsDeleted(tipocodigoretencionsri.getIsDeletedAuxiliar());	
				tipocodigoretencionsri.setIsNew(tipocodigoretencionsri.getIsNewAuxiliar());	
				tipocodigoretencionsri.setIsChanged(tipocodigoretencionsri.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocodigoretencionsri.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocodigoretencionsri.setIsDeletedAuxiliar(false);	
				tipocodigoretencionsri.setIsNewAuxiliar(false);	
				tipocodigoretencionsri.setIsChangedAuxiliar(false);
				
				tipocodigoretencionsri.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCodigoRetencionSri(TipoCodigoRetencionSri tipocodigoretencionsri,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCodigoRetencionSris(List<TipoCodigoRetencionSri> tipocodigoretencionsris,Boolean conEnteros) throws Exception  {
		
		for(TipoCodigoRetencionSri tipocodigoretencionsri: tipocodigoretencionsris) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCodigoRetencionSri(List<TipoCodigoRetencionSri> tipocodigoretencionsris,TipoCodigoRetencionSri tipocodigoretencionsriAux) throws Exception  {
		TipoCodigoRetencionSriConstantesFunciones.InicializarValoresTipoCodigoRetencionSri(tipocodigoretencionsriAux,true);
		
		for(TipoCodigoRetencionSri tipocodigoretencionsri: tipocodigoretencionsris) {
			if(tipocodigoretencionsri.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCodigoRetencionSri(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCodigoRetencionSriConstantesFunciones.getArrayColumnasGlobalesTipoCodigoRetencionSri(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCodigoRetencionSri(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCodigoRetencionSri(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCodigoRetencionSri> tipocodigoretencionsris,TipoCodigoRetencionSri tipocodigoretencionsri,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCodigoRetencionSri tipocodigoretencionsriAux: tipocodigoretencionsris) {
			if(tipocodigoretencionsriAux!=null && tipocodigoretencionsri!=null) {
				if((tipocodigoretencionsriAux.getId()==null && tipocodigoretencionsri.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocodigoretencionsriAux.getId()!=null && tipocodigoretencionsri.getId()!=null){
					if(tipocodigoretencionsriAux.getId().equals(tipocodigoretencionsri.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCodigoRetencionSri(List<TipoCodigoRetencionSri> tipocodigoretencionsris) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCodigoRetencionSri tipocodigoretencionsri: tipocodigoretencionsris) {			
			if(tipocodigoretencionsri.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCodigoRetencionSri() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCodigoRetencionSriConstantesFunciones.LABEL_ID, TipoCodigoRetencionSriConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCodigoRetencionSriConstantesFunciones.LABEL_VERSIONROW, TipoCodigoRetencionSriConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCodigoRetencionSriConstantesFunciones.LABEL_IDPAIS, TipoCodigoRetencionSriConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCodigoRetencionSriConstantesFunciones.LABEL_CODIGO, TipoCodigoRetencionSriConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCodigoRetencionSriConstantesFunciones.LABEL_NOMBRE, TipoCodigoRetencionSriConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCodigoRetencionSri() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCodigoRetencionSriConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCodigoRetencionSriConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCodigoRetencionSriConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCodigoRetencionSriConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCodigoRetencionSriConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCodigoRetencionSri() throws Exception  {
		return TipoCodigoRetencionSriConstantesFunciones.getTiposSeleccionarTipoCodigoRetencionSri(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCodigoRetencionSri(Boolean conFk) throws Exception  {
		return TipoCodigoRetencionSriConstantesFunciones.getTiposSeleccionarTipoCodigoRetencionSri(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCodigoRetencionSri(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCodigoRetencionSriConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoCodigoRetencionSriConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCodigoRetencionSriConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCodigoRetencionSriConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCodigoRetencionSriConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCodigoRetencionSriConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCodigoRetencionSri(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(TipoCodigoRetencionSri tipocodigoretencionsriAux) throws Exception {
		
			tipocodigoretencionsriAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipocodigoretencionsriAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(List<TipoCodigoRetencionSri> tipocodigoretencionsrisTemp) throws Exception {
		for(TipoCodigoRetencionSri tipocodigoretencionsriAux:tipocodigoretencionsrisTemp) {
			
			tipocodigoretencionsriAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipocodigoretencionsriAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCodigoRetencionSri(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Pais.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCodigoRetencionSri(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCodigoRetencionSri(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCodigoRetencionSriConstantesFunciones.getClassesRelationshipsOfTipoCodigoRetencionSri(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCodigoRetencionSri(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCodigoRetencionSri(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCodigoRetencionSriConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCodigoRetencionSri(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCodigoRetencionSri(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoCodigoRetencionSri tipocodigoretencionsri,List<TipoCodigoRetencionSri> tipocodigoretencionsris,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCodigoRetencionSri tipocodigoretencionsriEncontrado=null;
			
			for(TipoCodigoRetencionSri tipocodigoretencionsriLocal:tipocodigoretencionsris) {
				if(tipocodigoretencionsriLocal.getId().equals(tipocodigoretencionsri.getId())) {
					tipocodigoretencionsriEncontrado=tipocodigoretencionsriLocal;
					
					tipocodigoretencionsriLocal.setIsChanged(tipocodigoretencionsri.getIsChanged());
					tipocodigoretencionsriLocal.setIsNew(tipocodigoretencionsri.getIsNew());
					tipocodigoretencionsriLocal.setIsDeleted(tipocodigoretencionsri.getIsDeleted());
					
					tipocodigoretencionsriLocal.setGeneralEntityOriginal(tipocodigoretencionsri.getGeneralEntityOriginal());
					
					tipocodigoretencionsriLocal.setId(tipocodigoretencionsri.getId());	
					tipocodigoretencionsriLocal.setVersionRow(tipocodigoretencionsri.getVersionRow());	
					tipocodigoretencionsriLocal.setid_pais(tipocodigoretencionsri.getid_pais());	
					tipocodigoretencionsriLocal.setcodigo(tipocodigoretencionsri.getcodigo());	
					tipocodigoretencionsriLocal.setnombre(tipocodigoretencionsri.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipocodigoretencionsri.getIsDeleted()) {
				if(!existe) {
					tipocodigoretencionsris.add(tipocodigoretencionsri);
				}
			} else {
				if(tipocodigoretencionsriEncontrado!=null && permiteQuitar)  {
					tipocodigoretencionsris.remove(tipocodigoretencionsriEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCodigoRetencionSri tipocodigoretencionsri,List<TipoCodigoRetencionSri> tipocodigoretencionsris) throws Exception {
		try	{			
			for(TipoCodigoRetencionSri tipocodigoretencionsriLocal:tipocodigoretencionsris) {
				if(tipocodigoretencionsriLocal.getId().equals(tipocodigoretencionsri.getId())) {
					tipocodigoretencionsriLocal.setIsSelected(tipocodigoretencionsri.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCodigoRetencionSri(List<TipoCodigoRetencionSri> tipocodigoretencionsrisAux) throws Exception {
		//this.tipocodigoretencionsrisAux=tipocodigoretencionsrisAux;
		
		for(TipoCodigoRetencionSri tipocodigoretencionsriAux:tipocodigoretencionsrisAux) {
			if(tipocodigoretencionsriAux.getIsChanged()) {
				tipocodigoretencionsriAux.setIsChanged(false);
			}		
			
			if(tipocodigoretencionsriAux.getIsNew()) {
				tipocodigoretencionsriAux.setIsNew(false);
			}	
			
			if(tipocodigoretencionsriAux.getIsDeleted()) {
				tipocodigoretencionsriAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCodigoRetencionSri(TipoCodigoRetencionSri tipocodigoretencionsriAux) throws Exception {
		//this.tipocodigoretencionsriAux=tipocodigoretencionsriAux;
		
			if(tipocodigoretencionsriAux.getIsChanged()) {
				tipocodigoretencionsriAux.setIsChanged(false);
			}		
			
			if(tipocodigoretencionsriAux.getIsNew()) {
				tipocodigoretencionsriAux.setIsNew(false);
			}	
			
			if(tipocodigoretencionsriAux.getIsDeleted()) {
				tipocodigoretencionsriAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCodigoRetencionSri tipocodigoretencionsriAsignar,TipoCodigoRetencionSri tipocodigoretencionsri) throws Exception {
		tipocodigoretencionsriAsignar.setId(tipocodigoretencionsri.getId());	
		tipocodigoretencionsriAsignar.setVersionRow(tipocodigoretencionsri.getVersionRow());	
		tipocodigoretencionsriAsignar.setid_pais(tipocodigoretencionsri.getid_pais());
		tipocodigoretencionsriAsignar.setpais_descripcion(tipocodigoretencionsri.getpais_descripcion());	
		tipocodigoretencionsriAsignar.setcodigo(tipocodigoretencionsri.getcodigo());	
		tipocodigoretencionsriAsignar.setnombre(tipocodigoretencionsri.getnombre());	
	}
	
	public static void inicializarTipoCodigoRetencionSri(TipoCodigoRetencionSri tipocodigoretencionsri) throws Exception {
		try {
				tipocodigoretencionsri.setId(0L);	
					
				tipocodigoretencionsri.setid_pais(-1L);	
				tipocodigoretencionsri.setcodigo("");	
				tipocodigoretencionsri.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCodigoRetencionSri(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCodigoRetencionSriConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCodigoRetencionSriConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCodigoRetencionSriConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCodigoRetencionSri(String sTipo,Row row,Workbook workbook,TipoCodigoRetencionSri tipocodigoretencionsri,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocodigoretencionsri.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocodigoretencionsri.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocodigoretencionsri.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCodigoRetencionSri=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCodigoRetencionSri() {
		return this.sFinalQueryTipoCodigoRetencionSri;
	}
	
	public void setsFinalQueryTipoCodigoRetencionSri(String sFinalQueryTipoCodigoRetencionSri) {
		this.sFinalQueryTipoCodigoRetencionSri= sFinalQueryTipoCodigoRetencionSri;
	}
	
	public Border resaltarSeleccionarTipoCodigoRetencionSri=null;
	
	public Border setResaltarSeleccionarTipoCodigoRetencionSri(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCodigoRetencionSriBeanSwingJInternalFrame tipocodigoretencionsriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocodigoretencionsriBeanSwingJInternalFrame.jTtoolBarTipoCodigoRetencionSri.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCodigoRetencionSri= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCodigoRetencionSri() {
		return this.resaltarSeleccionarTipoCodigoRetencionSri;
	}
	
	public void setResaltarSeleccionarTipoCodigoRetencionSri(Border borderResaltarSeleccionarTipoCodigoRetencionSri) {
		this.resaltarSeleccionarTipoCodigoRetencionSri= borderResaltarSeleccionarTipoCodigoRetencionSri;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCodigoRetencionSri=null;
	public Boolean mostraridTipoCodigoRetencionSri=true;
	public Boolean activaridTipoCodigoRetencionSri=true;

	public Border resaltarid_paisTipoCodigoRetencionSri=null;
	public Boolean mostrarid_paisTipoCodigoRetencionSri=true;
	public Boolean activarid_paisTipoCodigoRetencionSri=true;
	public Boolean cargarid_paisTipoCodigoRetencionSri=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoCodigoRetencionSri=false;//ConEventDepend=true

	public Border resaltarcodigoTipoCodigoRetencionSri=null;
	public Boolean mostrarcodigoTipoCodigoRetencionSri=true;
	public Boolean activarcodigoTipoCodigoRetencionSri=true;

	public Border resaltarnombreTipoCodigoRetencionSri=null;
	public Boolean mostrarnombreTipoCodigoRetencionSri=true;
	public Boolean activarnombreTipoCodigoRetencionSri=true;

	
	

	public Border setResaltaridTipoCodigoRetencionSri(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCodigoRetencionSriBeanSwingJInternalFrame tipocodigoretencionsriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocodigoretencionsriBeanSwingJInternalFrame.jTtoolBarTipoCodigoRetencionSri.setBorder(borderResaltar);
		
		this.resaltaridTipoCodigoRetencionSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCodigoRetencionSri() {
		return this.resaltaridTipoCodigoRetencionSri;
	}

	public void setResaltaridTipoCodigoRetencionSri(Border borderResaltar) {
		this.resaltaridTipoCodigoRetencionSri= borderResaltar;
	}

	public Boolean getMostraridTipoCodigoRetencionSri() {
		return this.mostraridTipoCodigoRetencionSri;
	}

	public void setMostraridTipoCodigoRetencionSri(Boolean mostraridTipoCodigoRetencionSri) {
		this.mostraridTipoCodigoRetencionSri= mostraridTipoCodigoRetencionSri;
	}

	public Boolean getActivaridTipoCodigoRetencionSri() {
		return this.activaridTipoCodigoRetencionSri;
	}

	public void setActivaridTipoCodigoRetencionSri(Boolean activaridTipoCodigoRetencionSri) {
		this.activaridTipoCodigoRetencionSri= activaridTipoCodigoRetencionSri;
	}

	public Border setResaltarid_paisTipoCodigoRetencionSri(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCodigoRetencionSriBeanSwingJInternalFrame tipocodigoretencionsriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocodigoretencionsriBeanSwingJInternalFrame.jTtoolBarTipoCodigoRetencionSri.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoCodigoRetencionSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoCodigoRetencionSri() {
		return this.resaltarid_paisTipoCodigoRetencionSri;
	}

	public void setResaltarid_paisTipoCodigoRetencionSri(Border borderResaltar) {
		this.resaltarid_paisTipoCodigoRetencionSri= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoCodigoRetencionSri() {
		return this.mostrarid_paisTipoCodigoRetencionSri;
	}

	public void setMostrarid_paisTipoCodigoRetencionSri(Boolean mostrarid_paisTipoCodigoRetencionSri) {
		this.mostrarid_paisTipoCodigoRetencionSri= mostrarid_paisTipoCodigoRetencionSri;
	}

	public Boolean getActivarid_paisTipoCodigoRetencionSri() {
		return this.activarid_paisTipoCodigoRetencionSri;
	}

	public void setActivarid_paisTipoCodigoRetencionSri(Boolean activarid_paisTipoCodigoRetencionSri) {
		this.activarid_paisTipoCodigoRetencionSri= activarid_paisTipoCodigoRetencionSri;
	}

	public Boolean getCargarid_paisTipoCodigoRetencionSri() {
		return this.cargarid_paisTipoCodigoRetencionSri;
	}

	public void setCargarid_paisTipoCodigoRetencionSri(Boolean cargarid_paisTipoCodigoRetencionSri) {
		this.cargarid_paisTipoCodigoRetencionSri= cargarid_paisTipoCodigoRetencionSri;
	}

	public Border setResaltarcodigoTipoCodigoRetencionSri(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCodigoRetencionSriBeanSwingJInternalFrame tipocodigoretencionsriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocodigoretencionsriBeanSwingJInternalFrame.jTtoolBarTipoCodigoRetencionSri.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCodigoRetencionSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCodigoRetencionSri() {
		return this.resaltarcodigoTipoCodigoRetencionSri;
	}

	public void setResaltarcodigoTipoCodigoRetencionSri(Border borderResaltar) {
		this.resaltarcodigoTipoCodigoRetencionSri= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCodigoRetencionSri() {
		return this.mostrarcodigoTipoCodigoRetencionSri;
	}

	public void setMostrarcodigoTipoCodigoRetencionSri(Boolean mostrarcodigoTipoCodigoRetencionSri) {
		this.mostrarcodigoTipoCodigoRetencionSri= mostrarcodigoTipoCodigoRetencionSri;
	}

	public Boolean getActivarcodigoTipoCodigoRetencionSri() {
		return this.activarcodigoTipoCodigoRetencionSri;
	}

	public void setActivarcodigoTipoCodigoRetencionSri(Boolean activarcodigoTipoCodigoRetencionSri) {
		this.activarcodigoTipoCodigoRetencionSri= activarcodigoTipoCodigoRetencionSri;
	}

	public Border setResaltarnombreTipoCodigoRetencionSri(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCodigoRetencionSriBeanSwingJInternalFrame tipocodigoretencionsriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocodigoretencionsriBeanSwingJInternalFrame.jTtoolBarTipoCodigoRetencionSri.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCodigoRetencionSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCodigoRetencionSri() {
		return this.resaltarnombreTipoCodigoRetencionSri;
	}

	public void setResaltarnombreTipoCodigoRetencionSri(Border borderResaltar) {
		this.resaltarnombreTipoCodigoRetencionSri= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCodigoRetencionSri() {
		return this.mostrarnombreTipoCodigoRetencionSri;
	}

	public void setMostrarnombreTipoCodigoRetencionSri(Boolean mostrarnombreTipoCodigoRetencionSri) {
		this.mostrarnombreTipoCodigoRetencionSri= mostrarnombreTipoCodigoRetencionSri;
	}

	public Boolean getActivarnombreTipoCodigoRetencionSri() {
		return this.activarnombreTipoCodigoRetencionSri;
	}

	public void setActivarnombreTipoCodigoRetencionSri(Boolean activarnombreTipoCodigoRetencionSri) {
		this.activarnombreTipoCodigoRetencionSri= activarnombreTipoCodigoRetencionSri;
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
		
		
		this.setMostraridTipoCodigoRetencionSri(esInicial);
		this.setMostrarid_paisTipoCodigoRetencionSri(esInicial);
		this.setMostrarcodigoTipoCodigoRetencionSri(esInicial);
		this.setMostrarnombreTipoCodigoRetencionSri(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCodigoRetencionSriConstantesFunciones.ID)) {
				this.setMostraridTipoCodigoRetencionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCodigoRetencionSriConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoCodigoRetencionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCodigoRetencionSriConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCodigoRetencionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCodigoRetencionSriConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCodigoRetencionSri(esAsigna);
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
		
		
		this.setActivaridTipoCodigoRetencionSri(esInicial);
		this.setActivarid_paisTipoCodigoRetencionSri(esInicial);
		this.setActivarcodigoTipoCodigoRetencionSri(esInicial);
		this.setActivarnombreTipoCodigoRetencionSri(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCodigoRetencionSriConstantesFunciones.ID)) {
				this.setActivaridTipoCodigoRetencionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCodigoRetencionSriConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoCodigoRetencionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCodigoRetencionSriConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCodigoRetencionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCodigoRetencionSriConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCodigoRetencionSri(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCodigoRetencionSriBeanSwingJInternalFrame tipocodigoretencionsriBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCodigoRetencionSri(esInicial);
		this.setResaltarid_paisTipoCodigoRetencionSri(esInicial);
		this.setResaltarcodigoTipoCodigoRetencionSri(esInicial);
		this.setResaltarnombreTipoCodigoRetencionSri(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCodigoRetencionSriConstantesFunciones.ID)) {
				this.setResaltaridTipoCodigoRetencionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCodigoRetencionSriConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoCodigoRetencionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCodigoRetencionSriConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCodigoRetencionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCodigoRetencionSriConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCodigoRetencionSri(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCodigoRetencionSriBeanSwingJInternalFrame tipocodigoretencionsriBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoTipoCodigoRetencionSri=true;

	public Boolean getMostrarBusquedaPorCodigoTipoCodigoRetencionSri() {
		return this.mostrarBusquedaPorCodigoTipoCodigoRetencionSri;
	}

	public void setMostrarBusquedaPorCodigoTipoCodigoRetencionSri(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoCodigoRetencionSri= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoCodigoRetencionSri=true;

	public Boolean getMostrarBusquedaPorNombreTipoCodigoRetencionSri() {
		return this.mostrarBusquedaPorNombreTipoCodigoRetencionSri;
	}

	public void setMostrarBusquedaPorNombreTipoCodigoRetencionSri(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoCodigoRetencionSri= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisTipoCodigoRetencionSri=true;

	public Boolean getMostrarFK_IdPaisTipoCodigoRetencionSri() {
		return this.mostrarFK_IdPaisTipoCodigoRetencionSri;
	}

	public void setMostrarFK_IdPaisTipoCodigoRetencionSri(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoCodigoRetencionSri= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoCodigoRetencionSri=true;

	public Boolean getActivarBusquedaPorCodigoTipoCodigoRetencionSri() {
		return this.activarBusquedaPorCodigoTipoCodigoRetencionSri;
	}

	public void setActivarBusquedaPorCodigoTipoCodigoRetencionSri(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoCodigoRetencionSri= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoCodigoRetencionSri=true;

	public Boolean getActivarBusquedaPorNombreTipoCodigoRetencionSri() {
		return this.activarBusquedaPorNombreTipoCodigoRetencionSri;
	}

	public void setActivarBusquedaPorNombreTipoCodigoRetencionSri(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoCodigoRetencionSri= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisTipoCodigoRetencionSri=true;

	public Boolean getActivarFK_IdPaisTipoCodigoRetencionSri() {
		return this.activarFK_IdPaisTipoCodigoRetencionSri;
	}

	public void setActivarFK_IdPaisTipoCodigoRetencionSri(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoCodigoRetencionSri= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoCodigoRetencionSri=null;

	public Border getResaltarBusquedaPorCodigoTipoCodigoRetencionSri() {
		return this.resaltarBusquedaPorCodigoTipoCodigoRetencionSri;
	}

	public void setResaltarBusquedaPorCodigoTipoCodigoRetencionSri(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoCodigoRetencionSri= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoCodigoRetencionSri(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCodigoRetencionSriBeanSwingJInternalFrame tipocodigoretencionsriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoCodigoRetencionSri= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoCodigoRetencionSri=null;

	public Border getResaltarBusquedaPorNombreTipoCodigoRetencionSri() {
		return this.resaltarBusquedaPorNombreTipoCodigoRetencionSri;
	}

	public void setResaltarBusquedaPorNombreTipoCodigoRetencionSri(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoCodigoRetencionSri= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoCodigoRetencionSri(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCodigoRetencionSriBeanSwingJInternalFrame tipocodigoretencionsriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoCodigoRetencionSri= borderResaltar;
	}

	public Border resaltarFK_IdPaisTipoCodigoRetencionSri=null;

	public Border getResaltarFK_IdPaisTipoCodigoRetencionSri() {
		return this.resaltarFK_IdPaisTipoCodigoRetencionSri;
	}

	public void setResaltarFK_IdPaisTipoCodigoRetencionSri(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoCodigoRetencionSri= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoCodigoRetencionSri(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCodigoRetencionSriBeanSwingJInternalFrame tipocodigoretencionsriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoCodigoRetencionSri= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}