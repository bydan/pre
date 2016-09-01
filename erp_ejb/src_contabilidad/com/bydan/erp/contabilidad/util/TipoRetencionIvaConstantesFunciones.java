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


import com.bydan.erp.contabilidad.util.TipoRetencionIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoRetencionIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoRetencionIvaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.sris.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoRetencionIvaConstantesFunciones extends TipoRetencionIvaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoRetencionIva";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoRetencionIva"+TipoRetencionIvaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoRetencionIvaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoRetencionIvaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoRetencionIvaConstantesFunciones.SCHEMA+"_"+TipoRetencionIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoRetencionIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoRetencionIvaConstantesFunciones.SCHEMA+"_"+TipoRetencionIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoRetencionIvaConstantesFunciones.SCHEMA+"_"+TipoRetencionIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoRetencionIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoRetencionIvaConstantesFunciones.SCHEMA+"_"+TipoRetencionIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRetencionIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRetencionIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRetencionIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRetencionIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRetencionIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRetencionIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoRetencionIvaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoRetencionIvaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoRetencionIvaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoRetencionIvaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Retencion Ivas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Retencion Iva";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Retencion Iva";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoRetencionIva";
	public static final String OBJECTNAME="tiporetencioniva";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_retencion_iva";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiporetencioniva from "+TipoRetencionIvaConstantesFunciones.SPERSISTENCENAME+" tiporetencioniva";
	public static String QUERYSELECTNATIVE="select "+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME+".id,"+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME+".version_row,"+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME+".codigo,"+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME+".nombre from "+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME;//+" as "+TipoRetencionIvaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoRetencionIvaConstantesFuncionesAdditional tiporetencionivaConstantesFuncionesAdditional=null;
	
	public TipoRetencionIvaConstantesFuncionesAdditional getTipoRetencionIvaConstantesFuncionesAdditional() {
		return this.tiporetencionivaConstantesFuncionesAdditional;
	}
	
	public void setTipoRetencionIvaConstantesFuncionesAdditional(TipoRetencionIvaConstantesFuncionesAdditional tiporetencionivaConstantesFuncionesAdditional) {
		try {
			this.tiporetencionivaConstantesFuncionesAdditional=tiporetencionivaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoRetencionIvaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoRetencionIvaConstantesFunciones.CODIGO)) {sLabelColumna=TipoRetencionIvaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoRetencionIvaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoRetencionIvaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoRetencionIvaDescripcion(TipoRetencionIva tiporetencioniva) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiporetencioniva !=null/* && tiporetencioniva.getId()!=0*/) {
			if(tiporetencioniva.getId()!=null) {
				sDescripcion=tiporetencioniva.getId().toString();
			}//tiporetencionivatiporetencioniva.getId().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoRetencionIvaDescripcionDetallado(TipoRetencionIva tiporetencioniva) {
		String sDescripcion="";
			
		sDescripcion+=TipoRetencionIvaConstantesFunciones.ID+"=";
		sDescripcion+=tiporetencioniva.getId().toString()+",";
		sDescripcion+=TipoRetencionIvaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiporetencioniva.getVersionRow().toString()+",";
		sDescripcion+=TipoRetencionIvaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiporetencioniva.getcodigo()+",";
		sDescripcion+=TipoRetencionIvaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiporetencioniva.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoRetencionIvaDescripcion(TipoRetencionIva tiporetencioniva,String sValor) throws Exception {			
		if(tiporetencioniva !=null) {
			;//tiporetencionivatiporetencioniva.getId().toString().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoRetencionIva(TipoRetencionIva tiporetencioniva,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiporetencioniva.setcodigo(tiporetencioniva.getcodigo().trim());
		tiporetencioniva.setnombre(tiporetencioniva.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoRetencionIvas(List<TipoRetencionIva> tiporetencionivas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoRetencionIva tiporetencioniva: tiporetencionivas) {
			tiporetencioniva.setcodigo(tiporetencioniva.getcodigo().trim());
			tiporetencioniva.setnombre(tiporetencioniva.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRetencionIva(TipoRetencionIva tiporetencioniva,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiporetencioniva.getConCambioAuxiliar()) {
			tiporetencioniva.setIsDeleted(tiporetencioniva.getIsDeletedAuxiliar());	
			tiporetencioniva.setIsNew(tiporetencioniva.getIsNewAuxiliar());	
			tiporetencioniva.setIsChanged(tiporetencioniva.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiporetencioniva.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiporetencioniva.setIsDeletedAuxiliar(false);	
			tiporetencioniva.setIsNewAuxiliar(false);	
			tiporetencioniva.setIsChangedAuxiliar(false);
			
			tiporetencioniva.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRetencionIvas(List<TipoRetencionIva> tiporetencionivas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoRetencionIva tiporetencioniva : tiporetencionivas) {
			if(conAsignarBase && tiporetencioniva.getConCambioAuxiliar()) {
				tiporetencioniva.setIsDeleted(tiporetencioniva.getIsDeletedAuxiliar());	
				tiporetencioniva.setIsNew(tiporetencioniva.getIsNewAuxiliar());	
				tiporetencioniva.setIsChanged(tiporetencioniva.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiporetencioniva.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiporetencioniva.setIsDeletedAuxiliar(false);	
				tiporetencioniva.setIsNewAuxiliar(false);	
				tiporetencioniva.setIsChangedAuxiliar(false);
				
				tiporetencioniva.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoRetencionIva(TipoRetencionIva tiporetencioniva,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoRetencionIvas(List<TipoRetencionIva> tiporetencionivas,Boolean conEnteros) throws Exception  {
		
		for(TipoRetencionIva tiporetencioniva: tiporetencionivas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoRetencionIva(List<TipoRetencionIva> tiporetencionivas,TipoRetencionIva tiporetencionivaAux) throws Exception  {
		TipoRetencionIvaConstantesFunciones.InicializarValoresTipoRetencionIva(tiporetencionivaAux,true);
		
		for(TipoRetencionIva tiporetencioniva: tiporetencionivas) {
			if(tiporetencioniva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRetencionIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoRetencionIvaConstantesFunciones.getArrayColumnasGlobalesTipoRetencionIva(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRetencionIva(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoRetencionIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoRetencionIva> tiporetencionivas,TipoRetencionIva tiporetencioniva,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoRetencionIva tiporetencionivaAux: tiporetencionivas) {
			if(tiporetencionivaAux!=null && tiporetencioniva!=null) {
				if((tiporetencionivaAux.getId()==null && tiporetencioniva.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiporetencionivaAux.getId()!=null && tiporetencioniva.getId()!=null){
					if(tiporetencionivaAux.getId().equals(tiporetencioniva.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoRetencionIva(List<TipoRetencionIva> tiporetencionivas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoRetencionIva tiporetencioniva: tiporetencionivas) {			
			if(tiporetencioniva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoRetencionIva() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoRetencionIvaConstantesFunciones.LABEL_ID, TipoRetencionIvaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionIvaConstantesFunciones.LABEL_VERSIONROW, TipoRetencionIvaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionIvaConstantesFunciones.LABEL_CODIGO, TipoRetencionIvaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionIvaConstantesFunciones.LABEL_NOMBRE, TipoRetencionIvaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoRetencionIva() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionIvaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionIvaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionIvaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionIvaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRetencionIva() throws Exception  {
		return TipoRetencionIvaConstantesFunciones.getTiposSeleccionarTipoRetencionIva(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRetencionIva(Boolean conFk) throws Exception  {
		return TipoRetencionIvaConstantesFunciones.getTiposSeleccionarTipoRetencionIva(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRetencionIva(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionIvaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoRetencionIvaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionIvaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoRetencionIvaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoRetencionIva(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRetencionIva(TipoRetencionIva tiporetencionivaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRetencionIva(List<TipoRetencionIva> tiporetencionivasTemp) throws Exception {
		for(TipoRetencionIva tiporetencionivaAux:tiporetencionivasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRetencionIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoRetencionIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRetencionIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRetencionIvaConstantesFunciones.getClassesRelationshipsOfTipoRetencionIva(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRetencionIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Sri.class));
				classes.add(new Classe(TransaccionLocal.class));
				classes.add(new Classe(TarjetaCredito.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Sri.class)) {
						classes.add(new Classe(Sri.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TransaccionLocal.class)) {
						classes.add(new Classe(TransaccionLocal.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TarjetaCredito.class)) {
						classes.add(new Classe(TarjetaCredito.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRetencionIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRetencionIvaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoRetencionIva(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRetencionIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Sri.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sri.class)); continue;
					}

					if(TransaccionLocal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionLocal.class)); continue;
					}

					if(TarjetaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCredito.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Sri.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sri.class)); continue;
					}

					if(TransaccionLocal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionLocal.class)); continue;
					}

					if(TarjetaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCredito.class)); continue;
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
	public static void actualizarLista(TipoRetencionIva tiporetencioniva,List<TipoRetencionIva> tiporetencionivas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoRetencionIva tiporetencionivaEncontrado=null;
			
			for(TipoRetencionIva tiporetencionivaLocal:tiporetencionivas) {
				if(tiporetencionivaLocal.getId().equals(tiporetencioniva.getId())) {
					tiporetencionivaEncontrado=tiporetencionivaLocal;
					
					tiporetencionivaLocal.setIsChanged(tiporetencioniva.getIsChanged());
					tiporetencionivaLocal.setIsNew(tiporetencioniva.getIsNew());
					tiporetencionivaLocal.setIsDeleted(tiporetencioniva.getIsDeleted());
					
					tiporetencionivaLocal.setGeneralEntityOriginal(tiporetencioniva.getGeneralEntityOriginal());
					
					tiporetencionivaLocal.setId(tiporetencioniva.getId());	
					tiporetencionivaLocal.setVersionRow(tiporetencioniva.getVersionRow());	
					tiporetencionivaLocal.setcodigo(tiporetencioniva.getcodigo());	
					tiporetencionivaLocal.setnombre(tiporetencioniva.getnombre());	
					
					
					tiporetencionivaLocal.setTransaccionLocals(tiporetencioniva.getTransaccionLocals());
					tiporetencionivaLocal.setTarjetaCreditos(tiporetencioniva.getTarjetaCreditos());
					
					existe=true;
					break;
				}
			}
			
			if(!tiporetencioniva.getIsDeleted()) {
				if(!existe) {
					tiporetencionivas.add(tiporetencioniva);
				}
			} else {
				if(tiporetencionivaEncontrado!=null && permiteQuitar)  {
					tiporetencionivas.remove(tiporetencionivaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoRetencionIva tiporetencioniva,List<TipoRetencionIva> tiporetencionivas) throws Exception {
		try	{			
			for(TipoRetencionIva tiporetencionivaLocal:tiporetencionivas) {
				if(tiporetencionivaLocal.getId().equals(tiporetencioniva.getId())) {
					tiporetencionivaLocal.setIsSelected(tiporetencioniva.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoRetencionIva(List<TipoRetencionIva> tiporetencionivasAux) throws Exception {
		//this.tiporetencionivasAux=tiporetencionivasAux;
		
		for(TipoRetencionIva tiporetencionivaAux:tiporetencionivasAux) {
			if(tiporetencionivaAux.getIsChanged()) {
				tiporetencionivaAux.setIsChanged(false);
			}		
			
			if(tiporetencionivaAux.getIsNew()) {
				tiporetencionivaAux.setIsNew(false);
			}	
			
			if(tiporetencionivaAux.getIsDeleted()) {
				tiporetencionivaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoRetencionIva(TipoRetencionIva tiporetencionivaAux) throws Exception {
		//this.tiporetencionivaAux=tiporetencionivaAux;
		
			if(tiporetencionivaAux.getIsChanged()) {
				tiporetencionivaAux.setIsChanged(false);
			}		
			
			if(tiporetencionivaAux.getIsNew()) {
				tiporetencionivaAux.setIsNew(false);
			}	
			
			if(tiporetencionivaAux.getIsDeleted()) {
				tiporetencionivaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoRetencionIva tiporetencionivaAsignar,TipoRetencionIva tiporetencioniva) throws Exception {
		tiporetencionivaAsignar.setId(tiporetencioniva.getId());	
		tiporetencionivaAsignar.setVersionRow(tiporetencioniva.getVersionRow());	
		tiporetencionivaAsignar.setcodigo(tiporetencioniva.getcodigo());	
		tiporetencionivaAsignar.setnombre(tiporetencioniva.getnombre());	
	}
	
	public static void inicializarTipoRetencionIva(TipoRetencionIva tiporetencioniva) throws Exception {
		try {
				tiporetencioniva.setId(0L);	
					
				tiporetencioniva.setcodigo("");	
				tiporetencioniva.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoRetencionIva(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionIvaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionIvaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoRetencionIva(String sTipo,Row row,Workbook workbook,TipoRetencionIva tiporetencioniva,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencioniva.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencioniva.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoRetencionIva=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoRetencionIva() {
		return this.sFinalQueryTipoRetencionIva;
	}
	
	public void setsFinalQueryTipoRetencionIva(String sFinalQueryTipoRetencionIva) {
		this.sFinalQueryTipoRetencionIva= sFinalQueryTipoRetencionIva;
	}
	
	public Border resaltarSeleccionarTipoRetencionIva=null;
	
	public Border setResaltarSeleccionarTipoRetencionIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionIvaBeanSwingJInternalFrame tiporetencionivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiporetencionivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionIva.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoRetencionIva= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoRetencionIva() {
		return this.resaltarSeleccionarTipoRetencionIva;
	}
	
	public void setResaltarSeleccionarTipoRetencionIva(Border borderResaltarSeleccionarTipoRetencionIva) {
		this.resaltarSeleccionarTipoRetencionIva= borderResaltarSeleccionarTipoRetencionIva;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoRetencionIva=null;
	public Boolean mostraridTipoRetencionIva=true;
	public Boolean activaridTipoRetencionIva=true;

	public Border resaltarcodigoTipoRetencionIva=null;
	public Boolean mostrarcodigoTipoRetencionIva=true;
	public Boolean activarcodigoTipoRetencionIva=true;

	public Border resaltarnombreTipoRetencionIva=null;
	public Boolean mostrarnombreTipoRetencionIva=true;
	public Boolean activarnombreTipoRetencionIva=true;

	
	

	public Border setResaltaridTipoRetencionIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionIvaBeanSwingJInternalFrame tiporetencionivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionIva.setBorder(borderResaltar);
		
		this.resaltaridTipoRetencionIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoRetencionIva() {
		return this.resaltaridTipoRetencionIva;
	}

	public void setResaltaridTipoRetencionIva(Border borderResaltar) {
		this.resaltaridTipoRetencionIva= borderResaltar;
	}

	public Boolean getMostraridTipoRetencionIva() {
		return this.mostraridTipoRetencionIva;
	}

	public void setMostraridTipoRetencionIva(Boolean mostraridTipoRetencionIva) {
		this.mostraridTipoRetencionIva= mostraridTipoRetencionIva;
	}

	public Boolean getActivaridTipoRetencionIva() {
		return this.activaridTipoRetencionIva;
	}

	public void setActivaridTipoRetencionIva(Boolean activaridTipoRetencionIva) {
		this.activaridTipoRetencionIva= activaridTipoRetencionIva;
	}

	public Border setResaltarcodigoTipoRetencionIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionIvaBeanSwingJInternalFrame tiporetencionivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionIva.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoRetencionIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoRetencionIva() {
		return this.resaltarcodigoTipoRetencionIva;
	}

	public void setResaltarcodigoTipoRetencionIva(Border borderResaltar) {
		this.resaltarcodigoTipoRetencionIva= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoRetencionIva() {
		return this.mostrarcodigoTipoRetencionIva;
	}

	public void setMostrarcodigoTipoRetencionIva(Boolean mostrarcodigoTipoRetencionIva) {
		this.mostrarcodigoTipoRetencionIva= mostrarcodigoTipoRetencionIva;
	}

	public Boolean getActivarcodigoTipoRetencionIva() {
		return this.activarcodigoTipoRetencionIva;
	}

	public void setActivarcodigoTipoRetencionIva(Boolean activarcodigoTipoRetencionIva) {
		this.activarcodigoTipoRetencionIva= activarcodigoTipoRetencionIva;
	}

	public Border setResaltarnombreTipoRetencionIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionIvaBeanSwingJInternalFrame tiporetencionivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionIva.setBorder(borderResaltar);
		
		this.resaltarnombreTipoRetencionIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoRetencionIva() {
		return this.resaltarnombreTipoRetencionIva;
	}

	public void setResaltarnombreTipoRetencionIva(Border borderResaltar) {
		this.resaltarnombreTipoRetencionIva= borderResaltar;
	}

	public Boolean getMostrarnombreTipoRetencionIva() {
		return this.mostrarnombreTipoRetencionIva;
	}

	public void setMostrarnombreTipoRetencionIva(Boolean mostrarnombreTipoRetencionIva) {
		this.mostrarnombreTipoRetencionIva= mostrarnombreTipoRetencionIva;
	}

	public Boolean getActivarnombreTipoRetencionIva() {
		return this.activarnombreTipoRetencionIva;
	}

	public void setActivarnombreTipoRetencionIva(Boolean activarnombreTipoRetencionIva) {
		this.activarnombreTipoRetencionIva= activarnombreTipoRetencionIva;
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
		
		
		this.setMostraridTipoRetencionIva(esInicial);
		this.setMostrarcodigoTipoRetencionIva(esInicial);
		this.setMostrarnombreTipoRetencionIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRetencionIvaConstantesFunciones.ID)) {
				this.setMostraridTipoRetencionIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionIvaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoRetencionIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionIvaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoRetencionIva(esAsigna);
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
		
		
		this.setActivaridTipoRetencionIva(esInicial);
		this.setActivarcodigoTipoRetencionIva(esInicial);
		this.setActivarnombreTipoRetencionIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRetencionIvaConstantesFunciones.ID)) {
				this.setActivaridTipoRetencionIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionIvaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoRetencionIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionIvaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoRetencionIva(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRetencionIvaBeanSwingJInternalFrame tiporetencionivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoRetencionIva(esInicial);
		this.setResaltarcodigoTipoRetencionIva(esInicial);
		this.setResaltarnombreTipoRetencionIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRetencionIvaConstantesFunciones.ID)) {
				this.setResaltaridTipoRetencionIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionIvaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoRetencionIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionIvaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoRetencionIva(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTransaccionLocalTipoRetencionIva=null;

	public Border getResaltarTransaccionLocalTipoRetencionIva() {
		return this.resaltarTransaccionLocalTipoRetencionIva;
	}

	public void setResaltarTransaccionLocalTipoRetencionIva(Border borderResaltarTransaccionLocal) {
		if(borderResaltarTransaccionLocal!=null) {
			this.resaltarTransaccionLocalTipoRetencionIva= borderResaltarTransaccionLocal;
		}
	}

	public Border setResaltarTransaccionLocalTipoRetencionIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionIvaBeanSwingJInternalFrame tiporetencionivaBeanSwingJInternalFrame*/) {
		Border borderResaltarTransaccionLocal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiporetencionivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionIva.setBorder(borderResaltarTransaccionLocal);
			
		this.resaltarTransaccionLocalTipoRetencionIva= borderResaltarTransaccionLocal;

		 return borderResaltarTransaccionLocal;
	}



	public Boolean mostrarTransaccionLocalTipoRetencionIva=true;

	public Boolean getMostrarTransaccionLocalTipoRetencionIva() {
		return this.mostrarTransaccionLocalTipoRetencionIva;
	}

	public void setMostrarTransaccionLocalTipoRetencionIva(Boolean visibilidadResaltarTransaccionLocal) {
		this.mostrarTransaccionLocalTipoRetencionIva= visibilidadResaltarTransaccionLocal;
	}



	public Boolean activarTransaccionLocalTipoRetencionIva=true;

	public Boolean gethabilitarResaltarTransaccionLocalTipoRetencionIva() {
		return this.activarTransaccionLocalTipoRetencionIva;
	}

	public void setActivarTransaccionLocalTipoRetencionIva(Boolean habilitarResaltarTransaccionLocal) {
		this.activarTransaccionLocalTipoRetencionIva= habilitarResaltarTransaccionLocal;
	}


	public Border resaltarTarjetaCreditoTipoRetencionIva=null;

	public Border getResaltarTarjetaCreditoTipoRetencionIva() {
		return this.resaltarTarjetaCreditoTipoRetencionIva;
	}

	public void setResaltarTarjetaCreditoTipoRetencionIva(Border borderResaltarTarjetaCredito) {
		if(borderResaltarTarjetaCredito!=null) {
			this.resaltarTarjetaCreditoTipoRetencionIva= borderResaltarTarjetaCredito;
		}
	}

	public Border setResaltarTarjetaCreditoTipoRetencionIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionIvaBeanSwingJInternalFrame tiporetencionivaBeanSwingJInternalFrame*/) {
		Border borderResaltarTarjetaCredito=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiporetencionivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionIva.setBorder(borderResaltarTarjetaCredito);
			
		this.resaltarTarjetaCreditoTipoRetencionIva= borderResaltarTarjetaCredito;

		 return borderResaltarTarjetaCredito;
	}



	public Boolean mostrarTarjetaCreditoTipoRetencionIva=true;

	public Boolean getMostrarTarjetaCreditoTipoRetencionIva() {
		return this.mostrarTarjetaCreditoTipoRetencionIva;
	}

	public void setMostrarTarjetaCreditoTipoRetencionIva(Boolean visibilidadResaltarTarjetaCredito) {
		this.mostrarTarjetaCreditoTipoRetencionIva= visibilidadResaltarTarjetaCredito;
	}



	public Boolean activarTarjetaCreditoTipoRetencionIva=true;

	public Boolean gethabilitarResaltarTarjetaCreditoTipoRetencionIva() {
		return this.activarTarjetaCreditoTipoRetencionIva;
	}

	public void setActivarTarjetaCreditoTipoRetencionIva(Boolean habilitarResaltarTarjetaCredito) {
		this.activarTarjetaCreditoTipoRetencionIva= habilitarResaltarTarjetaCredito;
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

		this.setMostrarTransaccionLocalTipoRetencionIva(esInicial);
		this.setMostrarTarjetaCreditoTipoRetencionIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setMostrarTransaccionLocalTipoRetencionIva(esAsigna);
				continue;
			}

			if(clase.clas.equals(TarjetaCredito.class)) {
				this.setMostrarTarjetaCreditoTipoRetencionIva(esAsigna);
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

		this.setActivarTransaccionLocalTipoRetencionIva(esInicial);
		this.setActivarTarjetaCreditoTipoRetencionIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setActivarTransaccionLocalTipoRetencionIva(esAsigna);
				continue;
			}

			if(clase.clas.equals(TarjetaCredito.class)) {
				this.setActivarTarjetaCreditoTipoRetencionIva(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRetencionIvaBeanSwingJInternalFrame tiporetencionivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTransaccionLocalTipoRetencionIva(esInicial);
		this.setResaltarTarjetaCreditoTipoRetencionIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setResaltarTransaccionLocalTipoRetencionIva(esAsigna);
				continue;
			}

			if(clase.clas.equals(TarjetaCredito.class)) {
				this.setResaltarTarjetaCreditoTipoRetencionIva(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}