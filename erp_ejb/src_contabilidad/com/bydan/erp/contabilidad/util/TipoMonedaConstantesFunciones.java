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


import com.bydan.erp.contabilidad.util.TipoMonedaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoMonedaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoMonedaParameterGeneral;

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
final public class TipoMonedaConstantesFunciones extends TipoMonedaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoMoneda";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoMoneda"+TipoMonedaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoMonedaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoMonedaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoMonedaConstantesFunciones.SCHEMA+"_"+TipoMonedaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoMonedaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoMonedaConstantesFunciones.SCHEMA+"_"+TipoMonedaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoMonedaConstantesFunciones.SCHEMA+"_"+TipoMonedaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoMonedaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoMonedaConstantesFunciones.SCHEMA+"_"+TipoMonedaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMonedaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMonedaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMonedaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMonedaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMonedaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMonedaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoMonedaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoMonedaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoMonedaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoMonedaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Monedas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Moneda";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Moneda";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoMoneda";
	public static final String OBJECTNAME="tipomoneda";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_moneda";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipomoneda from "+TipoMonedaConstantesFunciones.SPERSISTENCENAME+" tipomoneda";
	public static String QUERYSELECTNATIVE="select "+TipoMonedaConstantesFunciones.SCHEMA+"."+TipoMonedaConstantesFunciones.TABLENAME+".id,"+TipoMonedaConstantesFunciones.SCHEMA+"."+TipoMonedaConstantesFunciones.TABLENAME+".version_row,"+TipoMonedaConstantesFunciones.SCHEMA+"."+TipoMonedaConstantesFunciones.TABLENAME+".nombre,"+TipoMonedaConstantesFunciones.SCHEMA+"."+TipoMonedaConstantesFunciones.TABLENAME+".sigla,"+TipoMonedaConstantesFunciones.SCHEMA+"."+TipoMonedaConstantesFunciones.TABLENAME+".simbolo,"+TipoMonedaConstantesFunciones.SCHEMA+"."+TipoMonedaConstantesFunciones.TABLENAME+".esta_activo from "+TipoMonedaConstantesFunciones.SCHEMA+"."+TipoMonedaConstantesFunciones.TABLENAME;//+" as "+TipoMonedaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoMonedaConstantesFuncionesAdditional tipomonedaConstantesFuncionesAdditional=null;
	
	public TipoMonedaConstantesFuncionesAdditional getTipoMonedaConstantesFuncionesAdditional() {
		return this.tipomonedaConstantesFuncionesAdditional;
	}
	
	public void setTipoMonedaConstantesFuncionesAdditional(TipoMonedaConstantesFuncionesAdditional tipomonedaConstantesFuncionesAdditional) {
		try {
			this.tipomonedaConstantesFuncionesAdditional=tipomonedaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
    public static final String SIGLA= "sigla";
    public static final String SIMBOLO= "simbolo";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SIGLA= "Sigla";
		public static final String LABEL_SIGLA_LOWER= "Sigla";
    	public static final String LABEL_SIMBOLO= "Simbolo";
		public static final String LABEL_SIMBOLO_LOWER= "Simbolo";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIGLA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIGLA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIMBOLO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIMBOLO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getTipoMonedaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoMonedaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoMonedaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoMonedaConstantesFunciones.SIGLA)) {sLabelColumna=TipoMonedaConstantesFunciones.LABEL_SIGLA;}
		if(sNombreColumna.equals(TipoMonedaConstantesFunciones.SIMBOLO)) {sLabelColumna=TipoMonedaConstantesFunciones.LABEL_SIMBOLO;}
		if(sNombreColumna.equals(TipoMonedaConstantesFunciones.ESTAACTIVO)) {sLabelColumna=TipoMonedaConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getesta_activoDescripcion(TipoMoneda tipomoneda) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tipomoneda.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(TipoMoneda tipomoneda) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tipomoneda.getId(),tipomoneda.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getTipoMonedaDescripcion(TipoMoneda tipomoneda) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipomoneda !=null/* && tipomoneda.getId()!=0*/) {
			sDescripcion=tipomoneda.getnombre();//tipomonedatipomoneda.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoMonedaDescripcionDetallado(TipoMoneda tipomoneda) {
		String sDescripcion="";
			
		sDescripcion+=TipoMonedaConstantesFunciones.ID+"=";
		sDescripcion+=tipomoneda.getId().toString()+",";
		sDescripcion+=TipoMonedaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipomoneda.getVersionRow().toString()+",";
		sDescripcion+=TipoMonedaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipomoneda.getnombre()+",";
		sDescripcion+=TipoMonedaConstantesFunciones.SIGLA+"=";
		sDescripcion+=tipomoneda.getsigla()+",";
		sDescripcion+=TipoMonedaConstantesFunciones.SIMBOLO+"=";
		sDescripcion+=tipomoneda.getsimbolo()+",";
		sDescripcion+=TipoMonedaConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=tipomoneda.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoMonedaDescripcion(TipoMoneda tipomoneda,String sValor) throws Exception {			
		if(tipomoneda !=null) {
			tipomoneda.setnombre(sValor);;//tipomonedatipomoneda.getnombre().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorSigla")) {
			sNombreIndice="Tipo=  Por Sigla";
		} else if(sNombreIndice.equals("BusquedaPorSimbolo")) {
			sNombreIndice="Tipo=  Por Simbolo";
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

	public static String getDetalleIndiceBusquedaPorSigla(String sigla) {
		String sDetalleIndice=" Parametros->";
		if(sigla!=null) {sDetalleIndice+=" Sigla="+sigla;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorSimbolo(String simbolo) {
		String sDetalleIndice=" Parametros->";
		if(simbolo!=null) {sDetalleIndice+=" Simbolo="+simbolo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoMoneda(TipoMoneda tipomoneda,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipomoneda.setnombre(tipomoneda.getnombre().trim());
		tipomoneda.setsigla(tipomoneda.getsigla().trim());
		tipomoneda.setsimbolo(tipomoneda.getsimbolo().trim());
	}
	
	public static void quitarEspaciosTipoMonedas(List<TipoMoneda> tipomonedas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoMoneda tipomoneda: tipomonedas) {
			tipomoneda.setnombre(tipomoneda.getnombre().trim());
			tipomoneda.setsigla(tipomoneda.getsigla().trim());
			tipomoneda.setsimbolo(tipomoneda.getsimbolo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMoneda(TipoMoneda tipomoneda,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipomoneda.getConCambioAuxiliar()) {
			tipomoneda.setIsDeleted(tipomoneda.getIsDeletedAuxiliar());	
			tipomoneda.setIsNew(tipomoneda.getIsNewAuxiliar());	
			tipomoneda.setIsChanged(tipomoneda.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipomoneda.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipomoneda.setIsDeletedAuxiliar(false);	
			tipomoneda.setIsNewAuxiliar(false);	
			tipomoneda.setIsChangedAuxiliar(false);
			
			tipomoneda.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMonedas(List<TipoMoneda> tipomonedas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoMoneda tipomoneda : tipomonedas) {
			if(conAsignarBase && tipomoneda.getConCambioAuxiliar()) {
				tipomoneda.setIsDeleted(tipomoneda.getIsDeletedAuxiliar());	
				tipomoneda.setIsNew(tipomoneda.getIsNewAuxiliar());	
				tipomoneda.setIsChanged(tipomoneda.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipomoneda.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipomoneda.setIsDeletedAuxiliar(false);	
				tipomoneda.setIsNewAuxiliar(false);	
				tipomoneda.setIsChangedAuxiliar(false);
				
				tipomoneda.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoMoneda(TipoMoneda tipomoneda,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoMonedas(List<TipoMoneda> tipomonedas,Boolean conEnteros) throws Exception  {
		
		for(TipoMoneda tipomoneda: tipomonedas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoMoneda(List<TipoMoneda> tipomonedas,TipoMoneda tipomonedaAux) throws Exception  {
		TipoMonedaConstantesFunciones.InicializarValoresTipoMoneda(tipomonedaAux,true);
		
		for(TipoMoneda tipomoneda: tipomonedas) {
			if(tipomoneda.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMoneda(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoMonedaConstantesFunciones.getArrayColumnasGlobalesTipoMoneda(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMoneda(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoMoneda(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoMoneda> tipomonedas,TipoMoneda tipomoneda,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoMoneda tipomonedaAux: tipomonedas) {
			if(tipomonedaAux!=null && tipomoneda!=null) {
				if((tipomonedaAux.getId()==null && tipomoneda.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipomonedaAux.getId()!=null && tipomoneda.getId()!=null){
					if(tipomonedaAux.getId().equals(tipomoneda.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoMoneda(List<TipoMoneda> tipomonedas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoMoneda tipomoneda: tipomonedas) {			
			if(tipomoneda.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoMoneda() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoMonedaConstantesFunciones.LABEL_ID, TipoMonedaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMonedaConstantesFunciones.LABEL_VERSIONROW, TipoMonedaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMonedaConstantesFunciones.LABEL_NOMBRE, TipoMonedaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMonedaConstantesFunciones.LABEL_SIGLA, TipoMonedaConstantesFunciones.SIGLA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMonedaConstantesFunciones.LABEL_SIMBOLO, TipoMonedaConstantesFunciones.SIMBOLO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMonedaConstantesFunciones.LABEL_ESTAACTIVO, TipoMonedaConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoMoneda() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoMonedaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMonedaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMonedaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMonedaConstantesFunciones.SIGLA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMonedaConstantesFunciones.SIMBOLO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMonedaConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMoneda() throws Exception  {
		return TipoMonedaConstantesFunciones.getTiposSeleccionarTipoMoneda(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMoneda(Boolean conFk) throws Exception  {
		return TipoMonedaConstantesFunciones.getTiposSeleccionarTipoMoneda(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMoneda(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMonedaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoMonedaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMonedaConstantesFunciones.LABEL_SIGLA);
			reporte.setsDescripcion(TipoMonedaConstantesFunciones.LABEL_SIGLA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMonedaConstantesFunciones.LABEL_SIMBOLO);
			reporte.setsDescripcion(TipoMonedaConstantesFunciones.LABEL_SIMBOLO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMonedaConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(TipoMonedaConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoMoneda(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMoneda(TipoMoneda tipomonedaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMoneda(List<TipoMoneda> tipomonedasTemp) throws Exception {
		for(TipoMoneda tipomonedaAux:tipomonedasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoMoneda(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoMoneda(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMoneda(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMonedaConstantesFunciones.getClassesRelationshipsOfTipoMoneda(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMoneda(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroContabilidadDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroContabilidadDefecto.class)) {
						classes.add(new Classe(ParametroContabilidadDefecto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMoneda(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMonedaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoMoneda(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMoneda(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroContabilidadDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroContabilidadDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroContabilidadDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroContabilidadDefecto.class)); continue;
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
	public static void actualizarLista(TipoMoneda tipomoneda,List<TipoMoneda> tipomonedas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoMoneda tipomonedaEncontrado=null;
			
			for(TipoMoneda tipomonedaLocal:tipomonedas) {
				if(tipomonedaLocal.getId().equals(tipomoneda.getId())) {
					tipomonedaEncontrado=tipomonedaLocal;
					
					tipomonedaLocal.setIsChanged(tipomoneda.getIsChanged());
					tipomonedaLocal.setIsNew(tipomoneda.getIsNew());
					tipomonedaLocal.setIsDeleted(tipomoneda.getIsDeleted());
					
					tipomonedaLocal.setGeneralEntityOriginal(tipomoneda.getGeneralEntityOriginal());
					
					tipomonedaLocal.setId(tipomoneda.getId());	
					tipomonedaLocal.setVersionRow(tipomoneda.getVersionRow());	
					tipomonedaLocal.setnombre(tipomoneda.getnombre());	
					tipomonedaLocal.setsigla(tipomoneda.getsigla());	
					tipomonedaLocal.setsimbolo(tipomoneda.getsimbolo());	
					tipomonedaLocal.setesta_activo(tipomoneda.getesta_activo());	
					
					
					tipomonedaLocal.setParametroContabilidadDefectos(tipomoneda.getParametroContabilidadDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipomoneda.getIsDeleted()) {
				if(!existe) {
					tipomonedas.add(tipomoneda);
				}
			} else {
				if(tipomonedaEncontrado!=null && permiteQuitar)  {
					tipomonedas.remove(tipomonedaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoMoneda tipomoneda,List<TipoMoneda> tipomonedas) throws Exception {
		try	{			
			for(TipoMoneda tipomonedaLocal:tipomonedas) {
				if(tipomonedaLocal.getId().equals(tipomoneda.getId())) {
					tipomonedaLocal.setIsSelected(tipomoneda.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoMoneda(List<TipoMoneda> tipomonedasAux) throws Exception {
		//this.tipomonedasAux=tipomonedasAux;
		
		for(TipoMoneda tipomonedaAux:tipomonedasAux) {
			if(tipomonedaAux.getIsChanged()) {
				tipomonedaAux.setIsChanged(false);
			}		
			
			if(tipomonedaAux.getIsNew()) {
				tipomonedaAux.setIsNew(false);
			}	
			
			if(tipomonedaAux.getIsDeleted()) {
				tipomonedaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoMoneda(TipoMoneda tipomonedaAux) throws Exception {
		//this.tipomonedaAux=tipomonedaAux;
		
			if(tipomonedaAux.getIsChanged()) {
				tipomonedaAux.setIsChanged(false);
			}		
			
			if(tipomonedaAux.getIsNew()) {
				tipomonedaAux.setIsNew(false);
			}	
			
			if(tipomonedaAux.getIsDeleted()) {
				tipomonedaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoMoneda tipomonedaAsignar,TipoMoneda tipomoneda) throws Exception {
		tipomonedaAsignar.setId(tipomoneda.getId());	
		tipomonedaAsignar.setVersionRow(tipomoneda.getVersionRow());	
		tipomonedaAsignar.setnombre(tipomoneda.getnombre());	
		tipomonedaAsignar.setsigla(tipomoneda.getsigla());	
		tipomonedaAsignar.setsimbolo(tipomoneda.getsimbolo());	
		tipomonedaAsignar.setesta_activo(tipomoneda.getesta_activo());	
	}
	
	public static void inicializarTipoMoneda(TipoMoneda tipomoneda) throws Exception {
		try {
				tipomoneda.setId(0L);	
					
				tipomoneda.setnombre("");	
				tipomoneda.setsigla("");	
				tipomoneda.setsimbolo("");	
				tipomoneda.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoMoneda(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMonedaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMonedaConstantesFunciones.LABEL_SIGLA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMonedaConstantesFunciones.LABEL_SIMBOLO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMonedaConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoMoneda(String sTipo,Row row,Workbook workbook,TipoMoneda tipomoneda,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomoneda.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomoneda.getsigla());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomoneda.getsimbolo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tipomoneda.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoMoneda=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoMoneda() {
		return this.sFinalQueryTipoMoneda;
	}
	
	public void setsFinalQueryTipoMoneda(String sFinalQueryTipoMoneda) {
		this.sFinalQueryTipoMoneda= sFinalQueryTipoMoneda;
	}
	
	public Border resaltarSeleccionarTipoMoneda=null;
	
	public Border setResaltarSeleccionarTipoMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMonedaBeanSwingJInternalFrame tipomonedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipomonedaBeanSwingJInternalFrame.jTtoolBarTipoMoneda.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoMoneda= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoMoneda() {
		return this.resaltarSeleccionarTipoMoneda;
	}
	
	public void setResaltarSeleccionarTipoMoneda(Border borderResaltarSeleccionarTipoMoneda) {
		this.resaltarSeleccionarTipoMoneda= borderResaltarSeleccionarTipoMoneda;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoMoneda=null;
	public Boolean mostraridTipoMoneda=true;
	public Boolean activaridTipoMoneda=true;

	public Border resaltarnombreTipoMoneda=null;
	public Boolean mostrarnombreTipoMoneda=true;
	public Boolean activarnombreTipoMoneda=true;

	public Border resaltarsiglaTipoMoneda=null;
	public Boolean mostrarsiglaTipoMoneda=true;
	public Boolean activarsiglaTipoMoneda=true;

	public Border resaltarsimboloTipoMoneda=null;
	public Boolean mostrarsimboloTipoMoneda=true;
	public Boolean activarsimboloTipoMoneda=true;

	public Border resaltaresta_activoTipoMoneda=null;
	public Boolean mostraresta_activoTipoMoneda=true;
	public Boolean activaresta_activoTipoMoneda=true;

	
	

	public Border setResaltaridTipoMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMonedaBeanSwingJInternalFrame tipomonedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomonedaBeanSwingJInternalFrame.jTtoolBarTipoMoneda.setBorder(borderResaltar);
		
		this.resaltaridTipoMoneda= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoMoneda() {
		return this.resaltaridTipoMoneda;
	}

	public void setResaltaridTipoMoneda(Border borderResaltar) {
		this.resaltaridTipoMoneda= borderResaltar;
	}

	public Boolean getMostraridTipoMoneda() {
		return this.mostraridTipoMoneda;
	}

	public void setMostraridTipoMoneda(Boolean mostraridTipoMoneda) {
		this.mostraridTipoMoneda= mostraridTipoMoneda;
	}

	public Boolean getActivaridTipoMoneda() {
		return this.activaridTipoMoneda;
	}

	public void setActivaridTipoMoneda(Boolean activaridTipoMoneda) {
		this.activaridTipoMoneda= activaridTipoMoneda;
	}

	public Border setResaltarnombreTipoMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMonedaBeanSwingJInternalFrame tipomonedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomonedaBeanSwingJInternalFrame.jTtoolBarTipoMoneda.setBorder(borderResaltar);
		
		this.resaltarnombreTipoMoneda= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoMoneda() {
		return this.resaltarnombreTipoMoneda;
	}

	public void setResaltarnombreTipoMoneda(Border borderResaltar) {
		this.resaltarnombreTipoMoneda= borderResaltar;
	}

	public Boolean getMostrarnombreTipoMoneda() {
		return this.mostrarnombreTipoMoneda;
	}

	public void setMostrarnombreTipoMoneda(Boolean mostrarnombreTipoMoneda) {
		this.mostrarnombreTipoMoneda= mostrarnombreTipoMoneda;
	}

	public Boolean getActivarnombreTipoMoneda() {
		return this.activarnombreTipoMoneda;
	}

	public void setActivarnombreTipoMoneda(Boolean activarnombreTipoMoneda) {
		this.activarnombreTipoMoneda= activarnombreTipoMoneda;
	}

	public Border setResaltarsiglaTipoMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMonedaBeanSwingJInternalFrame tipomonedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomonedaBeanSwingJInternalFrame.jTtoolBarTipoMoneda.setBorder(borderResaltar);
		
		this.resaltarsiglaTipoMoneda= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsiglaTipoMoneda() {
		return this.resaltarsiglaTipoMoneda;
	}

	public void setResaltarsiglaTipoMoneda(Border borderResaltar) {
		this.resaltarsiglaTipoMoneda= borderResaltar;
	}

	public Boolean getMostrarsiglaTipoMoneda() {
		return this.mostrarsiglaTipoMoneda;
	}

	public void setMostrarsiglaTipoMoneda(Boolean mostrarsiglaTipoMoneda) {
		this.mostrarsiglaTipoMoneda= mostrarsiglaTipoMoneda;
	}

	public Boolean getActivarsiglaTipoMoneda() {
		return this.activarsiglaTipoMoneda;
	}

	public void setActivarsiglaTipoMoneda(Boolean activarsiglaTipoMoneda) {
		this.activarsiglaTipoMoneda= activarsiglaTipoMoneda;
	}

	public Border setResaltarsimboloTipoMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMonedaBeanSwingJInternalFrame tipomonedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomonedaBeanSwingJInternalFrame.jTtoolBarTipoMoneda.setBorder(borderResaltar);
		
		this.resaltarsimboloTipoMoneda= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsimboloTipoMoneda() {
		return this.resaltarsimboloTipoMoneda;
	}

	public void setResaltarsimboloTipoMoneda(Border borderResaltar) {
		this.resaltarsimboloTipoMoneda= borderResaltar;
	}

	public Boolean getMostrarsimboloTipoMoneda() {
		return this.mostrarsimboloTipoMoneda;
	}

	public void setMostrarsimboloTipoMoneda(Boolean mostrarsimboloTipoMoneda) {
		this.mostrarsimboloTipoMoneda= mostrarsimboloTipoMoneda;
	}

	public Boolean getActivarsimboloTipoMoneda() {
		return this.activarsimboloTipoMoneda;
	}

	public void setActivarsimboloTipoMoneda(Boolean activarsimboloTipoMoneda) {
		this.activarsimboloTipoMoneda= activarsimboloTipoMoneda;
	}

	public Border setResaltaresta_activoTipoMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMonedaBeanSwingJInternalFrame tipomonedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomonedaBeanSwingJInternalFrame.jTtoolBarTipoMoneda.setBorder(borderResaltar);
		
		this.resaltaresta_activoTipoMoneda= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoTipoMoneda() {
		return this.resaltaresta_activoTipoMoneda;
	}

	public void setResaltaresta_activoTipoMoneda(Border borderResaltar) {
		this.resaltaresta_activoTipoMoneda= borderResaltar;
	}

	public Boolean getMostraresta_activoTipoMoneda() {
		return this.mostraresta_activoTipoMoneda;
	}

	public void setMostraresta_activoTipoMoneda(Boolean mostraresta_activoTipoMoneda) {
		this.mostraresta_activoTipoMoneda= mostraresta_activoTipoMoneda;
	}

	public Boolean getActivaresta_activoTipoMoneda() {
		return this.activaresta_activoTipoMoneda;
	}

	public void setActivaresta_activoTipoMoneda(Boolean activaresta_activoTipoMoneda) {
		this.activaresta_activoTipoMoneda= activaresta_activoTipoMoneda;
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
		
		
		this.setMostraridTipoMoneda(esInicial);
		this.setMostrarnombreTipoMoneda(esInicial);
		this.setMostrarsiglaTipoMoneda(esInicial);
		this.setMostrarsimboloTipoMoneda(esInicial);
		this.setMostraresta_activoTipoMoneda(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMonedaConstantesFunciones.ID)) {
				this.setMostraridTipoMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMonedaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMonedaConstantesFunciones.SIGLA)) {
				this.setMostrarsiglaTipoMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMonedaConstantesFunciones.SIMBOLO)) {
				this.setMostrarsimboloTipoMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMonedaConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoTipoMoneda(esAsigna);
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
		
		
		this.setActivaridTipoMoneda(esInicial);
		this.setActivarnombreTipoMoneda(esInicial);
		this.setActivarsiglaTipoMoneda(esInicial);
		this.setActivarsimboloTipoMoneda(esInicial);
		this.setActivaresta_activoTipoMoneda(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMonedaConstantesFunciones.ID)) {
				this.setActivaridTipoMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMonedaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMonedaConstantesFunciones.SIGLA)) {
				this.setActivarsiglaTipoMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMonedaConstantesFunciones.SIMBOLO)) {
				this.setActivarsimboloTipoMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMonedaConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoTipoMoneda(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMonedaBeanSwingJInternalFrame tipomonedaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoMoneda(esInicial);
		this.setResaltarnombreTipoMoneda(esInicial);
		this.setResaltarsiglaTipoMoneda(esInicial);
		this.setResaltarsimboloTipoMoneda(esInicial);
		this.setResaltaresta_activoTipoMoneda(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMonedaConstantesFunciones.ID)) {
				this.setResaltaridTipoMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMonedaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMonedaConstantesFunciones.SIGLA)) {
				this.setResaltarsiglaTipoMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMonedaConstantesFunciones.SIMBOLO)) {
				this.setResaltarsimboloTipoMoneda(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMonedaConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoTipoMoneda(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarParametroContabilidadDefectoTipoMoneda=null;

	public Border getResaltarParametroContabilidadDefectoTipoMoneda() {
		return this.resaltarParametroContabilidadDefectoTipoMoneda;
	}

	public void setResaltarParametroContabilidadDefectoTipoMoneda(Border borderResaltarParametroContabilidadDefecto) {
		if(borderResaltarParametroContabilidadDefecto!=null) {
			this.resaltarParametroContabilidadDefectoTipoMoneda= borderResaltarParametroContabilidadDefecto;
		}
	}

	public Border setResaltarParametroContabilidadDefectoTipoMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMonedaBeanSwingJInternalFrame tipomonedaBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroContabilidadDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipomonedaBeanSwingJInternalFrame.jTtoolBarTipoMoneda.setBorder(borderResaltarParametroContabilidadDefecto);
			
		this.resaltarParametroContabilidadDefectoTipoMoneda= borderResaltarParametroContabilidadDefecto;

		 return borderResaltarParametroContabilidadDefecto;
	}



	public Boolean mostrarParametroContabilidadDefectoTipoMoneda=true;

	public Boolean getMostrarParametroContabilidadDefectoTipoMoneda() {
		return this.mostrarParametroContabilidadDefectoTipoMoneda;
	}

	public void setMostrarParametroContabilidadDefectoTipoMoneda(Boolean visibilidadResaltarParametroContabilidadDefecto) {
		this.mostrarParametroContabilidadDefectoTipoMoneda= visibilidadResaltarParametroContabilidadDefecto;
	}



	public Boolean activarParametroContabilidadDefectoTipoMoneda=true;

	public Boolean gethabilitarResaltarParametroContabilidadDefectoTipoMoneda() {
		return this.activarParametroContabilidadDefectoTipoMoneda;
	}

	public void setActivarParametroContabilidadDefectoTipoMoneda(Boolean habilitarResaltarParametroContabilidadDefecto) {
		this.activarParametroContabilidadDefectoTipoMoneda= habilitarResaltarParametroContabilidadDefecto;
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

		this.setMostrarParametroContabilidadDefectoTipoMoneda(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroContabilidadDefecto.class)) {
				this.setMostrarParametroContabilidadDefectoTipoMoneda(esAsigna);
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

		this.setActivarParametroContabilidadDefectoTipoMoneda(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroContabilidadDefecto.class)) {
				this.setActivarParametroContabilidadDefectoTipoMoneda(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMonedaBeanSwingJInternalFrame tipomonedaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarParametroContabilidadDefectoTipoMoneda(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroContabilidadDefecto.class)) {
				this.setResaltarParametroContabilidadDefectoTipoMoneda(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreTipoMoneda=true;

	public Boolean getMostrarBusquedaPorNombreTipoMoneda() {
		return this.mostrarBusquedaPorNombreTipoMoneda;
	}

	public void setMostrarBusquedaPorNombreTipoMoneda(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoMoneda= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorSiglaTipoMoneda=true;

	public Boolean getMostrarBusquedaPorSiglaTipoMoneda() {
		return this.mostrarBusquedaPorSiglaTipoMoneda;
	}

	public void setMostrarBusquedaPorSiglaTipoMoneda(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorSiglaTipoMoneda= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorSimboloTipoMoneda=true;

	public Boolean getMostrarBusquedaPorSimboloTipoMoneda() {
		return this.mostrarBusquedaPorSimboloTipoMoneda;
	}

	public void setMostrarBusquedaPorSimboloTipoMoneda(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorSimboloTipoMoneda= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoMoneda=true;

	public Boolean getActivarBusquedaPorNombreTipoMoneda() {
		return this.activarBusquedaPorNombreTipoMoneda;
	}

	public void setActivarBusquedaPorNombreTipoMoneda(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoMoneda= habilitarResaltar;
	}

	public Boolean activarBusquedaPorSiglaTipoMoneda=true;

	public Boolean getActivarBusquedaPorSiglaTipoMoneda() {
		return this.activarBusquedaPorSiglaTipoMoneda;
	}

	public void setActivarBusquedaPorSiglaTipoMoneda(Boolean habilitarResaltar) {
		this.activarBusquedaPorSiglaTipoMoneda= habilitarResaltar;
	}

	public Boolean activarBusquedaPorSimboloTipoMoneda=true;

	public Boolean getActivarBusquedaPorSimboloTipoMoneda() {
		return this.activarBusquedaPorSimboloTipoMoneda;
	}

	public void setActivarBusquedaPorSimboloTipoMoneda(Boolean habilitarResaltar) {
		this.activarBusquedaPorSimboloTipoMoneda= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoMoneda=null;

	public Border getResaltarBusquedaPorNombreTipoMoneda() {
		return this.resaltarBusquedaPorNombreTipoMoneda;
	}

	public void setResaltarBusquedaPorNombreTipoMoneda(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoMoneda= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMonedaBeanSwingJInternalFrame tipomonedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoMoneda= borderResaltar;
	}

	public Border resaltarBusquedaPorSiglaTipoMoneda=null;

	public Border getResaltarBusquedaPorSiglaTipoMoneda() {
		return this.resaltarBusquedaPorSiglaTipoMoneda;
	}

	public void setResaltarBusquedaPorSiglaTipoMoneda(Border borderResaltar) {
		this.resaltarBusquedaPorSiglaTipoMoneda= borderResaltar;
	}

	public void setResaltarBusquedaPorSiglaTipoMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMonedaBeanSwingJInternalFrame tipomonedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorSiglaTipoMoneda= borderResaltar;
	}

	public Border resaltarBusquedaPorSimboloTipoMoneda=null;

	public Border getResaltarBusquedaPorSimboloTipoMoneda() {
		return this.resaltarBusquedaPorSimboloTipoMoneda;
	}

	public void setResaltarBusquedaPorSimboloTipoMoneda(Border borderResaltar) {
		this.resaltarBusquedaPorSimboloTipoMoneda= borderResaltar;
	}

	public void setResaltarBusquedaPorSimboloTipoMoneda(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMonedaBeanSwingJInternalFrame tipomonedaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorSimboloTipoMoneda= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}