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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.TipoParamFactuSecuenciaTrabajoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoParamFactuSecuenciaTrabajoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoParamFactuSecuenciaTrabajoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoParamFactuSecuenciaTrabajoConstantesFunciones extends TipoParamFactuSecuenciaTrabajoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoParamFactuSecuenciaTrabajo";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoParamFactuSecuenciaTrabajo"+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoParamFactuSecuenciaTrabajoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoParamFactuSecuenciaTrabajoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"_"+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoParamFactuSecuenciaTrabajoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"_"+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"_"+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoParamFactuSecuenciaTrabajoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"_"+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoParamFactuSecuenciaTrabajoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoParamFactuSecuenciaTrabajoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoParamFactuSecuenciaTrabajoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoParamFactuSecuenciaTrabajoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Secuencia Trabajos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Secuencia Trabajo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Param Factu Secuencia Trabajo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoParamFactuSecuenciaTrabajo";
	public static final String OBJECTNAME="tipoparamfactusecuenciatrabajo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_param_factu_secuencia_trabajo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoparamfactusecuenciatrabajo from "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SPERSISTENCENAME+" tipoparamfactusecuenciatrabajo";
	public static String QUERYSELECTNATIVE="select "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME+".id,"+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME+".version_row,"+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME+".nombre from "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME;//+" as "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoParamFactuSecuenciaTrabajoConstantesFuncionesAdditional tipoparamfactusecuenciatrabajoConstantesFuncionesAdditional=null;
	
	public TipoParamFactuSecuenciaTrabajoConstantesFuncionesAdditional getTipoParamFactuSecuenciaTrabajoConstantesFuncionesAdditional() {
		return this.tipoparamfactusecuenciatrabajoConstantesFuncionesAdditional;
	}
	
	public void setTipoParamFactuSecuenciaTrabajoConstantesFuncionesAdditional(TipoParamFactuSecuenciaTrabajoConstantesFuncionesAdditional tipoparamfactusecuenciatrabajoConstantesFuncionesAdditional) {
		try {
			this.tipoparamfactusecuenciatrabajoConstantesFuncionesAdditional=tipoparamfactusecuenciatrabajoConstantesFuncionesAdditional;
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
	
	public static String getTipoParamFactuSecuenciaTrabajoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoParamFactuSecuenciaTrabajoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoParamFactuSecuenciaTrabajoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getTipoParamFactuSecuenciaTrabajoDescripcion(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoparamfactusecuenciatrabajo !=null/* && tipoparamfactusecuenciatrabajo.getId()!=0*/) {
			sDescripcion=tipoparamfactusecuenciatrabajo.getnombre();//tipoparamfactusecuenciatrabajotipoparamfactusecuenciatrabajo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoParamFactuSecuenciaTrabajoDescripcionDetallado(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo) {
		String sDescripcion="";
			
		sDescripcion+=TipoParamFactuSecuenciaTrabajoConstantesFunciones.ID+"=";
		sDescripcion+=tipoparamfactusecuenciatrabajo.getId().toString()+",";
		sDescripcion+=TipoParamFactuSecuenciaTrabajoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoparamfactusecuenciatrabajo.getVersionRow().toString()+",";
		sDescripcion+=TipoParamFactuSecuenciaTrabajoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoparamfactusecuenciatrabajo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoParamFactuSecuenciaTrabajoDescripcion(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo,String sValor) throws Exception {			
		if(tipoparamfactusecuenciatrabajo !=null) {
			tipoparamfactusecuenciatrabajo.setnombre(sValor);//tipoparamfactusecuenciatrabajotipoparamfactusecuenciatrabajo.getId().toString();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
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

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoParamFactuSecuenciaTrabajo(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoparamfactusecuenciatrabajo.setnombre(tipoparamfactusecuenciatrabajo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoParamFactuSecuenciaTrabajos(List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo: tipoparamfactusecuenciatrabajos) {
			tipoparamfactusecuenciatrabajo.setnombre(tipoparamfactusecuenciatrabajo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoParamFactuSecuenciaTrabajo(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoparamfactusecuenciatrabajo.getConCambioAuxiliar()) {
			tipoparamfactusecuenciatrabajo.setIsDeleted(tipoparamfactusecuenciatrabajo.getIsDeletedAuxiliar());	
			tipoparamfactusecuenciatrabajo.setIsNew(tipoparamfactusecuenciatrabajo.getIsNewAuxiliar());	
			tipoparamfactusecuenciatrabajo.setIsChanged(tipoparamfactusecuenciatrabajo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoparamfactusecuenciatrabajo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoparamfactusecuenciatrabajo.setIsDeletedAuxiliar(false);	
			tipoparamfactusecuenciatrabajo.setIsNewAuxiliar(false);	
			tipoparamfactusecuenciatrabajo.setIsChangedAuxiliar(false);
			
			tipoparamfactusecuenciatrabajo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoParamFactuSecuenciaTrabajos(List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo : tipoparamfactusecuenciatrabajos) {
			if(conAsignarBase && tipoparamfactusecuenciatrabajo.getConCambioAuxiliar()) {
				tipoparamfactusecuenciatrabajo.setIsDeleted(tipoparamfactusecuenciatrabajo.getIsDeletedAuxiliar());	
				tipoparamfactusecuenciatrabajo.setIsNew(tipoparamfactusecuenciatrabajo.getIsNewAuxiliar());	
				tipoparamfactusecuenciatrabajo.setIsChanged(tipoparamfactusecuenciatrabajo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoparamfactusecuenciatrabajo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoparamfactusecuenciatrabajo.setIsDeletedAuxiliar(false);	
				tipoparamfactusecuenciatrabajo.setIsNewAuxiliar(false);	
				tipoparamfactusecuenciatrabajo.setIsChangedAuxiliar(false);
				
				tipoparamfactusecuenciatrabajo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoParamFactuSecuenciaTrabajo(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoParamFactuSecuenciaTrabajos(List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos,Boolean conEnteros) throws Exception  {
		
		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo: tipoparamfactusecuenciatrabajos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoParamFactuSecuenciaTrabajo(List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos,TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoAux) throws Exception  {
		TipoParamFactuSecuenciaTrabajoConstantesFunciones.InicializarValoresTipoParamFactuSecuenciaTrabajo(tipoparamfactusecuenciatrabajoAux,true);
		
		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo: tipoparamfactusecuenciatrabajos) {
			if(tipoparamfactusecuenciatrabajo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoParamFactuSecuenciaTrabajo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoParamFactuSecuenciaTrabajoConstantesFunciones.getArrayColumnasGlobalesTipoParamFactuSecuenciaTrabajo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoParamFactuSecuenciaTrabajo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoParamFactuSecuenciaTrabajo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos,TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoAux: tipoparamfactusecuenciatrabajos) {
			if(tipoparamfactusecuenciatrabajoAux!=null && tipoparamfactusecuenciatrabajo!=null) {
				if((tipoparamfactusecuenciatrabajoAux.getId()==null && tipoparamfactusecuenciatrabajo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoparamfactusecuenciatrabajoAux.getId()!=null && tipoparamfactusecuenciatrabajo.getId()!=null){
					if(tipoparamfactusecuenciatrabajoAux.getId().equals(tipoparamfactusecuenciatrabajo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoParamFactuSecuenciaTrabajo(List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo: tipoparamfactusecuenciatrabajos) {			
			if(tipoparamfactusecuenciatrabajo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoParamFactuSecuenciaTrabajo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoParamFactuSecuenciaTrabajoConstantesFunciones.LABEL_ID, TipoParamFactuSecuenciaTrabajoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoParamFactuSecuenciaTrabajoConstantesFunciones.LABEL_VERSIONROW, TipoParamFactuSecuenciaTrabajoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoParamFactuSecuenciaTrabajoConstantesFunciones.LABEL_NOMBRE, TipoParamFactuSecuenciaTrabajoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoParamFactuSecuenciaTrabajo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoParamFactuSecuenciaTrabajoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoParamFactuSecuenciaTrabajoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoParamFactuSecuenciaTrabajoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParamFactuSecuenciaTrabajo() throws Exception  {
		return TipoParamFactuSecuenciaTrabajoConstantesFunciones.getTiposSeleccionarTipoParamFactuSecuenciaTrabajo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParamFactuSecuenciaTrabajo(Boolean conFk) throws Exception  {
		return TipoParamFactuSecuenciaTrabajoConstantesFunciones.getTiposSeleccionarTipoParamFactuSecuenciaTrabajo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParamFactuSecuenciaTrabajo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoParamFactuSecuenciaTrabajoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoParamFactuSecuenciaTrabajoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoParamFactuSecuenciaTrabajo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoParamFactuSecuenciaTrabajo(List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajosTemp) throws Exception {
		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoAux:tipoparamfactusecuenciatrabajosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoParamFactuSecuenciaTrabajo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoParamFactuSecuenciaTrabajo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParamFactuSecuenciaTrabajo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoParamFactuSecuenciaTrabajoConstantesFunciones.getClassesRelationshipsOfTipoParamFactuSecuenciaTrabajo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParamFactuSecuenciaTrabajo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroFactuPrincipal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroFactuPrincipal.class)) {
						classes.add(new Classe(ParametroFactuPrincipal.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoParamFactuSecuenciaTrabajo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoParamFactuSecuenciaTrabajoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoParamFactuSecuenciaTrabajo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoParamFactuSecuenciaTrabajo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFactuPrincipal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFactuPrincipal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFactuPrincipal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFactuPrincipal.class)); continue;
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
	public static void actualizarLista(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo,List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoEncontrado=null;
			
			for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoLocal:tipoparamfactusecuenciatrabajos) {
				if(tipoparamfactusecuenciatrabajoLocal.getId().equals(tipoparamfactusecuenciatrabajo.getId())) {
					tipoparamfactusecuenciatrabajoEncontrado=tipoparamfactusecuenciatrabajoLocal;
					
					tipoparamfactusecuenciatrabajoLocal.setIsChanged(tipoparamfactusecuenciatrabajo.getIsChanged());
					tipoparamfactusecuenciatrabajoLocal.setIsNew(tipoparamfactusecuenciatrabajo.getIsNew());
					tipoparamfactusecuenciatrabajoLocal.setIsDeleted(tipoparamfactusecuenciatrabajo.getIsDeleted());
					
					tipoparamfactusecuenciatrabajoLocal.setGeneralEntityOriginal(tipoparamfactusecuenciatrabajo.getGeneralEntityOriginal());
					
					tipoparamfactusecuenciatrabajoLocal.setId(tipoparamfactusecuenciatrabajo.getId());	
					tipoparamfactusecuenciatrabajoLocal.setVersionRow(tipoparamfactusecuenciatrabajo.getVersionRow());	
					tipoparamfactusecuenciatrabajoLocal.setnombre(tipoparamfactusecuenciatrabajo.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoparamfactusecuenciatrabajo.getIsDeleted()) {
				if(!existe) {
					tipoparamfactusecuenciatrabajos.add(tipoparamfactusecuenciatrabajo);
				}
			} else {
				if(tipoparamfactusecuenciatrabajoEncontrado!=null && permiteQuitar)  {
					tipoparamfactusecuenciatrabajos.remove(tipoparamfactusecuenciatrabajoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo,List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos) throws Exception {
		try	{			
			for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoLocal:tipoparamfactusecuenciatrabajos) {
				if(tipoparamfactusecuenciatrabajoLocal.getId().equals(tipoparamfactusecuenciatrabajo.getId())) {
					tipoparamfactusecuenciatrabajoLocal.setIsSelected(tipoparamfactusecuenciatrabajo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoParamFactuSecuenciaTrabajo(List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajosAux) throws Exception {
		//this.tipoparamfactusecuenciatrabajosAux=tipoparamfactusecuenciatrabajosAux;
		
		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoAux:tipoparamfactusecuenciatrabajosAux) {
			if(tipoparamfactusecuenciatrabajoAux.getIsChanged()) {
				tipoparamfactusecuenciatrabajoAux.setIsChanged(false);
			}		
			
			if(tipoparamfactusecuenciatrabajoAux.getIsNew()) {
				tipoparamfactusecuenciatrabajoAux.setIsNew(false);
			}	
			
			if(tipoparamfactusecuenciatrabajoAux.getIsDeleted()) {
				tipoparamfactusecuenciatrabajoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoParamFactuSecuenciaTrabajo(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoAux) throws Exception {
		//this.tipoparamfactusecuenciatrabajoAux=tipoparamfactusecuenciatrabajoAux;
		
			if(tipoparamfactusecuenciatrabajoAux.getIsChanged()) {
				tipoparamfactusecuenciatrabajoAux.setIsChanged(false);
			}		
			
			if(tipoparamfactusecuenciatrabajoAux.getIsNew()) {
				tipoparamfactusecuenciatrabajoAux.setIsNew(false);
			}	
			
			if(tipoparamfactusecuenciatrabajoAux.getIsDeleted()) {
				tipoparamfactusecuenciatrabajoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajoAsignar,TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo) throws Exception {
		tipoparamfactusecuenciatrabajoAsignar.setId(tipoparamfactusecuenciatrabajo.getId());	
		tipoparamfactusecuenciatrabajoAsignar.setVersionRow(tipoparamfactusecuenciatrabajo.getVersionRow());	
		tipoparamfactusecuenciatrabajoAsignar.setnombre(tipoparamfactusecuenciatrabajo.getnombre());	
	}
	
	public static void inicializarTipoParamFactuSecuenciaTrabajo(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo) throws Exception {
		try {
				tipoparamfactusecuenciatrabajo.setId(0L);	
					
				tipoparamfactusecuenciatrabajo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoParamFactuSecuenciaTrabajo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoParamFactuSecuenciaTrabajoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoParamFactuSecuenciaTrabajo(String sTipo,Row row,Workbook workbook,TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoparamfactusecuenciatrabajo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoParamFactuSecuenciaTrabajo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoParamFactuSecuenciaTrabajo() {
		return this.sFinalQueryTipoParamFactuSecuenciaTrabajo;
	}
	
	public void setsFinalQueryTipoParamFactuSecuenciaTrabajo(String sFinalQueryTipoParamFactuSecuenciaTrabajo) {
		this.sFinalQueryTipoParamFactuSecuenciaTrabajo= sFinalQueryTipoParamFactuSecuenciaTrabajo;
	}
	
	public Border resaltarSeleccionarTipoParamFactuSecuenciaTrabajo=null;
	
	public Border setResaltarSeleccionarTipoParamFactuSecuenciaTrabajo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuSecuenciaTrabajoBeanSwingJInternalFrame tipoparamfactusecuenciatrabajoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoparamfactusecuenciatrabajoBeanSwingJInternalFrame.jTtoolBarTipoParamFactuSecuenciaTrabajo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoParamFactuSecuenciaTrabajo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoParamFactuSecuenciaTrabajo() {
		return this.resaltarSeleccionarTipoParamFactuSecuenciaTrabajo;
	}
	
	public void setResaltarSeleccionarTipoParamFactuSecuenciaTrabajo(Border borderResaltarSeleccionarTipoParamFactuSecuenciaTrabajo) {
		this.resaltarSeleccionarTipoParamFactuSecuenciaTrabajo= borderResaltarSeleccionarTipoParamFactuSecuenciaTrabajo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoParamFactuSecuenciaTrabajo=null;
	public Boolean mostraridTipoParamFactuSecuenciaTrabajo=true;
	public Boolean activaridTipoParamFactuSecuenciaTrabajo=true;

	public Border resaltarnombreTipoParamFactuSecuenciaTrabajo=null;
	public Boolean mostrarnombreTipoParamFactuSecuenciaTrabajo=true;
	public Boolean activarnombreTipoParamFactuSecuenciaTrabajo=true;

	
	

	public Border setResaltaridTipoParamFactuSecuenciaTrabajo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuSecuenciaTrabajoBeanSwingJInternalFrame tipoparamfactusecuenciatrabajoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoparamfactusecuenciatrabajoBeanSwingJInternalFrame.jTtoolBarTipoParamFactuSecuenciaTrabajo.setBorder(borderResaltar);
		
		this.resaltaridTipoParamFactuSecuenciaTrabajo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoParamFactuSecuenciaTrabajo() {
		return this.resaltaridTipoParamFactuSecuenciaTrabajo;
	}

	public void setResaltaridTipoParamFactuSecuenciaTrabajo(Border borderResaltar) {
		this.resaltaridTipoParamFactuSecuenciaTrabajo= borderResaltar;
	}

	public Boolean getMostraridTipoParamFactuSecuenciaTrabajo() {
		return this.mostraridTipoParamFactuSecuenciaTrabajo;
	}

	public void setMostraridTipoParamFactuSecuenciaTrabajo(Boolean mostraridTipoParamFactuSecuenciaTrabajo) {
		this.mostraridTipoParamFactuSecuenciaTrabajo= mostraridTipoParamFactuSecuenciaTrabajo;
	}

	public Boolean getActivaridTipoParamFactuSecuenciaTrabajo() {
		return this.activaridTipoParamFactuSecuenciaTrabajo;
	}

	public void setActivaridTipoParamFactuSecuenciaTrabajo(Boolean activaridTipoParamFactuSecuenciaTrabajo) {
		this.activaridTipoParamFactuSecuenciaTrabajo= activaridTipoParamFactuSecuenciaTrabajo;
	}

	public Border setResaltarnombreTipoParamFactuSecuenciaTrabajo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuSecuenciaTrabajoBeanSwingJInternalFrame tipoparamfactusecuenciatrabajoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoparamfactusecuenciatrabajoBeanSwingJInternalFrame.jTtoolBarTipoParamFactuSecuenciaTrabajo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoParamFactuSecuenciaTrabajo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoParamFactuSecuenciaTrabajo() {
		return this.resaltarnombreTipoParamFactuSecuenciaTrabajo;
	}

	public void setResaltarnombreTipoParamFactuSecuenciaTrabajo(Border borderResaltar) {
		this.resaltarnombreTipoParamFactuSecuenciaTrabajo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoParamFactuSecuenciaTrabajo() {
		return this.mostrarnombreTipoParamFactuSecuenciaTrabajo;
	}

	public void setMostrarnombreTipoParamFactuSecuenciaTrabajo(Boolean mostrarnombreTipoParamFactuSecuenciaTrabajo) {
		this.mostrarnombreTipoParamFactuSecuenciaTrabajo= mostrarnombreTipoParamFactuSecuenciaTrabajo;
	}

	public Boolean getActivarnombreTipoParamFactuSecuenciaTrabajo() {
		return this.activarnombreTipoParamFactuSecuenciaTrabajo;
	}

	public void setActivarnombreTipoParamFactuSecuenciaTrabajo(Boolean activarnombreTipoParamFactuSecuenciaTrabajo) {
		this.activarnombreTipoParamFactuSecuenciaTrabajo= activarnombreTipoParamFactuSecuenciaTrabajo;
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
		
		
		this.setMostraridTipoParamFactuSecuenciaTrabajo(esInicial);
		this.setMostrarnombreTipoParamFactuSecuenciaTrabajo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParamFactuSecuenciaTrabajoConstantesFunciones.ID)) {
				this.setMostraridTipoParamFactuSecuenciaTrabajo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParamFactuSecuenciaTrabajoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoParamFactuSecuenciaTrabajo(esAsigna);
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
		
		
		this.setActivaridTipoParamFactuSecuenciaTrabajo(esInicial);
		this.setActivarnombreTipoParamFactuSecuenciaTrabajo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParamFactuSecuenciaTrabajoConstantesFunciones.ID)) {
				this.setActivaridTipoParamFactuSecuenciaTrabajo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParamFactuSecuenciaTrabajoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoParamFactuSecuenciaTrabajo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoParamFactuSecuenciaTrabajoBeanSwingJInternalFrame tipoparamfactusecuenciatrabajoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoParamFactuSecuenciaTrabajo(esInicial);
		this.setResaltarnombreTipoParamFactuSecuenciaTrabajo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParamFactuSecuenciaTrabajoConstantesFunciones.ID)) {
				this.setResaltaridTipoParamFactuSecuenciaTrabajo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParamFactuSecuenciaTrabajoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoParamFactuSecuenciaTrabajo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoParamFactuSecuenciaTrabajoBeanSwingJInternalFrame tipoparamfactusecuenciatrabajoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo=true;

	public Boolean getMostrarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo() {
		return this.mostrarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo;
	}

	public void setMostrarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo=true;

	public Boolean getActivarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo() {
		return this.activarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo;
	}

	public void setActivarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo=null;

	public Border getResaltarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo() {
		return this.resaltarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo;
	}

	public void setResaltarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuSecuenciaTrabajoBeanSwingJInternalFrame tipoparamfactusecuenciatrabajoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoParamFactuSecuenciaTrabajo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}