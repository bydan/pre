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


import com.bydan.erp.facturacion.util.TipoGrupoFormaPagoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoGrupoFormaPagoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoGrupoFormaPagoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoGrupoFormaPagoConstantesFunciones extends TipoGrupoFormaPagoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoGrupoFormaPago";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoGrupoFormaPago"+TipoGrupoFormaPagoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoGrupoFormaPagoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoGrupoFormaPagoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"_"+TipoGrupoFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoGrupoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"_"+TipoGrupoFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"_"+TipoGrupoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoGrupoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"_"+TipoGrupoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGrupoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGrupoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoGrupoFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoGrupoFormaPagoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoGrupoFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoGrupoFormaPagoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Grupo Forma Pagos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Grupo Forma Pago";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Grupo Forma Pago";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoGrupoFormaPago";
	public static final String OBJECTNAME="tipogrupoformapago";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_grupo_forma_pago";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipogrupoformapago from "+TipoGrupoFormaPagoConstantesFunciones.SPERSISTENCENAME+" tipogrupoformapago";
	public static String QUERYSELECTNATIVE="select "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME+".id,"+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME+".version_row,"+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME+".nombre from "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME;//+" as "+TipoGrupoFormaPagoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoGrupoFormaPagoConstantesFuncionesAdditional tipogrupoformapagoConstantesFuncionesAdditional=null;
	
	public TipoGrupoFormaPagoConstantesFuncionesAdditional getTipoGrupoFormaPagoConstantesFuncionesAdditional() {
		return this.tipogrupoformapagoConstantesFuncionesAdditional;
	}
	
	public void setTipoGrupoFormaPagoConstantesFuncionesAdditional(TipoGrupoFormaPagoConstantesFuncionesAdditional tipogrupoformapagoConstantesFuncionesAdditional) {
		try {
			this.tipogrupoformapagoConstantesFuncionesAdditional=tipogrupoformapagoConstantesFuncionesAdditional;
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
	
	public static String getTipoGrupoFormaPagoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoGrupoFormaPagoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoGrupoFormaPagoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getTipoGrupoFormaPagoDescripcion(TipoGrupoFormaPago tipogrupoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipogrupoformapago !=null/* && tipogrupoformapago.getId()!=0*/) {
			sDescripcion=tipogrupoformapago.getnombre();//tipogrupoformapagotipogrupoformapago.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoGrupoFormaPagoDescripcionDetallado(TipoGrupoFormaPago tipogrupoformapago) {
		String sDescripcion="";
			
		sDescripcion+=TipoGrupoFormaPagoConstantesFunciones.ID+"=";
		sDescripcion+=tipogrupoformapago.getId().toString()+",";
		sDescripcion+=TipoGrupoFormaPagoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipogrupoformapago.getVersionRow().toString()+",";
		sDescripcion+=TipoGrupoFormaPagoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipogrupoformapago.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoGrupoFormaPagoDescripcion(TipoGrupoFormaPago tipogrupoformapago,String sValor) throws Exception {			
		if(tipogrupoformapago !=null) {
			tipogrupoformapago.setnombre(sValor);//tipogrupoformapagotipogrupoformapago.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoGrupoFormaPago(TipoGrupoFormaPago tipogrupoformapago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipogrupoformapago.setnombre(tipogrupoformapago.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoGrupoFormaPagos(List<TipoGrupoFormaPago> tipogrupoformapagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoGrupoFormaPago tipogrupoformapago: tipogrupoformapagos) {
			tipogrupoformapago.setnombre(tipogrupoformapago.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGrupoFormaPago(TipoGrupoFormaPago tipogrupoformapago,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipogrupoformapago.getConCambioAuxiliar()) {
			tipogrupoformapago.setIsDeleted(tipogrupoformapago.getIsDeletedAuxiliar());	
			tipogrupoformapago.setIsNew(tipogrupoformapago.getIsNewAuxiliar());	
			tipogrupoformapago.setIsChanged(tipogrupoformapago.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipogrupoformapago.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipogrupoformapago.setIsDeletedAuxiliar(false);	
			tipogrupoformapago.setIsNewAuxiliar(false);	
			tipogrupoformapago.setIsChangedAuxiliar(false);
			
			tipogrupoformapago.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGrupoFormaPagos(List<TipoGrupoFormaPago> tipogrupoformapagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoGrupoFormaPago tipogrupoformapago : tipogrupoformapagos) {
			if(conAsignarBase && tipogrupoformapago.getConCambioAuxiliar()) {
				tipogrupoformapago.setIsDeleted(tipogrupoformapago.getIsDeletedAuxiliar());	
				tipogrupoformapago.setIsNew(tipogrupoformapago.getIsNewAuxiliar());	
				tipogrupoformapago.setIsChanged(tipogrupoformapago.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipogrupoformapago.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipogrupoformapago.setIsDeletedAuxiliar(false);	
				tipogrupoformapago.setIsNewAuxiliar(false);	
				tipogrupoformapago.setIsChangedAuxiliar(false);
				
				tipogrupoformapago.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoGrupoFormaPago(TipoGrupoFormaPago tipogrupoformapago,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoGrupoFormaPagos(List<TipoGrupoFormaPago> tipogrupoformapagos,Boolean conEnteros) throws Exception  {
		
		for(TipoGrupoFormaPago tipogrupoformapago: tipogrupoformapagos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoGrupoFormaPago(List<TipoGrupoFormaPago> tipogrupoformapagos,TipoGrupoFormaPago tipogrupoformapagoAux) throws Exception  {
		TipoGrupoFormaPagoConstantesFunciones.InicializarValoresTipoGrupoFormaPago(tipogrupoformapagoAux,true);
		
		for(TipoGrupoFormaPago tipogrupoformapago: tipogrupoformapagos) {
			if(tipogrupoformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGrupoFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoGrupoFormaPagoConstantesFunciones.getArrayColumnasGlobalesTipoGrupoFormaPago(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGrupoFormaPago(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoGrupoFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoGrupoFormaPago> tipogrupoformapagos,TipoGrupoFormaPago tipogrupoformapago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoGrupoFormaPago tipogrupoformapagoAux: tipogrupoformapagos) {
			if(tipogrupoformapagoAux!=null && tipogrupoformapago!=null) {
				if((tipogrupoformapagoAux.getId()==null && tipogrupoformapago.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipogrupoformapagoAux.getId()!=null && tipogrupoformapago.getId()!=null){
					if(tipogrupoformapagoAux.getId().equals(tipogrupoformapago.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoGrupoFormaPago(List<TipoGrupoFormaPago> tipogrupoformapagos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoGrupoFormaPago tipogrupoformapago: tipogrupoformapagos) {			
			if(tipogrupoformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoGrupoFormaPago() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoGrupoFormaPagoConstantesFunciones.LABEL_ID, TipoGrupoFormaPagoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGrupoFormaPagoConstantesFunciones.LABEL_VERSIONROW, TipoGrupoFormaPagoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGrupoFormaPagoConstantesFunciones.LABEL_NOMBRE, TipoGrupoFormaPagoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoGrupoFormaPago() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoGrupoFormaPagoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGrupoFormaPagoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGrupoFormaPagoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGrupoFormaPago() throws Exception  {
		return TipoGrupoFormaPagoConstantesFunciones.getTiposSeleccionarTipoGrupoFormaPago(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGrupoFormaPago(Boolean conFk) throws Exception  {
		return TipoGrupoFormaPagoConstantesFunciones.getTiposSeleccionarTipoGrupoFormaPago(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGrupoFormaPago(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGrupoFormaPagoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoGrupoFormaPagoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoGrupoFormaPago(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGrupoFormaPago(TipoGrupoFormaPago tipogrupoformapagoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGrupoFormaPago(List<TipoGrupoFormaPago> tipogrupoformapagosTemp) throws Exception {
		for(TipoGrupoFormaPago tipogrupoformapagoAux:tipogrupoformapagosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGrupoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoGrupoFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGrupoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGrupoFormaPagoConstantesFunciones.getClassesRelationshipsOfTipoGrupoFormaPago(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGrupoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TipoFormaPago.class));
				classes.add(new Classe(DatoGeneralEmpleado.class));
				classes.add(new Classe(AnticipoCliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFormaPago.class)) {
						classes.add(new Classe(TipoFormaPago.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoGeneralEmpleado.class)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AnticipoCliente.class)) {
						classes.add(new Classe(AnticipoCliente.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGrupoFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGrupoFormaPagoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoGrupoFormaPago(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGrupoFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(AnticipoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AnticipoCliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(AnticipoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AnticipoCliente.class)); continue;
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
	public static void actualizarLista(TipoGrupoFormaPago tipogrupoformapago,List<TipoGrupoFormaPago> tipogrupoformapagos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoGrupoFormaPago tipogrupoformapagoEncontrado=null;
			
			for(TipoGrupoFormaPago tipogrupoformapagoLocal:tipogrupoformapagos) {
				if(tipogrupoformapagoLocal.getId().equals(tipogrupoformapago.getId())) {
					tipogrupoformapagoEncontrado=tipogrupoformapagoLocal;
					
					tipogrupoformapagoLocal.setIsChanged(tipogrupoformapago.getIsChanged());
					tipogrupoformapagoLocal.setIsNew(tipogrupoformapago.getIsNew());
					tipogrupoformapagoLocal.setIsDeleted(tipogrupoformapago.getIsDeleted());
					
					tipogrupoformapagoLocal.setGeneralEntityOriginal(tipogrupoformapago.getGeneralEntityOriginal());
					
					tipogrupoformapagoLocal.setId(tipogrupoformapago.getId());	
					tipogrupoformapagoLocal.setVersionRow(tipogrupoformapago.getVersionRow());	
					tipogrupoformapagoLocal.setnombre(tipogrupoformapago.getnombre());	
					
					
					tipogrupoformapagoLocal.setTipoFormaPagos(tipogrupoformapago.getTipoFormaPagos());
					tipogrupoformapagoLocal.setDatoGeneralEmpleados(tipogrupoformapago.getDatoGeneralEmpleados());
					tipogrupoformapagoLocal.setAnticipoClientes(tipogrupoformapago.getAnticipoClientes());
					
					existe=true;
					break;
				}
			}
			
			if(!tipogrupoformapago.getIsDeleted()) {
				if(!existe) {
					tipogrupoformapagos.add(tipogrupoformapago);
				}
			} else {
				if(tipogrupoformapagoEncontrado!=null && permiteQuitar)  {
					tipogrupoformapagos.remove(tipogrupoformapagoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoGrupoFormaPago tipogrupoformapago,List<TipoGrupoFormaPago> tipogrupoformapagos) throws Exception {
		try	{			
			for(TipoGrupoFormaPago tipogrupoformapagoLocal:tipogrupoformapagos) {
				if(tipogrupoformapagoLocal.getId().equals(tipogrupoformapago.getId())) {
					tipogrupoformapagoLocal.setIsSelected(tipogrupoformapago.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoGrupoFormaPago(List<TipoGrupoFormaPago> tipogrupoformapagosAux) throws Exception {
		//this.tipogrupoformapagosAux=tipogrupoformapagosAux;
		
		for(TipoGrupoFormaPago tipogrupoformapagoAux:tipogrupoformapagosAux) {
			if(tipogrupoformapagoAux.getIsChanged()) {
				tipogrupoformapagoAux.setIsChanged(false);
			}		
			
			if(tipogrupoformapagoAux.getIsNew()) {
				tipogrupoformapagoAux.setIsNew(false);
			}	
			
			if(tipogrupoformapagoAux.getIsDeleted()) {
				tipogrupoformapagoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoGrupoFormaPago(TipoGrupoFormaPago tipogrupoformapagoAux) throws Exception {
		//this.tipogrupoformapagoAux=tipogrupoformapagoAux;
		
			if(tipogrupoformapagoAux.getIsChanged()) {
				tipogrupoformapagoAux.setIsChanged(false);
			}		
			
			if(tipogrupoformapagoAux.getIsNew()) {
				tipogrupoformapagoAux.setIsNew(false);
			}	
			
			if(tipogrupoformapagoAux.getIsDeleted()) {
				tipogrupoformapagoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoGrupoFormaPago tipogrupoformapagoAsignar,TipoGrupoFormaPago tipogrupoformapago) throws Exception {
		tipogrupoformapagoAsignar.setId(tipogrupoformapago.getId());	
		tipogrupoformapagoAsignar.setVersionRow(tipogrupoformapago.getVersionRow());	
		tipogrupoformapagoAsignar.setnombre(tipogrupoformapago.getnombre());	
	}
	
	public static void inicializarTipoGrupoFormaPago(TipoGrupoFormaPago tipogrupoformapago) throws Exception {
		try {
				tipogrupoformapago.setId(0L);	
					
				tipogrupoformapago.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoGrupoFormaPago(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGrupoFormaPagoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoGrupoFormaPago(String sTipo,Row row,Workbook workbook,TipoGrupoFormaPago tipogrupoformapago,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogrupoformapago.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoGrupoFormaPago=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoGrupoFormaPago() {
		return this.sFinalQueryTipoGrupoFormaPago;
	}
	
	public void setsFinalQueryTipoGrupoFormaPago(String sFinalQueryTipoGrupoFormaPago) {
		this.sFinalQueryTipoGrupoFormaPago= sFinalQueryTipoGrupoFormaPago;
	}
	
	public Border resaltarSeleccionarTipoGrupoFormaPago=null;
	
	public Border setResaltarSeleccionarTipoGrupoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFormaPagoBeanSwingJInternalFrame tipogrupoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipogrupoformapagoBeanSwingJInternalFrame.jTtoolBarTipoGrupoFormaPago.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoGrupoFormaPago= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoGrupoFormaPago() {
		return this.resaltarSeleccionarTipoGrupoFormaPago;
	}
	
	public void setResaltarSeleccionarTipoGrupoFormaPago(Border borderResaltarSeleccionarTipoGrupoFormaPago) {
		this.resaltarSeleccionarTipoGrupoFormaPago= borderResaltarSeleccionarTipoGrupoFormaPago;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoGrupoFormaPago=null;
	public Boolean mostraridTipoGrupoFormaPago=true;
	public Boolean activaridTipoGrupoFormaPago=true;

	public Border resaltarnombreTipoGrupoFormaPago=null;
	public Boolean mostrarnombreTipoGrupoFormaPago=true;
	public Boolean activarnombreTipoGrupoFormaPago=true;

	
	

	public Border setResaltaridTipoGrupoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFormaPagoBeanSwingJInternalFrame tipogrupoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogrupoformapagoBeanSwingJInternalFrame.jTtoolBarTipoGrupoFormaPago.setBorder(borderResaltar);
		
		this.resaltaridTipoGrupoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoGrupoFormaPago() {
		return this.resaltaridTipoGrupoFormaPago;
	}

	public void setResaltaridTipoGrupoFormaPago(Border borderResaltar) {
		this.resaltaridTipoGrupoFormaPago= borderResaltar;
	}

	public Boolean getMostraridTipoGrupoFormaPago() {
		return this.mostraridTipoGrupoFormaPago;
	}

	public void setMostraridTipoGrupoFormaPago(Boolean mostraridTipoGrupoFormaPago) {
		this.mostraridTipoGrupoFormaPago= mostraridTipoGrupoFormaPago;
	}

	public Boolean getActivaridTipoGrupoFormaPago() {
		return this.activaridTipoGrupoFormaPago;
	}

	public void setActivaridTipoGrupoFormaPago(Boolean activaridTipoGrupoFormaPago) {
		this.activaridTipoGrupoFormaPago= activaridTipoGrupoFormaPago;
	}

	public Border setResaltarnombreTipoGrupoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFormaPagoBeanSwingJInternalFrame tipogrupoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogrupoformapagoBeanSwingJInternalFrame.jTtoolBarTipoGrupoFormaPago.setBorder(borderResaltar);
		
		this.resaltarnombreTipoGrupoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoGrupoFormaPago() {
		return this.resaltarnombreTipoGrupoFormaPago;
	}

	public void setResaltarnombreTipoGrupoFormaPago(Border borderResaltar) {
		this.resaltarnombreTipoGrupoFormaPago= borderResaltar;
	}

	public Boolean getMostrarnombreTipoGrupoFormaPago() {
		return this.mostrarnombreTipoGrupoFormaPago;
	}

	public void setMostrarnombreTipoGrupoFormaPago(Boolean mostrarnombreTipoGrupoFormaPago) {
		this.mostrarnombreTipoGrupoFormaPago= mostrarnombreTipoGrupoFormaPago;
	}

	public Boolean getActivarnombreTipoGrupoFormaPago() {
		return this.activarnombreTipoGrupoFormaPago;
	}

	public void setActivarnombreTipoGrupoFormaPago(Boolean activarnombreTipoGrupoFormaPago) {
		this.activarnombreTipoGrupoFormaPago= activarnombreTipoGrupoFormaPago;
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
		
		
		this.setMostraridTipoGrupoFormaPago(esInicial);
		this.setMostrarnombreTipoGrupoFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGrupoFormaPagoConstantesFunciones.ID)) {
				this.setMostraridTipoGrupoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoFormaPagoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoGrupoFormaPago(esAsigna);
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
		
		
		this.setActivaridTipoGrupoFormaPago(esInicial);
		this.setActivarnombreTipoGrupoFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGrupoFormaPagoConstantesFunciones.ID)) {
				this.setActivaridTipoGrupoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoFormaPagoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoGrupoFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGrupoFormaPagoBeanSwingJInternalFrame tipogrupoformapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoGrupoFormaPago(esInicial);
		this.setResaltarnombreTipoGrupoFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGrupoFormaPagoConstantesFunciones.ID)) {
				this.setResaltaridTipoGrupoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoFormaPagoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoGrupoFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTipoFormaPagoTipoGrupoFormaPago=null;

	public Border getResaltarTipoFormaPagoTipoGrupoFormaPago() {
		return this.resaltarTipoFormaPagoTipoGrupoFormaPago;
	}

	public void setResaltarTipoFormaPagoTipoGrupoFormaPago(Border borderResaltarTipoFormaPago) {
		if(borderResaltarTipoFormaPago!=null) {
			this.resaltarTipoFormaPagoTipoGrupoFormaPago= borderResaltarTipoFormaPago;
		}
	}

	public Border setResaltarTipoFormaPagoTipoGrupoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFormaPagoBeanSwingJInternalFrame tipogrupoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltarTipoFormaPago=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipogrupoformapagoBeanSwingJInternalFrame.jTtoolBarTipoGrupoFormaPago.setBorder(borderResaltarTipoFormaPago);
			
		this.resaltarTipoFormaPagoTipoGrupoFormaPago= borderResaltarTipoFormaPago;

		 return borderResaltarTipoFormaPago;
	}



	public Boolean mostrarTipoFormaPagoTipoGrupoFormaPago=true;

	public Boolean getMostrarTipoFormaPagoTipoGrupoFormaPago() {
		return this.mostrarTipoFormaPagoTipoGrupoFormaPago;
	}

	public void setMostrarTipoFormaPagoTipoGrupoFormaPago(Boolean visibilidadResaltarTipoFormaPago) {
		this.mostrarTipoFormaPagoTipoGrupoFormaPago= visibilidadResaltarTipoFormaPago;
	}



	public Boolean activarTipoFormaPagoTipoGrupoFormaPago=true;

	public Boolean gethabilitarResaltarTipoFormaPagoTipoGrupoFormaPago() {
		return this.activarTipoFormaPagoTipoGrupoFormaPago;
	}

	public void setActivarTipoFormaPagoTipoGrupoFormaPago(Boolean habilitarResaltarTipoFormaPago) {
		this.activarTipoFormaPagoTipoGrupoFormaPago= habilitarResaltarTipoFormaPago;
	}


	public Border resaltarDatoGeneralEmpleadoTipoGrupoFormaPago=null;

	public Border getResaltarDatoGeneralEmpleadoTipoGrupoFormaPago() {
		return this.resaltarDatoGeneralEmpleadoTipoGrupoFormaPago;
	}

	public void setResaltarDatoGeneralEmpleadoTipoGrupoFormaPago(Border borderResaltarDatoGeneralEmpleado) {
		if(borderResaltarDatoGeneralEmpleado!=null) {
			this.resaltarDatoGeneralEmpleadoTipoGrupoFormaPago= borderResaltarDatoGeneralEmpleado;
		}
	}

	public Border setResaltarDatoGeneralEmpleadoTipoGrupoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFormaPagoBeanSwingJInternalFrame tipogrupoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltarDatoGeneralEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipogrupoformapagoBeanSwingJInternalFrame.jTtoolBarTipoGrupoFormaPago.setBorder(borderResaltarDatoGeneralEmpleado);
			
		this.resaltarDatoGeneralEmpleadoTipoGrupoFormaPago= borderResaltarDatoGeneralEmpleado;

		 return borderResaltarDatoGeneralEmpleado;
	}



	public Boolean mostrarDatoGeneralEmpleadoTipoGrupoFormaPago=true;

	public Boolean getMostrarDatoGeneralEmpleadoTipoGrupoFormaPago() {
		return this.mostrarDatoGeneralEmpleadoTipoGrupoFormaPago;
	}

	public void setMostrarDatoGeneralEmpleadoTipoGrupoFormaPago(Boolean visibilidadResaltarDatoGeneralEmpleado) {
		this.mostrarDatoGeneralEmpleadoTipoGrupoFormaPago= visibilidadResaltarDatoGeneralEmpleado;
	}



	public Boolean activarDatoGeneralEmpleadoTipoGrupoFormaPago=true;

	public Boolean gethabilitarResaltarDatoGeneralEmpleadoTipoGrupoFormaPago() {
		return this.activarDatoGeneralEmpleadoTipoGrupoFormaPago;
	}

	public void setActivarDatoGeneralEmpleadoTipoGrupoFormaPago(Boolean habilitarResaltarDatoGeneralEmpleado) {
		this.activarDatoGeneralEmpleadoTipoGrupoFormaPago= habilitarResaltarDatoGeneralEmpleado;
	}


	public Border resaltarAnticipoClienteTipoGrupoFormaPago=null;

	public Border getResaltarAnticipoClienteTipoGrupoFormaPago() {
		return this.resaltarAnticipoClienteTipoGrupoFormaPago;
	}

	public void setResaltarAnticipoClienteTipoGrupoFormaPago(Border borderResaltarAnticipoCliente) {
		if(borderResaltarAnticipoCliente!=null) {
			this.resaltarAnticipoClienteTipoGrupoFormaPago= borderResaltarAnticipoCliente;
		}
	}

	public Border setResaltarAnticipoClienteTipoGrupoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFormaPagoBeanSwingJInternalFrame tipogrupoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltarAnticipoCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipogrupoformapagoBeanSwingJInternalFrame.jTtoolBarTipoGrupoFormaPago.setBorder(borderResaltarAnticipoCliente);
			
		this.resaltarAnticipoClienteTipoGrupoFormaPago= borderResaltarAnticipoCliente;

		 return borderResaltarAnticipoCliente;
	}



	public Boolean mostrarAnticipoClienteTipoGrupoFormaPago=true;

	public Boolean getMostrarAnticipoClienteTipoGrupoFormaPago() {
		return this.mostrarAnticipoClienteTipoGrupoFormaPago;
	}

	public void setMostrarAnticipoClienteTipoGrupoFormaPago(Boolean visibilidadResaltarAnticipoCliente) {
		this.mostrarAnticipoClienteTipoGrupoFormaPago= visibilidadResaltarAnticipoCliente;
	}



	public Boolean activarAnticipoClienteTipoGrupoFormaPago=true;

	public Boolean gethabilitarResaltarAnticipoClienteTipoGrupoFormaPago() {
		return this.activarAnticipoClienteTipoGrupoFormaPago;
	}

	public void setActivarAnticipoClienteTipoGrupoFormaPago(Boolean habilitarResaltarAnticipoCliente) {
		this.activarAnticipoClienteTipoGrupoFormaPago= habilitarResaltarAnticipoCliente;
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

		this.setMostrarTipoFormaPagoTipoGrupoFormaPago(esInicial);
		this.setMostrarDatoGeneralEmpleadoTipoGrupoFormaPago(esInicial);
		this.setMostrarAnticipoClienteTipoGrupoFormaPago(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TipoFormaPago.class)) {
				this.setMostrarTipoFormaPagoTipoGrupoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setMostrarDatoGeneralEmpleadoTipoGrupoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(AnticipoCliente.class)) {
				this.setMostrarAnticipoClienteTipoGrupoFormaPago(esAsigna);
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

		this.setActivarTipoFormaPagoTipoGrupoFormaPago(esInicial);
		this.setActivarDatoGeneralEmpleadoTipoGrupoFormaPago(esInicial);
		this.setActivarAnticipoClienteTipoGrupoFormaPago(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TipoFormaPago.class)) {
				this.setActivarTipoFormaPagoTipoGrupoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setActivarDatoGeneralEmpleadoTipoGrupoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(AnticipoCliente.class)) {
				this.setActivarAnticipoClienteTipoGrupoFormaPago(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGrupoFormaPagoBeanSwingJInternalFrame tipogrupoformapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTipoFormaPagoTipoGrupoFormaPago(esInicial);
		this.setResaltarDatoGeneralEmpleadoTipoGrupoFormaPago(esInicial);
		this.setResaltarAnticipoClienteTipoGrupoFormaPago(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TipoFormaPago.class)) {
				this.setResaltarTipoFormaPagoTipoGrupoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setResaltarDatoGeneralEmpleadoTipoGrupoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(AnticipoCliente.class)) {
				this.setResaltarAnticipoClienteTipoGrupoFormaPago(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdTipoGrupoFormaPago=true;

	public Boolean getMostrarBusquedaPorIdTipoGrupoFormaPago() {
		return this.mostrarBusquedaPorIdTipoGrupoFormaPago;
	}

	public void setMostrarBusquedaPorIdTipoGrupoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdTipoGrupoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoGrupoFormaPago=true;

	public Boolean getMostrarBusquedaPorNombreTipoGrupoFormaPago() {
		return this.mostrarBusquedaPorNombreTipoGrupoFormaPago;
	}

	public void setMostrarBusquedaPorNombreTipoGrupoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoGrupoFormaPago= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdTipoGrupoFormaPago=true;

	public Boolean getActivarBusquedaPorIdTipoGrupoFormaPago() {
		return this.activarBusquedaPorIdTipoGrupoFormaPago;
	}

	public void setActivarBusquedaPorIdTipoGrupoFormaPago(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdTipoGrupoFormaPago= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoGrupoFormaPago=true;

	public Boolean getActivarBusquedaPorNombreTipoGrupoFormaPago() {
		return this.activarBusquedaPorNombreTipoGrupoFormaPago;
	}

	public void setActivarBusquedaPorNombreTipoGrupoFormaPago(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoGrupoFormaPago= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdTipoGrupoFormaPago=null;

	public Border getResaltarBusquedaPorIdTipoGrupoFormaPago() {
		return this.resaltarBusquedaPorIdTipoGrupoFormaPago;
	}

	public void setResaltarBusquedaPorIdTipoGrupoFormaPago(Border borderResaltar) {
		this.resaltarBusquedaPorIdTipoGrupoFormaPago= borderResaltar;
	}

	public void setResaltarBusquedaPorIdTipoGrupoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFormaPagoBeanSwingJInternalFrame tipogrupoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdTipoGrupoFormaPago= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoGrupoFormaPago=null;

	public Border getResaltarBusquedaPorNombreTipoGrupoFormaPago() {
		return this.resaltarBusquedaPorNombreTipoGrupoFormaPago;
	}

	public void setResaltarBusquedaPorNombreTipoGrupoFormaPago(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoGrupoFormaPago= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoGrupoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFormaPagoBeanSwingJInternalFrame tipogrupoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoGrupoFormaPago= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}