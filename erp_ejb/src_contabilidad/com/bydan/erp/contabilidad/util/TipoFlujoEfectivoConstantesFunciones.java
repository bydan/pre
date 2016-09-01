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


import com.bydan.erp.contabilidad.util.TipoFlujoEfectivoConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoFlujoEfectivoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoFlujoEfectivoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoFlujoEfectivoConstantesFunciones extends TipoFlujoEfectivoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoFlujoEfectivo";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoFlujoEfectivo"+TipoFlujoEfectivoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoFlujoEfectivoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoFlujoEfectivoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoFlujoEfectivoConstantesFunciones.SCHEMA+"_"+TipoFlujoEfectivoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoFlujoEfectivoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoFlujoEfectivoConstantesFunciones.SCHEMA+"_"+TipoFlujoEfectivoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoFlujoEfectivoConstantesFunciones.SCHEMA+"_"+TipoFlujoEfectivoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoFlujoEfectivoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoFlujoEfectivoConstantesFunciones.SCHEMA+"_"+TipoFlujoEfectivoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFlujoEfectivoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFlujoEfectivoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFlujoEfectivoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFlujoEfectivoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFlujoEfectivoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFlujoEfectivoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoFlujoEfectivoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoFlujoEfectivoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoFlujoEfectivoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoFlujoEfectivoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Flujo Efectivo s";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Flujo Efectivo ";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Flujo Efectivo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoFlujoEfectivo";
	public static final String OBJECTNAME="tipoflujoefectivo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_flujo_efectivo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoflujoefectivo from "+TipoFlujoEfectivoConstantesFunciones.SPERSISTENCENAME+" tipoflujoefectivo";
	public static String QUERYSELECTNATIVE="select "+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME+".id,"+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME+".version_row,"+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME+".id_empresa,"+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME+".nombre from "+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME;//+" as "+TipoFlujoEfectivoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoFlujoEfectivoConstantesFuncionesAdditional tipoflujoefectivoConstantesFuncionesAdditional=null;
	
	public TipoFlujoEfectivoConstantesFuncionesAdditional getTipoFlujoEfectivoConstantesFuncionesAdditional() {
		return this.tipoflujoefectivoConstantesFuncionesAdditional;
	}
	
	public void setTipoFlujoEfectivoConstantesFuncionesAdditional(TipoFlujoEfectivoConstantesFuncionesAdditional tipoflujoefectivoConstantesFuncionesAdditional) {
		try {
			this.tipoflujoefectivoConstantesFuncionesAdditional=tipoflujoefectivoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoFlujoEfectivoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoFlujoEfectivoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoFlujoEfectivoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoFlujoEfectivoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoFlujoEfectivoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoFlujoEfectivoDescripcion(TipoFlujoEfectivo tipoflujoefectivo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoflujoefectivo !=null/* && tipoflujoefectivo.getId()!=0*/) {
			sDescripcion=tipoflujoefectivo.getnombre();//tipoflujoefectivotipoflujoefectivo.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoFlujoEfectivoDescripcionDetallado(TipoFlujoEfectivo tipoflujoefectivo) {
		String sDescripcion="";
			
		sDescripcion+=TipoFlujoEfectivoConstantesFunciones.ID+"=";
		sDescripcion+=tipoflujoefectivo.getId().toString()+",";
		sDescripcion+=TipoFlujoEfectivoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoflujoefectivo.getVersionRow().toString()+",";
		sDescripcion+=TipoFlujoEfectivoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoflujoefectivo.getid_empresa().toString()+",";
		sDescripcion+=TipoFlujoEfectivoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoflujoefectivo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoFlujoEfectivoDescripcion(TipoFlujoEfectivo tipoflujoefectivo,String sValor) throws Exception {			
		if(tipoflujoefectivo !=null) {
			tipoflujoefectivo.setnombre(sValor);;//tipoflujoefectivotipoflujoefectivo.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoFlujoEfectivo(TipoFlujoEfectivo tipoflujoefectivo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoflujoefectivo.setnombre(tipoflujoefectivo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoFlujoEfectivos(List<TipoFlujoEfectivo> tipoflujoefectivos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoFlujoEfectivo tipoflujoefectivo: tipoflujoefectivos) {
			tipoflujoefectivo.setnombre(tipoflujoefectivo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFlujoEfectivo(TipoFlujoEfectivo tipoflujoefectivo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoflujoefectivo.getConCambioAuxiliar()) {
			tipoflujoefectivo.setIsDeleted(tipoflujoefectivo.getIsDeletedAuxiliar());	
			tipoflujoefectivo.setIsNew(tipoflujoefectivo.getIsNewAuxiliar());	
			tipoflujoefectivo.setIsChanged(tipoflujoefectivo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoflujoefectivo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoflujoefectivo.setIsDeletedAuxiliar(false);	
			tipoflujoefectivo.setIsNewAuxiliar(false);	
			tipoflujoefectivo.setIsChangedAuxiliar(false);
			
			tipoflujoefectivo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFlujoEfectivos(List<TipoFlujoEfectivo> tipoflujoefectivos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoFlujoEfectivo tipoflujoefectivo : tipoflujoefectivos) {
			if(conAsignarBase && tipoflujoefectivo.getConCambioAuxiliar()) {
				tipoflujoefectivo.setIsDeleted(tipoflujoefectivo.getIsDeletedAuxiliar());	
				tipoflujoefectivo.setIsNew(tipoflujoefectivo.getIsNewAuxiliar());	
				tipoflujoefectivo.setIsChanged(tipoflujoefectivo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoflujoefectivo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoflujoefectivo.setIsDeletedAuxiliar(false);	
				tipoflujoefectivo.setIsNewAuxiliar(false);	
				tipoflujoefectivo.setIsChangedAuxiliar(false);
				
				tipoflujoefectivo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoFlujoEfectivo(TipoFlujoEfectivo tipoflujoefectivo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoFlujoEfectivos(List<TipoFlujoEfectivo> tipoflujoefectivos,Boolean conEnteros) throws Exception  {
		
		for(TipoFlujoEfectivo tipoflujoefectivo: tipoflujoefectivos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoFlujoEfectivo(List<TipoFlujoEfectivo> tipoflujoefectivos,TipoFlujoEfectivo tipoflujoefectivoAux) throws Exception  {
		TipoFlujoEfectivoConstantesFunciones.InicializarValoresTipoFlujoEfectivo(tipoflujoefectivoAux,true);
		
		for(TipoFlujoEfectivo tipoflujoefectivo: tipoflujoefectivos) {
			if(tipoflujoefectivo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFlujoEfectivo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoFlujoEfectivoConstantesFunciones.getArrayColumnasGlobalesTipoFlujoEfectivo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFlujoEfectivo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoFlujoEfectivoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoFlujoEfectivoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoFlujoEfectivo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoFlujoEfectivo> tipoflujoefectivos,TipoFlujoEfectivo tipoflujoefectivo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoFlujoEfectivo tipoflujoefectivoAux: tipoflujoefectivos) {
			if(tipoflujoefectivoAux!=null && tipoflujoefectivo!=null) {
				if((tipoflujoefectivoAux.getId()==null && tipoflujoefectivo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoflujoefectivoAux.getId()!=null && tipoflujoefectivo.getId()!=null){
					if(tipoflujoefectivoAux.getId().equals(tipoflujoefectivo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoFlujoEfectivo(List<TipoFlujoEfectivo> tipoflujoefectivos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoFlujoEfectivo tipoflujoefectivo: tipoflujoefectivos) {			
			if(tipoflujoefectivo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoFlujoEfectivo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoFlujoEfectivoConstantesFunciones.LABEL_ID, TipoFlujoEfectivoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFlujoEfectivoConstantesFunciones.LABEL_VERSIONROW, TipoFlujoEfectivoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFlujoEfectivoConstantesFunciones.LABEL_IDEMPRESA, TipoFlujoEfectivoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFlujoEfectivoConstantesFunciones.LABEL_NOMBRE, TipoFlujoEfectivoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoFlujoEfectivo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoFlujoEfectivoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFlujoEfectivoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFlujoEfectivoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFlujoEfectivoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFlujoEfectivo() throws Exception  {
		return TipoFlujoEfectivoConstantesFunciones.getTiposSeleccionarTipoFlujoEfectivo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFlujoEfectivo(Boolean conFk) throws Exception  {
		return TipoFlujoEfectivoConstantesFunciones.getTiposSeleccionarTipoFlujoEfectivo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFlujoEfectivo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFlujoEfectivoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoFlujoEfectivoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFlujoEfectivoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoFlujoEfectivoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoFlujoEfectivo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFlujoEfectivo(TipoFlujoEfectivo tipoflujoefectivoAux) throws Exception {
		
			tipoflujoefectivoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoflujoefectivoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFlujoEfectivo(List<TipoFlujoEfectivo> tipoflujoefectivosTemp) throws Exception {
		for(TipoFlujoEfectivo tipoflujoefectivoAux:tipoflujoefectivosTemp) {
			
			tipoflujoefectivoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoflujoefectivoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoFlujoEfectivo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoFlujoEfectivo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFlujoEfectivo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFlujoEfectivoConstantesFunciones.getClassesRelationshipsOfTipoFlujoEfectivo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFlujoEfectivo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFlujoEfectivo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFlujoEfectivoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoFlujoEfectivo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFlujoEfectivo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoFlujoEfectivo tipoflujoefectivo,List<TipoFlujoEfectivo> tipoflujoefectivos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoFlujoEfectivo tipoflujoefectivoEncontrado=null;
			
			for(TipoFlujoEfectivo tipoflujoefectivoLocal:tipoflujoefectivos) {
				if(tipoflujoefectivoLocal.getId().equals(tipoflujoefectivo.getId())) {
					tipoflujoefectivoEncontrado=tipoflujoefectivoLocal;
					
					tipoflujoefectivoLocal.setIsChanged(tipoflujoefectivo.getIsChanged());
					tipoflujoefectivoLocal.setIsNew(tipoflujoefectivo.getIsNew());
					tipoflujoefectivoLocal.setIsDeleted(tipoflujoefectivo.getIsDeleted());
					
					tipoflujoefectivoLocal.setGeneralEntityOriginal(tipoflujoefectivo.getGeneralEntityOriginal());
					
					tipoflujoefectivoLocal.setId(tipoflujoefectivo.getId());	
					tipoflujoefectivoLocal.setVersionRow(tipoflujoefectivo.getVersionRow());	
					tipoflujoefectivoLocal.setid_empresa(tipoflujoefectivo.getid_empresa());	
					tipoflujoefectivoLocal.setnombre(tipoflujoefectivo.getnombre());	
					
					
					tipoflujoefectivoLocal.setCuentaContables(tipoflujoefectivo.getCuentaContables());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoflujoefectivo.getIsDeleted()) {
				if(!existe) {
					tipoflujoefectivos.add(tipoflujoefectivo);
				}
			} else {
				if(tipoflujoefectivoEncontrado!=null && permiteQuitar)  {
					tipoflujoefectivos.remove(tipoflujoefectivoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoFlujoEfectivo tipoflujoefectivo,List<TipoFlujoEfectivo> tipoflujoefectivos) throws Exception {
		try	{			
			for(TipoFlujoEfectivo tipoflujoefectivoLocal:tipoflujoefectivos) {
				if(tipoflujoefectivoLocal.getId().equals(tipoflujoefectivo.getId())) {
					tipoflujoefectivoLocal.setIsSelected(tipoflujoefectivo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoFlujoEfectivo(List<TipoFlujoEfectivo> tipoflujoefectivosAux) throws Exception {
		//this.tipoflujoefectivosAux=tipoflujoefectivosAux;
		
		for(TipoFlujoEfectivo tipoflujoefectivoAux:tipoflujoefectivosAux) {
			if(tipoflujoefectivoAux.getIsChanged()) {
				tipoflujoefectivoAux.setIsChanged(false);
			}		
			
			if(tipoflujoefectivoAux.getIsNew()) {
				tipoflujoefectivoAux.setIsNew(false);
			}	
			
			if(tipoflujoefectivoAux.getIsDeleted()) {
				tipoflujoefectivoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoFlujoEfectivo(TipoFlujoEfectivo tipoflujoefectivoAux) throws Exception {
		//this.tipoflujoefectivoAux=tipoflujoefectivoAux;
		
			if(tipoflujoefectivoAux.getIsChanged()) {
				tipoflujoefectivoAux.setIsChanged(false);
			}		
			
			if(tipoflujoefectivoAux.getIsNew()) {
				tipoflujoefectivoAux.setIsNew(false);
			}	
			
			if(tipoflujoefectivoAux.getIsDeleted()) {
				tipoflujoefectivoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoFlujoEfectivo tipoflujoefectivoAsignar,TipoFlujoEfectivo tipoflujoefectivo) throws Exception {
		tipoflujoefectivoAsignar.setId(tipoflujoefectivo.getId());	
		tipoflujoefectivoAsignar.setVersionRow(tipoflujoefectivo.getVersionRow());	
		tipoflujoefectivoAsignar.setid_empresa(tipoflujoefectivo.getid_empresa());
		tipoflujoefectivoAsignar.setempresa_descripcion(tipoflujoefectivo.getempresa_descripcion());	
		tipoflujoefectivoAsignar.setnombre(tipoflujoefectivo.getnombre());	
	}
	
	public static void inicializarTipoFlujoEfectivo(TipoFlujoEfectivo tipoflujoefectivo) throws Exception {
		try {
				tipoflujoefectivo.setId(0L);	
					
				tipoflujoefectivo.setid_empresa(-1L);	
				tipoflujoefectivo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoFlujoEfectivo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFlujoEfectivoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFlujoEfectivoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoFlujoEfectivo(String sTipo,Row row,Workbook workbook,TipoFlujoEfectivo tipoflujoefectivo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoflujoefectivo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoflujoefectivo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoFlujoEfectivo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoFlujoEfectivo() {
		return this.sFinalQueryTipoFlujoEfectivo;
	}
	
	public void setsFinalQueryTipoFlujoEfectivo(String sFinalQueryTipoFlujoEfectivo) {
		this.sFinalQueryTipoFlujoEfectivo= sFinalQueryTipoFlujoEfectivo;
	}
	
	public Border resaltarSeleccionarTipoFlujoEfectivo=null;
	
	public Border setResaltarSeleccionarTipoFlujoEfectivo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFlujoEfectivoBeanSwingJInternalFrame tipoflujoefectivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoflujoefectivoBeanSwingJInternalFrame.jTtoolBarTipoFlujoEfectivo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoFlujoEfectivo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoFlujoEfectivo() {
		return this.resaltarSeleccionarTipoFlujoEfectivo;
	}
	
	public void setResaltarSeleccionarTipoFlujoEfectivo(Border borderResaltarSeleccionarTipoFlujoEfectivo) {
		this.resaltarSeleccionarTipoFlujoEfectivo= borderResaltarSeleccionarTipoFlujoEfectivo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoFlujoEfectivo=null;
	public Boolean mostraridTipoFlujoEfectivo=true;
	public Boolean activaridTipoFlujoEfectivo=true;

	public Border resaltarid_empresaTipoFlujoEfectivo=null;
	public Boolean mostrarid_empresaTipoFlujoEfectivo=true;
	public Boolean activarid_empresaTipoFlujoEfectivo=true;
	public Boolean cargarid_empresaTipoFlujoEfectivo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoFlujoEfectivo=false;//ConEventDepend=true

	public Border resaltarnombreTipoFlujoEfectivo=null;
	public Boolean mostrarnombreTipoFlujoEfectivo=true;
	public Boolean activarnombreTipoFlujoEfectivo=true;

	
	

	public Border setResaltaridTipoFlujoEfectivo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFlujoEfectivoBeanSwingJInternalFrame tipoflujoefectivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoflujoefectivoBeanSwingJInternalFrame.jTtoolBarTipoFlujoEfectivo.setBorder(borderResaltar);
		
		this.resaltaridTipoFlujoEfectivo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoFlujoEfectivo() {
		return this.resaltaridTipoFlujoEfectivo;
	}

	public void setResaltaridTipoFlujoEfectivo(Border borderResaltar) {
		this.resaltaridTipoFlujoEfectivo= borderResaltar;
	}

	public Boolean getMostraridTipoFlujoEfectivo() {
		return this.mostraridTipoFlujoEfectivo;
	}

	public void setMostraridTipoFlujoEfectivo(Boolean mostraridTipoFlujoEfectivo) {
		this.mostraridTipoFlujoEfectivo= mostraridTipoFlujoEfectivo;
	}

	public Boolean getActivaridTipoFlujoEfectivo() {
		return this.activaridTipoFlujoEfectivo;
	}

	public void setActivaridTipoFlujoEfectivo(Boolean activaridTipoFlujoEfectivo) {
		this.activaridTipoFlujoEfectivo= activaridTipoFlujoEfectivo;
	}

	public Border setResaltarid_empresaTipoFlujoEfectivo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFlujoEfectivoBeanSwingJInternalFrame tipoflujoefectivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoflujoefectivoBeanSwingJInternalFrame.jTtoolBarTipoFlujoEfectivo.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoFlujoEfectivo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoFlujoEfectivo() {
		return this.resaltarid_empresaTipoFlujoEfectivo;
	}

	public void setResaltarid_empresaTipoFlujoEfectivo(Border borderResaltar) {
		this.resaltarid_empresaTipoFlujoEfectivo= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoFlujoEfectivo() {
		return this.mostrarid_empresaTipoFlujoEfectivo;
	}

	public void setMostrarid_empresaTipoFlujoEfectivo(Boolean mostrarid_empresaTipoFlujoEfectivo) {
		this.mostrarid_empresaTipoFlujoEfectivo= mostrarid_empresaTipoFlujoEfectivo;
	}

	public Boolean getActivarid_empresaTipoFlujoEfectivo() {
		return this.activarid_empresaTipoFlujoEfectivo;
	}

	public void setActivarid_empresaTipoFlujoEfectivo(Boolean activarid_empresaTipoFlujoEfectivo) {
		this.activarid_empresaTipoFlujoEfectivo= activarid_empresaTipoFlujoEfectivo;
	}

	public Boolean getCargarid_empresaTipoFlujoEfectivo() {
		return this.cargarid_empresaTipoFlujoEfectivo;
	}

	public void setCargarid_empresaTipoFlujoEfectivo(Boolean cargarid_empresaTipoFlujoEfectivo) {
		this.cargarid_empresaTipoFlujoEfectivo= cargarid_empresaTipoFlujoEfectivo;
	}

	public Border setResaltarnombreTipoFlujoEfectivo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFlujoEfectivoBeanSwingJInternalFrame tipoflujoefectivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoflujoefectivoBeanSwingJInternalFrame.jTtoolBarTipoFlujoEfectivo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoFlujoEfectivo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoFlujoEfectivo() {
		return this.resaltarnombreTipoFlujoEfectivo;
	}

	public void setResaltarnombreTipoFlujoEfectivo(Border borderResaltar) {
		this.resaltarnombreTipoFlujoEfectivo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoFlujoEfectivo() {
		return this.mostrarnombreTipoFlujoEfectivo;
	}

	public void setMostrarnombreTipoFlujoEfectivo(Boolean mostrarnombreTipoFlujoEfectivo) {
		this.mostrarnombreTipoFlujoEfectivo= mostrarnombreTipoFlujoEfectivo;
	}

	public Boolean getActivarnombreTipoFlujoEfectivo() {
		return this.activarnombreTipoFlujoEfectivo;
	}

	public void setActivarnombreTipoFlujoEfectivo(Boolean activarnombreTipoFlujoEfectivo) {
		this.activarnombreTipoFlujoEfectivo= activarnombreTipoFlujoEfectivo;
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
		
		
		this.setMostraridTipoFlujoEfectivo(esInicial);
		this.setMostrarid_empresaTipoFlujoEfectivo(esInicial);
		this.setMostrarnombreTipoFlujoEfectivo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFlujoEfectivoConstantesFunciones.ID)) {
				this.setMostraridTipoFlujoEfectivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFlujoEfectivoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoFlujoEfectivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFlujoEfectivoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoFlujoEfectivo(esAsigna);
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
		
		
		this.setActivaridTipoFlujoEfectivo(esInicial);
		this.setActivarid_empresaTipoFlujoEfectivo(esInicial);
		this.setActivarnombreTipoFlujoEfectivo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFlujoEfectivoConstantesFunciones.ID)) {
				this.setActivaridTipoFlujoEfectivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFlujoEfectivoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoFlujoEfectivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFlujoEfectivoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoFlujoEfectivo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFlujoEfectivoBeanSwingJInternalFrame tipoflujoefectivoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoFlujoEfectivo(esInicial);
		this.setResaltarid_empresaTipoFlujoEfectivo(esInicial);
		this.setResaltarnombreTipoFlujoEfectivo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFlujoEfectivoConstantesFunciones.ID)) {
				this.setResaltaridTipoFlujoEfectivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFlujoEfectivoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoFlujoEfectivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFlujoEfectivoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoFlujoEfectivo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCuentaContableTipoFlujoEfectivo=null;

	public Border getResaltarCuentaContableTipoFlujoEfectivo() {
		return this.resaltarCuentaContableTipoFlujoEfectivo;
	}

	public void setResaltarCuentaContableTipoFlujoEfectivo(Border borderResaltarCuentaContable) {
		if(borderResaltarCuentaContable!=null) {
			this.resaltarCuentaContableTipoFlujoEfectivo= borderResaltarCuentaContable;
		}
	}

	public Border setResaltarCuentaContableTipoFlujoEfectivo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFlujoEfectivoBeanSwingJInternalFrame tipoflujoefectivoBeanSwingJInternalFrame*/) {
		Border borderResaltarCuentaContable=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoflujoefectivoBeanSwingJInternalFrame.jTtoolBarTipoFlujoEfectivo.setBorder(borderResaltarCuentaContable);
			
		this.resaltarCuentaContableTipoFlujoEfectivo= borderResaltarCuentaContable;

		 return borderResaltarCuentaContable;
	}



	public Boolean mostrarCuentaContableTipoFlujoEfectivo=true;

	public Boolean getMostrarCuentaContableTipoFlujoEfectivo() {
		return this.mostrarCuentaContableTipoFlujoEfectivo;
	}

	public void setMostrarCuentaContableTipoFlujoEfectivo(Boolean visibilidadResaltarCuentaContable) {
		this.mostrarCuentaContableTipoFlujoEfectivo= visibilidadResaltarCuentaContable;
	}



	public Boolean activarCuentaContableTipoFlujoEfectivo=true;

	public Boolean gethabilitarResaltarCuentaContableTipoFlujoEfectivo() {
		return this.activarCuentaContableTipoFlujoEfectivo;
	}

	public void setActivarCuentaContableTipoFlujoEfectivo(Boolean habilitarResaltarCuentaContable) {
		this.activarCuentaContableTipoFlujoEfectivo= habilitarResaltarCuentaContable;
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

		this.setMostrarCuentaContableTipoFlujoEfectivo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaContable.class)) {
				this.setMostrarCuentaContableTipoFlujoEfectivo(esAsigna);
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

		this.setActivarCuentaContableTipoFlujoEfectivo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaContable.class)) {
				this.setActivarCuentaContableTipoFlujoEfectivo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFlujoEfectivoBeanSwingJInternalFrame tipoflujoefectivoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCuentaContableTipoFlujoEfectivo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaContable.class)) {
				this.setResaltarCuentaContableTipoFlujoEfectivo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreTipoFlujoEfectivo=true;

	public Boolean getMostrarBusquedaPorNombreTipoFlujoEfectivo() {
		return this.mostrarBusquedaPorNombreTipoFlujoEfectivo;
	}

	public void setMostrarBusquedaPorNombreTipoFlujoEfectivo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoFlujoEfectivo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoFlujoEfectivo=true;

	public Boolean getMostrarFK_IdEmpresaTipoFlujoEfectivo() {
		return this.mostrarFK_IdEmpresaTipoFlujoEfectivo;
	}

	public void setMostrarFK_IdEmpresaTipoFlujoEfectivo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoFlujoEfectivo= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoFlujoEfectivo=true;

	public Boolean getActivarBusquedaPorNombreTipoFlujoEfectivo() {
		return this.activarBusquedaPorNombreTipoFlujoEfectivo;
	}

	public void setActivarBusquedaPorNombreTipoFlujoEfectivo(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoFlujoEfectivo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoFlujoEfectivo=true;

	public Boolean getActivarFK_IdEmpresaTipoFlujoEfectivo() {
		return this.activarFK_IdEmpresaTipoFlujoEfectivo;
	}

	public void setActivarFK_IdEmpresaTipoFlujoEfectivo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoFlujoEfectivo= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoFlujoEfectivo=null;

	public Border getResaltarBusquedaPorNombreTipoFlujoEfectivo() {
		return this.resaltarBusquedaPorNombreTipoFlujoEfectivo;
	}

	public void setResaltarBusquedaPorNombreTipoFlujoEfectivo(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoFlujoEfectivo= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoFlujoEfectivo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFlujoEfectivoBeanSwingJInternalFrame tipoflujoefectivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoFlujoEfectivo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoFlujoEfectivo=null;

	public Border getResaltarFK_IdEmpresaTipoFlujoEfectivo() {
		return this.resaltarFK_IdEmpresaTipoFlujoEfectivo;
	}

	public void setResaltarFK_IdEmpresaTipoFlujoEfectivo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoFlujoEfectivo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoFlujoEfectivo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFlujoEfectivoBeanSwingJInternalFrame tipoflujoefectivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoFlujoEfectivo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}