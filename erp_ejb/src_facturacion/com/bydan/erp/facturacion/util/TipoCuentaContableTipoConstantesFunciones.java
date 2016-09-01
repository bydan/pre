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


import com.bydan.erp.facturacion.util.TipoCuentaContableTipoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoCuentaContableTipoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoCuentaContableTipoParameterGeneral;

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
final public class TipoCuentaContableTipoConstantesFunciones extends TipoCuentaContableTipoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCuentaContableTipo";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCuentaContableTipo"+TipoCuentaContableTipoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCuentaContableTipoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCuentaContableTipoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCuentaContableTipoConstantesFunciones.SCHEMA+"_"+TipoCuentaContableTipoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCuentaContableTipoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCuentaContableTipoConstantesFunciones.SCHEMA+"_"+TipoCuentaContableTipoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCuentaContableTipoConstantesFunciones.SCHEMA+"_"+TipoCuentaContableTipoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCuentaContableTipoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCuentaContableTipoConstantesFunciones.SCHEMA+"_"+TipoCuentaContableTipoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaContableTipoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCuentaContableTipoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaContableTipoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaContableTipoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCuentaContableTipoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaContableTipoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCuentaContableTipoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCuentaContableTipoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCuentaContableTipoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCuentaContableTipoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Cuenta Contable Tipos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Cuenta Contable Tipo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Cuenta Contable Tipo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCuentaContableTipo";
	public static final String OBJECTNAME="tipocuentacontabletipo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_cuenta_contable_tipo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocuentacontabletipo from "+TipoCuentaContableTipoConstantesFunciones.SPERSISTENCENAME+" tipocuentacontabletipo";
	public static String QUERYSELECTNATIVE="select "+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME+".id,"+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME+".version_row,"+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME+".nombre from "+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME;//+" as "+TipoCuentaContableTipoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoCuentaContableTipoConstantesFuncionesAdditional tipocuentacontabletipoConstantesFuncionesAdditional=null;
	
	public TipoCuentaContableTipoConstantesFuncionesAdditional getTipoCuentaContableTipoConstantesFuncionesAdditional() {
		return this.tipocuentacontabletipoConstantesFuncionesAdditional;
	}
	
	public void setTipoCuentaContableTipoConstantesFuncionesAdditional(TipoCuentaContableTipoConstantesFuncionesAdditional tipocuentacontabletipoConstantesFuncionesAdditional) {
		try {
			this.tipocuentacontabletipoConstantesFuncionesAdditional=tipocuentacontabletipoConstantesFuncionesAdditional;
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
	
	public static String getTipoCuentaContableTipoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCuentaContableTipoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCuentaContableTipoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getTipoCuentaContableTipoDescripcion(TipoCuentaContableTipo tipocuentacontabletipo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocuentacontabletipo !=null/* && tipocuentacontabletipo.getId()!=0*/) {
			sDescripcion=tipocuentacontabletipo.getnombre();//tipocuentacontabletipotipocuentacontabletipo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCuentaContableTipoDescripcionDetallado(TipoCuentaContableTipo tipocuentacontabletipo) {
		String sDescripcion="";
			
		sDescripcion+=TipoCuentaContableTipoConstantesFunciones.ID+"=";
		sDescripcion+=tipocuentacontabletipo.getId().toString()+",";
		sDescripcion+=TipoCuentaContableTipoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocuentacontabletipo.getVersionRow().toString()+",";
		sDescripcion+=TipoCuentaContableTipoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocuentacontabletipo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCuentaContableTipoDescripcion(TipoCuentaContableTipo tipocuentacontabletipo,String sValor) throws Exception {			
		if(tipocuentacontabletipo !=null) {
			tipocuentacontabletipo.setnombre(sValor);//tipocuentacontabletipotipocuentacontabletipo.getId().toString();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorId")) {
			sNombreIndice="Tipo=  Por Id";
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

	public static String getDetalleIndiceBusquedaPorId(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

		return sDetalleIndice;
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCuentaContableTipo(TipoCuentaContableTipo tipocuentacontabletipo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocuentacontabletipo.setnombre(tipocuentacontabletipo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCuentaContableTipos(List<TipoCuentaContableTipo> tipocuentacontabletipos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCuentaContableTipo tipocuentacontabletipo: tipocuentacontabletipos) {
			tipocuentacontabletipo.setnombre(tipocuentacontabletipo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCuentaContableTipo(TipoCuentaContableTipo tipocuentacontabletipo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocuentacontabletipo.getConCambioAuxiliar()) {
			tipocuentacontabletipo.setIsDeleted(tipocuentacontabletipo.getIsDeletedAuxiliar());	
			tipocuentacontabletipo.setIsNew(tipocuentacontabletipo.getIsNewAuxiliar());	
			tipocuentacontabletipo.setIsChanged(tipocuentacontabletipo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocuentacontabletipo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocuentacontabletipo.setIsDeletedAuxiliar(false);	
			tipocuentacontabletipo.setIsNewAuxiliar(false);	
			tipocuentacontabletipo.setIsChangedAuxiliar(false);
			
			tipocuentacontabletipo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCuentaContableTipos(List<TipoCuentaContableTipo> tipocuentacontabletipos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCuentaContableTipo tipocuentacontabletipo : tipocuentacontabletipos) {
			if(conAsignarBase && tipocuentacontabletipo.getConCambioAuxiliar()) {
				tipocuentacontabletipo.setIsDeleted(tipocuentacontabletipo.getIsDeletedAuxiliar());	
				tipocuentacontabletipo.setIsNew(tipocuentacontabletipo.getIsNewAuxiliar());	
				tipocuentacontabletipo.setIsChanged(tipocuentacontabletipo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocuentacontabletipo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocuentacontabletipo.setIsDeletedAuxiliar(false);	
				tipocuentacontabletipo.setIsNewAuxiliar(false);	
				tipocuentacontabletipo.setIsChangedAuxiliar(false);
				
				tipocuentacontabletipo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCuentaContableTipo(TipoCuentaContableTipo tipocuentacontabletipo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCuentaContableTipos(List<TipoCuentaContableTipo> tipocuentacontabletipos,Boolean conEnteros) throws Exception  {
		
		for(TipoCuentaContableTipo tipocuentacontabletipo: tipocuentacontabletipos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCuentaContableTipo(List<TipoCuentaContableTipo> tipocuentacontabletipos,TipoCuentaContableTipo tipocuentacontabletipoAux) throws Exception  {
		TipoCuentaContableTipoConstantesFunciones.InicializarValoresTipoCuentaContableTipo(tipocuentacontabletipoAux,true);
		
		for(TipoCuentaContableTipo tipocuentacontabletipo: tipocuentacontabletipos) {
			if(tipocuentacontabletipo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCuentaContableTipo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCuentaContableTipoConstantesFunciones.getArrayColumnasGlobalesTipoCuentaContableTipo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCuentaContableTipo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCuentaContableTipo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCuentaContableTipo> tipocuentacontabletipos,TipoCuentaContableTipo tipocuentacontabletipo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCuentaContableTipo tipocuentacontabletipoAux: tipocuentacontabletipos) {
			if(tipocuentacontabletipoAux!=null && tipocuentacontabletipo!=null) {
				if((tipocuentacontabletipoAux.getId()==null && tipocuentacontabletipo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocuentacontabletipoAux.getId()!=null && tipocuentacontabletipo.getId()!=null){
					if(tipocuentacontabletipoAux.getId().equals(tipocuentacontabletipo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCuentaContableTipo(List<TipoCuentaContableTipo> tipocuentacontabletipos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCuentaContableTipo tipocuentacontabletipo: tipocuentacontabletipos) {			
			if(tipocuentacontabletipo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCuentaContableTipo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCuentaContableTipoConstantesFunciones.LABEL_ID, TipoCuentaContableTipoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuentaContableTipoConstantesFunciones.LABEL_VERSIONROW, TipoCuentaContableTipoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuentaContableTipoConstantesFunciones.LABEL_NOMBRE, TipoCuentaContableTipoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCuentaContableTipo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaContableTipoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaContableTipoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaContableTipoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCuentaContableTipo() throws Exception  {
		return TipoCuentaContableTipoConstantesFunciones.getTiposSeleccionarTipoCuentaContableTipo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCuentaContableTipo(Boolean conFk) throws Exception  {
		return TipoCuentaContableTipoConstantesFunciones.getTiposSeleccionarTipoCuentaContableTipo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCuentaContableTipo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCuentaContableTipoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCuentaContableTipoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCuentaContableTipo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCuentaContableTipo(TipoCuentaContableTipo tipocuentacontabletipoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCuentaContableTipo(List<TipoCuentaContableTipo> tipocuentacontabletiposTemp) throws Exception {
		for(TipoCuentaContableTipo tipocuentacontabletipoAux:tipocuentacontabletiposTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCuentaContableTipo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCuentaContableTipo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCuentaContableTipo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCuentaContableTipoConstantesFunciones.getClassesRelationshipsOfTipoCuentaContableTipo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCuentaContableTipo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CuentaContableTipo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContableTipo.class)) {
						classes.add(new Classe(CuentaContableTipo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCuentaContableTipo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCuentaContableTipoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCuentaContableTipo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCuentaContableTipo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaContableTipo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContableTipo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaContableTipo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContableTipo.class)); continue;
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
	public static void actualizarLista(TipoCuentaContableTipo tipocuentacontabletipo,List<TipoCuentaContableTipo> tipocuentacontabletipos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCuentaContableTipo tipocuentacontabletipoEncontrado=null;
			
			for(TipoCuentaContableTipo tipocuentacontabletipoLocal:tipocuentacontabletipos) {
				if(tipocuentacontabletipoLocal.getId().equals(tipocuentacontabletipo.getId())) {
					tipocuentacontabletipoEncontrado=tipocuentacontabletipoLocal;
					
					tipocuentacontabletipoLocal.setIsChanged(tipocuentacontabletipo.getIsChanged());
					tipocuentacontabletipoLocal.setIsNew(tipocuentacontabletipo.getIsNew());
					tipocuentacontabletipoLocal.setIsDeleted(tipocuentacontabletipo.getIsDeleted());
					
					tipocuentacontabletipoLocal.setGeneralEntityOriginal(tipocuentacontabletipo.getGeneralEntityOriginal());
					
					tipocuentacontabletipoLocal.setId(tipocuentacontabletipo.getId());	
					tipocuentacontabletipoLocal.setVersionRow(tipocuentacontabletipo.getVersionRow());	
					tipocuentacontabletipoLocal.setnombre(tipocuentacontabletipo.getnombre());	
					
					
					tipocuentacontabletipoLocal.setCuentaContableTipos(tipocuentacontabletipo.getCuentaContableTipos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipocuentacontabletipo.getIsDeleted()) {
				if(!existe) {
					tipocuentacontabletipos.add(tipocuentacontabletipo);
				}
			} else {
				if(tipocuentacontabletipoEncontrado!=null && permiteQuitar)  {
					tipocuentacontabletipos.remove(tipocuentacontabletipoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCuentaContableTipo tipocuentacontabletipo,List<TipoCuentaContableTipo> tipocuentacontabletipos) throws Exception {
		try	{			
			for(TipoCuentaContableTipo tipocuentacontabletipoLocal:tipocuentacontabletipos) {
				if(tipocuentacontabletipoLocal.getId().equals(tipocuentacontabletipo.getId())) {
					tipocuentacontabletipoLocal.setIsSelected(tipocuentacontabletipo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCuentaContableTipo(List<TipoCuentaContableTipo> tipocuentacontabletiposAux) throws Exception {
		//this.tipocuentacontabletiposAux=tipocuentacontabletiposAux;
		
		for(TipoCuentaContableTipo tipocuentacontabletipoAux:tipocuentacontabletiposAux) {
			if(tipocuentacontabletipoAux.getIsChanged()) {
				tipocuentacontabletipoAux.setIsChanged(false);
			}		
			
			if(tipocuentacontabletipoAux.getIsNew()) {
				tipocuentacontabletipoAux.setIsNew(false);
			}	
			
			if(tipocuentacontabletipoAux.getIsDeleted()) {
				tipocuentacontabletipoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCuentaContableTipo(TipoCuentaContableTipo tipocuentacontabletipoAux) throws Exception {
		//this.tipocuentacontabletipoAux=tipocuentacontabletipoAux;
		
			if(tipocuentacontabletipoAux.getIsChanged()) {
				tipocuentacontabletipoAux.setIsChanged(false);
			}		
			
			if(tipocuentacontabletipoAux.getIsNew()) {
				tipocuentacontabletipoAux.setIsNew(false);
			}	
			
			if(tipocuentacontabletipoAux.getIsDeleted()) {
				tipocuentacontabletipoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCuentaContableTipo tipocuentacontabletipoAsignar,TipoCuentaContableTipo tipocuentacontabletipo) throws Exception {
		tipocuentacontabletipoAsignar.setId(tipocuentacontabletipo.getId());	
		tipocuentacontabletipoAsignar.setVersionRow(tipocuentacontabletipo.getVersionRow());	
		tipocuentacontabletipoAsignar.setnombre(tipocuentacontabletipo.getnombre());	
	}
	
	public static void inicializarTipoCuentaContableTipo(TipoCuentaContableTipo tipocuentacontabletipo) throws Exception {
		try {
				tipocuentacontabletipo.setId(0L);	
					
				tipocuentacontabletipo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCuentaContableTipo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCuentaContableTipoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCuentaContableTipo(String sTipo,Row row,Workbook workbook,TipoCuentaContableTipo tipocuentacontabletipo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocuentacontabletipo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCuentaContableTipo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCuentaContableTipo() {
		return this.sFinalQueryTipoCuentaContableTipo;
	}
	
	public void setsFinalQueryTipoCuentaContableTipo(String sFinalQueryTipoCuentaContableTipo) {
		this.sFinalQueryTipoCuentaContableTipo= sFinalQueryTipoCuentaContableTipo;
	}
	
	public Border resaltarSeleccionarTipoCuentaContableTipo=null;
	
	public Border setResaltarSeleccionarTipoCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaContableTipoBeanSwingJInternalFrame tipocuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocuentacontabletipoBeanSwingJInternalFrame.jTtoolBarTipoCuentaContableTipo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCuentaContableTipo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCuentaContableTipo() {
		return this.resaltarSeleccionarTipoCuentaContableTipo;
	}
	
	public void setResaltarSeleccionarTipoCuentaContableTipo(Border borderResaltarSeleccionarTipoCuentaContableTipo) {
		this.resaltarSeleccionarTipoCuentaContableTipo= borderResaltarSeleccionarTipoCuentaContableTipo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCuentaContableTipo=null;
	public Boolean mostraridTipoCuentaContableTipo=true;
	public Boolean activaridTipoCuentaContableTipo=true;

	public Border resaltarnombreTipoCuentaContableTipo=null;
	public Boolean mostrarnombreTipoCuentaContableTipo=true;
	public Boolean activarnombreTipoCuentaContableTipo=true;

	
	

	public Border setResaltaridTipoCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaContableTipoBeanSwingJInternalFrame tipocuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuentacontabletipoBeanSwingJInternalFrame.jTtoolBarTipoCuentaContableTipo.setBorder(borderResaltar);
		
		this.resaltaridTipoCuentaContableTipo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCuentaContableTipo() {
		return this.resaltaridTipoCuentaContableTipo;
	}

	public void setResaltaridTipoCuentaContableTipo(Border borderResaltar) {
		this.resaltaridTipoCuentaContableTipo= borderResaltar;
	}

	public Boolean getMostraridTipoCuentaContableTipo() {
		return this.mostraridTipoCuentaContableTipo;
	}

	public void setMostraridTipoCuentaContableTipo(Boolean mostraridTipoCuentaContableTipo) {
		this.mostraridTipoCuentaContableTipo= mostraridTipoCuentaContableTipo;
	}

	public Boolean getActivaridTipoCuentaContableTipo() {
		return this.activaridTipoCuentaContableTipo;
	}

	public void setActivaridTipoCuentaContableTipo(Boolean activaridTipoCuentaContableTipo) {
		this.activaridTipoCuentaContableTipo= activaridTipoCuentaContableTipo;
	}

	public Border setResaltarnombreTipoCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaContableTipoBeanSwingJInternalFrame tipocuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuentacontabletipoBeanSwingJInternalFrame.jTtoolBarTipoCuentaContableTipo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCuentaContableTipo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCuentaContableTipo() {
		return this.resaltarnombreTipoCuentaContableTipo;
	}

	public void setResaltarnombreTipoCuentaContableTipo(Border borderResaltar) {
		this.resaltarnombreTipoCuentaContableTipo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCuentaContableTipo() {
		return this.mostrarnombreTipoCuentaContableTipo;
	}

	public void setMostrarnombreTipoCuentaContableTipo(Boolean mostrarnombreTipoCuentaContableTipo) {
		this.mostrarnombreTipoCuentaContableTipo= mostrarnombreTipoCuentaContableTipo;
	}

	public Boolean getActivarnombreTipoCuentaContableTipo() {
		return this.activarnombreTipoCuentaContableTipo;
	}

	public void setActivarnombreTipoCuentaContableTipo(Boolean activarnombreTipoCuentaContableTipo) {
		this.activarnombreTipoCuentaContableTipo= activarnombreTipoCuentaContableTipo;
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
		
		
		this.setMostraridTipoCuentaContableTipo(esInicial);
		this.setMostrarnombreTipoCuentaContableTipo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCuentaContableTipoConstantesFunciones.ID)) {
				this.setMostraridTipoCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaContableTipoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCuentaContableTipo(esAsigna);
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
		
		
		this.setActivaridTipoCuentaContableTipo(esInicial);
		this.setActivarnombreTipoCuentaContableTipo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCuentaContableTipoConstantesFunciones.ID)) {
				this.setActivaridTipoCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaContableTipoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCuentaContableTipo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCuentaContableTipoBeanSwingJInternalFrame tipocuentacontabletipoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCuentaContableTipo(esInicial);
		this.setResaltarnombreTipoCuentaContableTipo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCuentaContableTipoConstantesFunciones.ID)) {
				this.setResaltaridTipoCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaContableTipoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCuentaContableTipo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCuentaContableTipoTipoCuentaContableTipo=null;

	public Border getResaltarCuentaContableTipoTipoCuentaContableTipo() {
		return this.resaltarCuentaContableTipoTipoCuentaContableTipo;
	}

	public void setResaltarCuentaContableTipoTipoCuentaContableTipo(Border borderResaltarCuentaContableTipo) {
		if(borderResaltarCuentaContableTipo!=null) {
			this.resaltarCuentaContableTipoTipoCuentaContableTipo= borderResaltarCuentaContableTipo;
		}
	}

	public Border setResaltarCuentaContableTipoTipoCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaContableTipoBeanSwingJInternalFrame tipocuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltarCuentaContableTipo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocuentacontabletipoBeanSwingJInternalFrame.jTtoolBarTipoCuentaContableTipo.setBorder(borderResaltarCuentaContableTipo);
			
		this.resaltarCuentaContableTipoTipoCuentaContableTipo= borderResaltarCuentaContableTipo;

		 return borderResaltarCuentaContableTipo;
	}



	public Boolean mostrarCuentaContableTipoTipoCuentaContableTipo=true;

	public Boolean getMostrarCuentaContableTipoTipoCuentaContableTipo() {
		return this.mostrarCuentaContableTipoTipoCuentaContableTipo;
	}

	public void setMostrarCuentaContableTipoTipoCuentaContableTipo(Boolean visibilidadResaltarCuentaContableTipo) {
		this.mostrarCuentaContableTipoTipoCuentaContableTipo= visibilidadResaltarCuentaContableTipo;
	}



	public Boolean activarCuentaContableTipoTipoCuentaContableTipo=true;

	public Boolean gethabilitarResaltarCuentaContableTipoTipoCuentaContableTipo() {
		return this.activarCuentaContableTipoTipoCuentaContableTipo;
	}

	public void setActivarCuentaContableTipoTipoCuentaContableTipo(Boolean habilitarResaltarCuentaContableTipo) {
		this.activarCuentaContableTipoTipoCuentaContableTipo= habilitarResaltarCuentaContableTipo;
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

		this.setMostrarCuentaContableTipoTipoCuentaContableTipo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaContableTipo.class)) {
				this.setMostrarCuentaContableTipoTipoCuentaContableTipo(esAsigna);
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

		this.setActivarCuentaContableTipoTipoCuentaContableTipo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaContableTipo.class)) {
				this.setActivarCuentaContableTipoTipoCuentaContableTipo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCuentaContableTipoBeanSwingJInternalFrame tipocuentacontabletipoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCuentaContableTipoTipoCuentaContableTipo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaContableTipo.class)) {
				this.setResaltarCuentaContableTipoTipoCuentaContableTipo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdTipoCuentaContableTipo=true;

	public Boolean getMostrarBusquedaPorIdTipoCuentaContableTipo() {
		return this.mostrarBusquedaPorIdTipoCuentaContableTipo;
	}

	public void setMostrarBusquedaPorIdTipoCuentaContableTipo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdTipoCuentaContableTipo= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoCuentaContableTipo=true;

	public Boolean getMostrarBusquedaPorNombreTipoCuentaContableTipo() {
		return this.mostrarBusquedaPorNombreTipoCuentaContableTipo;
	}

	public void setMostrarBusquedaPorNombreTipoCuentaContableTipo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoCuentaContableTipo= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdTipoCuentaContableTipo=true;

	public Boolean getActivarBusquedaPorIdTipoCuentaContableTipo() {
		return this.activarBusquedaPorIdTipoCuentaContableTipo;
	}

	public void setActivarBusquedaPorIdTipoCuentaContableTipo(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdTipoCuentaContableTipo= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoCuentaContableTipo=true;

	public Boolean getActivarBusquedaPorNombreTipoCuentaContableTipo() {
		return this.activarBusquedaPorNombreTipoCuentaContableTipo;
	}

	public void setActivarBusquedaPorNombreTipoCuentaContableTipo(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoCuentaContableTipo= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdTipoCuentaContableTipo=null;

	public Border getResaltarBusquedaPorIdTipoCuentaContableTipo() {
		return this.resaltarBusquedaPorIdTipoCuentaContableTipo;
	}

	public void setResaltarBusquedaPorIdTipoCuentaContableTipo(Border borderResaltar) {
		this.resaltarBusquedaPorIdTipoCuentaContableTipo= borderResaltar;
	}

	public void setResaltarBusquedaPorIdTipoCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaContableTipoBeanSwingJInternalFrame tipocuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdTipoCuentaContableTipo= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoCuentaContableTipo=null;

	public Border getResaltarBusquedaPorNombreTipoCuentaContableTipo() {
		return this.resaltarBusquedaPorNombreTipoCuentaContableTipo;
	}

	public void setResaltarBusquedaPorNombreTipoCuentaContableTipo(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoCuentaContableTipo= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaContableTipoBeanSwingJInternalFrame tipocuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoCuentaContableTipo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}