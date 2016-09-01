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


import com.bydan.erp.facturacion.util.TipoNotaCreditoSoliConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoNotaCreditoSoliParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoNotaCreditoSoliParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoNotaCreditoSoliConstantesFunciones extends TipoNotaCreditoSoliConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoNotaCreditoSoli";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoNotaCreditoSoli"+TipoNotaCreditoSoliConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoNotaCreditoSoliHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoNotaCreditoSoliHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"_"+TipoNotaCreditoSoliConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoNotaCreditoSoliHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"_"+TipoNotaCreditoSoliConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"_"+TipoNotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoNotaCreditoSoliHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"_"+TipoNotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoNotaCreditoSoliHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoNotaCreditoSoliHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNotaCreditoSoliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoNotaCreditoSoliConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoNotaCreditoSoliConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoNotaCreditoSoliConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoNotaCreditoSoliConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Solicitud Nota Creditos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Solicitud Nota Credito";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Nota Credito Soli";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoNotaCreditoSoli";
	public static final String OBJECTNAME="tiponotacreditosoli";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_nota_credito_soli";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiponotacreditosoli from "+TipoNotaCreditoSoliConstantesFunciones.SPERSISTENCENAME+" tiponotacreditosoli";
	public static String QUERYSELECTNATIVE="select "+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME+".id,"+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME+".version_row,"+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME+".codigo,"+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME+".nombre from "+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME;//+" as "+TipoNotaCreditoSoliConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoNotaCreditoSoliConstantesFuncionesAdditional tiponotacreditosoliConstantesFuncionesAdditional=null;
	
	public TipoNotaCreditoSoliConstantesFuncionesAdditional getTipoNotaCreditoSoliConstantesFuncionesAdditional() {
		return this.tiponotacreditosoliConstantesFuncionesAdditional;
	}
	
	public void setTipoNotaCreditoSoliConstantesFuncionesAdditional(TipoNotaCreditoSoliConstantesFuncionesAdditional tiponotacreditosoliConstantesFuncionesAdditional) {
		try {
			this.tiponotacreditosoliConstantesFuncionesAdditional=tiponotacreditosoliConstantesFuncionesAdditional;
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
	
	public static String getTipoNotaCreditoSoliLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoNotaCreditoSoliConstantesFunciones.CODIGO)) {sLabelColumna=TipoNotaCreditoSoliConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoNotaCreditoSoliConstantesFunciones.NOMBRE)) {sLabelColumna=TipoNotaCreditoSoliConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoNotaCreditoSoliDescripcion(TipoNotaCreditoSoli tiponotacreditosoli) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiponotacreditosoli !=null/* && tiponotacreditosoli.getId()!=0*/) {
			sDescripcion=tiponotacreditosoli.getcodigo();//tiponotacreditosolitiponotacreditosoli.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoNotaCreditoSoliDescripcionDetallado(TipoNotaCreditoSoli tiponotacreditosoli) {
		String sDescripcion="";
			
		sDescripcion+=TipoNotaCreditoSoliConstantesFunciones.ID+"=";
		sDescripcion+=tiponotacreditosoli.getId().toString()+",";
		sDescripcion+=TipoNotaCreditoSoliConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiponotacreditosoli.getVersionRow().toString()+",";
		sDescripcion+=TipoNotaCreditoSoliConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiponotacreditosoli.getcodigo()+",";
		sDescripcion+=TipoNotaCreditoSoliConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiponotacreditosoli.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoNotaCreditoSoliDescripcion(TipoNotaCreditoSoli tiponotacreditosoli,String sValor) throws Exception {			
		if(tiponotacreditosoli !=null) {
			tiponotacreditosoli.setcodigo(sValor);;//tiponotacreditosolitiponotacreditosoli.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoNotaCreditoSoli(TipoNotaCreditoSoli tiponotacreditosoli,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiponotacreditosoli.setcodigo(tiponotacreditosoli.getcodigo().trim());
		tiponotacreditosoli.setnombre(tiponotacreditosoli.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoNotaCreditoSolis(List<TipoNotaCreditoSoli> tiponotacreditosolis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoNotaCreditoSoli tiponotacreditosoli: tiponotacreditosolis) {
			tiponotacreditosoli.setcodigo(tiponotacreditosoli.getcodigo().trim());
			tiponotacreditosoli.setnombre(tiponotacreditosoli.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoNotaCreditoSoli(TipoNotaCreditoSoli tiponotacreditosoli,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiponotacreditosoli.getConCambioAuxiliar()) {
			tiponotacreditosoli.setIsDeleted(tiponotacreditosoli.getIsDeletedAuxiliar());	
			tiponotacreditosoli.setIsNew(tiponotacreditosoli.getIsNewAuxiliar());	
			tiponotacreditosoli.setIsChanged(tiponotacreditosoli.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiponotacreditosoli.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiponotacreditosoli.setIsDeletedAuxiliar(false);	
			tiponotacreditosoli.setIsNewAuxiliar(false);	
			tiponotacreditosoli.setIsChangedAuxiliar(false);
			
			tiponotacreditosoli.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoNotaCreditoSolis(List<TipoNotaCreditoSoli> tiponotacreditosolis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoNotaCreditoSoli tiponotacreditosoli : tiponotacreditosolis) {
			if(conAsignarBase && tiponotacreditosoli.getConCambioAuxiliar()) {
				tiponotacreditosoli.setIsDeleted(tiponotacreditosoli.getIsDeletedAuxiliar());	
				tiponotacreditosoli.setIsNew(tiponotacreditosoli.getIsNewAuxiliar());	
				tiponotacreditosoli.setIsChanged(tiponotacreditosoli.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiponotacreditosoli.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiponotacreditosoli.setIsDeletedAuxiliar(false);	
				tiponotacreditosoli.setIsNewAuxiliar(false);	
				tiponotacreditosoli.setIsChangedAuxiliar(false);
				
				tiponotacreditosoli.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoNotaCreditoSoli(TipoNotaCreditoSoli tiponotacreditosoli,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoNotaCreditoSolis(List<TipoNotaCreditoSoli> tiponotacreditosolis,Boolean conEnteros) throws Exception  {
		
		for(TipoNotaCreditoSoli tiponotacreditosoli: tiponotacreditosolis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoNotaCreditoSoli(List<TipoNotaCreditoSoli> tiponotacreditosolis,TipoNotaCreditoSoli tiponotacreditosoliAux) throws Exception  {
		TipoNotaCreditoSoliConstantesFunciones.InicializarValoresTipoNotaCreditoSoli(tiponotacreditosoliAux,true);
		
		for(TipoNotaCreditoSoli tiponotacreditosoli: tiponotacreditosolis) {
			if(tiponotacreditosoli.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoNotaCreditoSoli(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoNotaCreditoSoliConstantesFunciones.getArrayColumnasGlobalesTipoNotaCreditoSoli(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoNotaCreditoSoli(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoNotaCreditoSoli(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoNotaCreditoSoli> tiponotacreditosolis,TipoNotaCreditoSoli tiponotacreditosoli,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoNotaCreditoSoli tiponotacreditosoliAux: tiponotacreditosolis) {
			if(tiponotacreditosoliAux!=null && tiponotacreditosoli!=null) {
				if((tiponotacreditosoliAux.getId()==null && tiponotacreditosoli.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiponotacreditosoliAux.getId()!=null && tiponotacreditosoli.getId()!=null){
					if(tiponotacreditosoliAux.getId().equals(tiponotacreditosoli.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoNotaCreditoSoli(List<TipoNotaCreditoSoli> tiponotacreditosolis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoNotaCreditoSoli tiponotacreditosoli: tiponotacreditosolis) {			
			if(tiponotacreditosoli.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoNotaCreditoSoli() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoNotaCreditoSoliConstantesFunciones.LABEL_ID, TipoNotaCreditoSoliConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoNotaCreditoSoliConstantesFunciones.LABEL_VERSIONROW, TipoNotaCreditoSoliConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoNotaCreditoSoliConstantesFunciones.LABEL_CODIGO, TipoNotaCreditoSoliConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoNotaCreditoSoliConstantesFunciones.LABEL_NOMBRE, TipoNotaCreditoSoliConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoNotaCreditoSoli() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoNotaCreditoSoliConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoNotaCreditoSoliConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoNotaCreditoSoliConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoNotaCreditoSoliConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoNotaCreditoSoli() throws Exception  {
		return TipoNotaCreditoSoliConstantesFunciones.getTiposSeleccionarTipoNotaCreditoSoli(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoNotaCreditoSoli(Boolean conFk) throws Exception  {
		return TipoNotaCreditoSoliConstantesFunciones.getTiposSeleccionarTipoNotaCreditoSoli(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoNotaCreditoSoli(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoNotaCreditoSoliConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoNotaCreditoSoliConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoNotaCreditoSoliConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoNotaCreditoSoliConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoNotaCreditoSoli(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(TipoNotaCreditoSoli tiponotacreditosoliAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(List<TipoNotaCreditoSoli> tiponotacreditosolisTemp) throws Exception {
		for(TipoNotaCreditoSoli tiponotacreditosoliAux:tiponotacreditosolisTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoNotaCreditoSoli(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoNotaCreditoSoli(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoNotaCreditoSoli(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoNotaCreditoSoliConstantesFunciones.getClassesRelationshipsOfTipoNotaCreditoSoli(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoNotaCreditoSoli(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(NotaCreditoSoli.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCreditoSoli.class)) {
						classes.add(new Classe(NotaCreditoSoli.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoNotaCreditoSoli(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoNotaCreditoSoliConstantesFunciones.getClassesRelationshipsFromStringsOfTipoNotaCreditoSoli(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoNotaCreditoSoli(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(NotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoSoli.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(NotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoSoli.class)); continue;
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
	public static void actualizarLista(TipoNotaCreditoSoli tiponotacreditosoli,List<TipoNotaCreditoSoli> tiponotacreditosolis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoNotaCreditoSoli tiponotacreditosoliEncontrado=null;
			
			for(TipoNotaCreditoSoli tiponotacreditosoliLocal:tiponotacreditosolis) {
				if(tiponotacreditosoliLocal.getId().equals(tiponotacreditosoli.getId())) {
					tiponotacreditosoliEncontrado=tiponotacreditosoliLocal;
					
					tiponotacreditosoliLocal.setIsChanged(tiponotacreditosoli.getIsChanged());
					tiponotacreditosoliLocal.setIsNew(tiponotacreditosoli.getIsNew());
					tiponotacreditosoliLocal.setIsDeleted(tiponotacreditosoli.getIsDeleted());
					
					tiponotacreditosoliLocal.setGeneralEntityOriginal(tiponotacreditosoli.getGeneralEntityOriginal());
					
					tiponotacreditosoliLocal.setId(tiponotacreditosoli.getId());	
					tiponotacreditosoliLocal.setVersionRow(tiponotacreditosoli.getVersionRow());	
					tiponotacreditosoliLocal.setcodigo(tiponotacreditosoli.getcodigo());	
					tiponotacreditosoliLocal.setnombre(tiponotacreditosoli.getnombre());	
					
					
					tiponotacreditosoliLocal.setNotaCreditoSolis(tiponotacreditosoli.getNotaCreditoSolis());
					
					existe=true;
					break;
				}
			}
			
			if(!tiponotacreditosoli.getIsDeleted()) {
				if(!existe) {
					tiponotacreditosolis.add(tiponotacreditosoli);
				}
			} else {
				if(tiponotacreditosoliEncontrado!=null && permiteQuitar)  {
					tiponotacreditosolis.remove(tiponotacreditosoliEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoNotaCreditoSoli tiponotacreditosoli,List<TipoNotaCreditoSoli> tiponotacreditosolis) throws Exception {
		try	{			
			for(TipoNotaCreditoSoli tiponotacreditosoliLocal:tiponotacreditosolis) {
				if(tiponotacreditosoliLocal.getId().equals(tiponotacreditosoli.getId())) {
					tiponotacreditosoliLocal.setIsSelected(tiponotacreditosoli.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoNotaCreditoSoli(List<TipoNotaCreditoSoli> tiponotacreditosolisAux) throws Exception {
		//this.tiponotacreditosolisAux=tiponotacreditosolisAux;
		
		for(TipoNotaCreditoSoli tiponotacreditosoliAux:tiponotacreditosolisAux) {
			if(tiponotacreditosoliAux.getIsChanged()) {
				tiponotacreditosoliAux.setIsChanged(false);
			}		
			
			if(tiponotacreditosoliAux.getIsNew()) {
				tiponotacreditosoliAux.setIsNew(false);
			}	
			
			if(tiponotacreditosoliAux.getIsDeleted()) {
				tiponotacreditosoliAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoNotaCreditoSoli(TipoNotaCreditoSoli tiponotacreditosoliAux) throws Exception {
		//this.tiponotacreditosoliAux=tiponotacreditosoliAux;
		
			if(tiponotacreditosoliAux.getIsChanged()) {
				tiponotacreditosoliAux.setIsChanged(false);
			}		
			
			if(tiponotacreditosoliAux.getIsNew()) {
				tiponotacreditosoliAux.setIsNew(false);
			}	
			
			if(tiponotacreditosoliAux.getIsDeleted()) {
				tiponotacreditosoliAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoNotaCreditoSoli tiponotacreditosoliAsignar,TipoNotaCreditoSoli tiponotacreditosoli) throws Exception {
		tiponotacreditosoliAsignar.setId(tiponotacreditosoli.getId());	
		tiponotacreditosoliAsignar.setVersionRow(tiponotacreditosoli.getVersionRow());	
		tiponotacreditosoliAsignar.setcodigo(tiponotacreditosoli.getcodigo());	
		tiponotacreditosoliAsignar.setnombre(tiponotacreditosoli.getnombre());	
	}
	
	public static void inicializarTipoNotaCreditoSoli(TipoNotaCreditoSoli tiponotacreditosoli) throws Exception {
		try {
				tiponotacreditosoli.setId(0L);	
					
				tiponotacreditosoli.setcodigo("");	
				tiponotacreditosoli.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoNotaCreditoSoli(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoNotaCreditoSoliConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoNotaCreditoSoliConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoNotaCreditoSoli(String sTipo,Row row,Workbook workbook,TipoNotaCreditoSoli tiponotacreditosoli,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiponotacreditosoli.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiponotacreditosoli.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoNotaCreditoSoli=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoNotaCreditoSoli() {
		return this.sFinalQueryTipoNotaCreditoSoli;
	}
	
	public void setsFinalQueryTipoNotaCreditoSoli(String sFinalQueryTipoNotaCreditoSoli) {
		this.sFinalQueryTipoNotaCreditoSoli= sFinalQueryTipoNotaCreditoSoli;
	}
	
	public Border resaltarSeleccionarTipoNotaCreditoSoli=null;
	
	public Border setResaltarSeleccionarTipoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNotaCreditoSoliBeanSwingJInternalFrame tiponotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiponotacreditosoliBeanSwingJInternalFrame.jTtoolBarTipoNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoNotaCreditoSoli= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoNotaCreditoSoli() {
		return this.resaltarSeleccionarTipoNotaCreditoSoli;
	}
	
	public void setResaltarSeleccionarTipoNotaCreditoSoli(Border borderResaltarSeleccionarTipoNotaCreditoSoli) {
		this.resaltarSeleccionarTipoNotaCreditoSoli= borderResaltarSeleccionarTipoNotaCreditoSoli;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoNotaCreditoSoli=null;
	public Boolean mostraridTipoNotaCreditoSoli=true;
	public Boolean activaridTipoNotaCreditoSoli=true;

	public Border resaltarcodigoTipoNotaCreditoSoli=null;
	public Boolean mostrarcodigoTipoNotaCreditoSoli=true;
	public Boolean activarcodigoTipoNotaCreditoSoli=true;

	public Border resaltarnombreTipoNotaCreditoSoli=null;
	public Boolean mostrarnombreTipoNotaCreditoSoli=true;
	public Boolean activarnombreTipoNotaCreditoSoli=true;

	
	

	public Border setResaltaridTipoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNotaCreditoSoliBeanSwingJInternalFrame tiponotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiponotacreditosoliBeanSwingJInternalFrame.jTtoolBarTipoNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltaridTipoNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoNotaCreditoSoli() {
		return this.resaltaridTipoNotaCreditoSoli;
	}

	public void setResaltaridTipoNotaCreditoSoli(Border borderResaltar) {
		this.resaltaridTipoNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostraridTipoNotaCreditoSoli() {
		return this.mostraridTipoNotaCreditoSoli;
	}

	public void setMostraridTipoNotaCreditoSoli(Boolean mostraridTipoNotaCreditoSoli) {
		this.mostraridTipoNotaCreditoSoli= mostraridTipoNotaCreditoSoli;
	}

	public Boolean getActivaridTipoNotaCreditoSoli() {
		return this.activaridTipoNotaCreditoSoli;
	}

	public void setActivaridTipoNotaCreditoSoli(Boolean activaridTipoNotaCreditoSoli) {
		this.activaridTipoNotaCreditoSoli= activaridTipoNotaCreditoSoli;
	}

	public Border setResaltarcodigoTipoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNotaCreditoSoliBeanSwingJInternalFrame tiponotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiponotacreditosoliBeanSwingJInternalFrame.jTtoolBarTipoNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoNotaCreditoSoli() {
		return this.resaltarcodigoTipoNotaCreditoSoli;
	}

	public void setResaltarcodigoTipoNotaCreditoSoli(Border borderResaltar) {
		this.resaltarcodigoTipoNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoNotaCreditoSoli() {
		return this.mostrarcodigoTipoNotaCreditoSoli;
	}

	public void setMostrarcodigoTipoNotaCreditoSoli(Boolean mostrarcodigoTipoNotaCreditoSoli) {
		this.mostrarcodigoTipoNotaCreditoSoli= mostrarcodigoTipoNotaCreditoSoli;
	}

	public Boolean getActivarcodigoTipoNotaCreditoSoli() {
		return this.activarcodigoTipoNotaCreditoSoli;
	}

	public void setActivarcodigoTipoNotaCreditoSoli(Boolean activarcodigoTipoNotaCreditoSoli) {
		this.activarcodigoTipoNotaCreditoSoli= activarcodigoTipoNotaCreditoSoli;
	}

	public Border setResaltarnombreTipoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNotaCreditoSoliBeanSwingJInternalFrame tiponotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiponotacreditosoliBeanSwingJInternalFrame.jTtoolBarTipoNotaCreditoSoli.setBorder(borderResaltar);
		
		this.resaltarnombreTipoNotaCreditoSoli= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoNotaCreditoSoli() {
		return this.resaltarnombreTipoNotaCreditoSoli;
	}

	public void setResaltarnombreTipoNotaCreditoSoli(Border borderResaltar) {
		this.resaltarnombreTipoNotaCreditoSoli= borderResaltar;
	}

	public Boolean getMostrarnombreTipoNotaCreditoSoli() {
		return this.mostrarnombreTipoNotaCreditoSoli;
	}

	public void setMostrarnombreTipoNotaCreditoSoli(Boolean mostrarnombreTipoNotaCreditoSoli) {
		this.mostrarnombreTipoNotaCreditoSoli= mostrarnombreTipoNotaCreditoSoli;
	}

	public Boolean getActivarnombreTipoNotaCreditoSoli() {
		return this.activarnombreTipoNotaCreditoSoli;
	}

	public void setActivarnombreTipoNotaCreditoSoli(Boolean activarnombreTipoNotaCreditoSoli) {
		this.activarnombreTipoNotaCreditoSoli= activarnombreTipoNotaCreditoSoli;
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
		
		
		this.setMostraridTipoNotaCreditoSoli(esInicial);
		this.setMostrarcodigoTipoNotaCreditoSoli(esInicial);
		this.setMostrarnombreTipoNotaCreditoSoli(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoNotaCreditoSoliConstantesFunciones.ID)) {
				this.setMostraridTipoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNotaCreditoSoliConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNotaCreditoSoliConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoNotaCreditoSoli(esAsigna);
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
		
		
		this.setActivaridTipoNotaCreditoSoli(esInicial);
		this.setActivarcodigoTipoNotaCreditoSoli(esInicial);
		this.setActivarnombreTipoNotaCreditoSoli(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoNotaCreditoSoliConstantesFunciones.ID)) {
				this.setActivaridTipoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNotaCreditoSoliConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNotaCreditoSoliConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoNotaCreditoSoli(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoNotaCreditoSoliBeanSwingJInternalFrame tiponotacreditosoliBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoNotaCreditoSoli(esInicial);
		this.setResaltarcodigoTipoNotaCreditoSoli(esInicial);
		this.setResaltarnombreTipoNotaCreditoSoli(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoNotaCreditoSoliConstantesFunciones.ID)) {
				this.setResaltaridTipoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNotaCreditoSoliConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoNotaCreditoSoli(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNotaCreditoSoliConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoNotaCreditoSoli(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarNotaCreditoSoliTipoNotaCreditoSoli=null;

	public Border getResaltarNotaCreditoSoliTipoNotaCreditoSoli() {
		return this.resaltarNotaCreditoSoliTipoNotaCreditoSoli;
	}

	public void setResaltarNotaCreditoSoliTipoNotaCreditoSoli(Border borderResaltarNotaCreditoSoli) {
		if(borderResaltarNotaCreditoSoli!=null) {
			this.resaltarNotaCreditoSoliTipoNotaCreditoSoli= borderResaltarNotaCreditoSoli;
		}
	}

	public Border setResaltarNotaCreditoSoliTipoNotaCreditoSoli(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNotaCreditoSoliBeanSwingJInternalFrame tiponotacreditosoliBeanSwingJInternalFrame*/) {
		Border borderResaltarNotaCreditoSoli=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiponotacreditosoliBeanSwingJInternalFrame.jTtoolBarTipoNotaCreditoSoli.setBorder(borderResaltarNotaCreditoSoli);
			
		this.resaltarNotaCreditoSoliTipoNotaCreditoSoli= borderResaltarNotaCreditoSoli;

		 return borderResaltarNotaCreditoSoli;
	}



	public Boolean mostrarNotaCreditoSoliTipoNotaCreditoSoli=true;

	public Boolean getMostrarNotaCreditoSoliTipoNotaCreditoSoli() {
		return this.mostrarNotaCreditoSoliTipoNotaCreditoSoli;
	}

	public void setMostrarNotaCreditoSoliTipoNotaCreditoSoli(Boolean visibilidadResaltarNotaCreditoSoli) {
		this.mostrarNotaCreditoSoliTipoNotaCreditoSoli= visibilidadResaltarNotaCreditoSoli;
	}



	public Boolean activarNotaCreditoSoliTipoNotaCreditoSoli=true;

	public Boolean gethabilitarResaltarNotaCreditoSoliTipoNotaCreditoSoli() {
		return this.activarNotaCreditoSoliTipoNotaCreditoSoli;
	}

	public void setActivarNotaCreditoSoliTipoNotaCreditoSoli(Boolean habilitarResaltarNotaCreditoSoli) {
		this.activarNotaCreditoSoliTipoNotaCreditoSoli= habilitarResaltarNotaCreditoSoli;
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

		this.setMostrarNotaCreditoSoliTipoNotaCreditoSoli(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setMostrarNotaCreditoSoliTipoNotaCreditoSoli(esAsigna);
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

		this.setActivarNotaCreditoSoliTipoNotaCreditoSoli(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setActivarNotaCreditoSoliTipoNotaCreditoSoli(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoNotaCreditoSoliBeanSwingJInternalFrame tiponotacreditosoliBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarNotaCreditoSoliTipoNotaCreditoSoli(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setResaltarNotaCreditoSoliTipoNotaCreditoSoli(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}