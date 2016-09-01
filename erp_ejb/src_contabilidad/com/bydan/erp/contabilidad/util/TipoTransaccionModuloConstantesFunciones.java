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


import com.bydan.erp.contabilidad.util.TipoTransaccionModuloConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoTransaccionModuloParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoTransaccionModuloParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.sris.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoTransaccionModuloConstantesFunciones extends TipoTransaccionModuloConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoTransaccionModulo";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoTransaccionModulo"+TipoTransaccionModuloConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoTransaccionModuloHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoTransaccionModuloHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoTransaccionModuloConstantesFunciones.SCHEMA+"_"+TipoTransaccionModuloConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoTransaccionModuloHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoTransaccionModuloConstantesFunciones.SCHEMA+"_"+TipoTransaccionModuloConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoTransaccionModuloConstantesFunciones.SCHEMA+"_"+TipoTransaccionModuloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoTransaccionModuloHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoTransaccionModuloConstantesFunciones.SCHEMA+"_"+TipoTransaccionModuloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTransaccionModuloConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTransaccionModuloHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTransaccionModuloConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTransaccionModuloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTransaccionModuloHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTransaccionModuloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoTransaccionModuloConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoTransaccionModuloConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoTransaccionModuloConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoTransaccionModuloConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Transaccion Modulos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Transaccion Modulo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Transaccion Modulo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoTransaccionModulo";
	public static final String OBJECTNAME="tipotransaccionmodulo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_transaccion_modulo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipotransaccionmodulo from "+TipoTransaccionModuloConstantesFunciones.SPERSISTENCENAME+" tipotransaccionmodulo";
	public static String QUERYSELECTNATIVE="select "+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+".id,"+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+".version_row,"+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+".id_modulo,"+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+".nombre,"+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME+".siglas from "+TipoTransaccionModuloConstantesFunciones.SCHEMA+"."+TipoTransaccionModuloConstantesFunciones.TABLENAME;//+" as "+TipoTransaccionModuloConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoTransaccionModuloConstantesFuncionesAdditional tipotransaccionmoduloConstantesFuncionesAdditional=null;
	
	public TipoTransaccionModuloConstantesFuncionesAdditional getTipoTransaccionModuloConstantesFuncionesAdditional() {
		return this.tipotransaccionmoduloConstantesFuncionesAdditional;
	}
	
	public void setTipoTransaccionModuloConstantesFuncionesAdditional(TipoTransaccionModuloConstantesFuncionesAdditional tipotransaccionmoduloConstantesFuncionesAdditional) {
		try {
			this.tipotransaccionmoduloConstantesFuncionesAdditional=tipotransaccionmoduloConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDMODULO= "id_modulo";
    public static final String NOMBRE= "nombre";
    public static final String SIGLAS= "siglas";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SIGLAS= "Siglas";
		public static final String LABEL_SIGLAS_LOWER= "Siglas";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIGLAS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIGLAS=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoTransaccionModuloLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoTransaccionModuloConstantesFunciones.IDMODULO)) {sLabelColumna=TipoTransaccionModuloConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(TipoTransaccionModuloConstantesFunciones.NOMBRE)) {sLabelColumna=TipoTransaccionModuloConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoTransaccionModuloConstantesFunciones.SIGLAS)) {sLabelColumna=TipoTransaccionModuloConstantesFunciones.LABEL_SIGLAS;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipotransaccionmodulo !=null/* && tipotransaccionmodulo.getId()!=0*/) {
			sDescripcion=tipotransaccionmodulo.getnombre();//tipotransaccionmodulotipotransaccionmodulo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoTransaccionModuloDescripcionDetallado(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion="";
			
		sDescripcion+=TipoTransaccionModuloConstantesFunciones.ID+"=";
		sDescripcion+=tipotransaccionmodulo.getId().toString()+",";
		sDescripcion+=TipoTransaccionModuloConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipotransaccionmodulo.getVersionRow().toString()+",";
		sDescripcion+=TipoTransaccionModuloConstantesFunciones.IDMODULO+"=";
		sDescripcion+=tipotransaccionmodulo.getid_modulo().toString()+",";
		sDescripcion+=TipoTransaccionModuloConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipotransaccionmodulo.getnombre()+",";
		sDescripcion+=TipoTransaccionModuloConstantesFunciones.SIGLAS+"=";
		sDescripcion+=tipotransaccionmodulo.getsiglas()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo,String sValor) throws Exception {			
		if(tipotransaccionmodulo !=null) {
			tipotransaccionmodulo.setnombre(sValor);//tipotransaccionmodulotipotransaccionmodulo.getId().toString();
		}		
	}
	
		

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdModuloPorNombre")) {
			sNombreIndice="Tipo=  Por Modulo Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("PorIdModuloPorNombre")) {
			sNombreIndice="Tipo=  Por Modulo Por Nombre";
		} else if(sNombreIndice.equals("PorIdPorIdModulo")) {
			sNombreIndice="Tipo=  Por Id Por Modulo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdModuloPorNombre(Long id_modulo,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdModuloPorNombre(Long id_modulo,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdPorIdModulo(Long id,Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();}
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoTransaccionModulo(TipoTransaccionModulo tipotransaccionmodulo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipotransaccionmodulo.setnombre(tipotransaccionmodulo.getnombre().trim());
		tipotransaccionmodulo.setsiglas(tipotransaccionmodulo.getsiglas().trim());
	}
	
	public static void quitarEspaciosTipoTransaccionModulos(List<TipoTransaccionModulo> tipotransaccionmodulos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoTransaccionModulo tipotransaccionmodulo: tipotransaccionmodulos) {
			tipotransaccionmodulo.setnombre(tipotransaccionmodulo.getnombre().trim());
			tipotransaccionmodulo.setsiglas(tipotransaccionmodulo.getsiglas().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTransaccionModulo(TipoTransaccionModulo tipotransaccionmodulo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipotransaccionmodulo.getConCambioAuxiliar()) {
			tipotransaccionmodulo.setIsDeleted(tipotransaccionmodulo.getIsDeletedAuxiliar());	
			tipotransaccionmodulo.setIsNew(tipotransaccionmodulo.getIsNewAuxiliar());	
			tipotransaccionmodulo.setIsChanged(tipotransaccionmodulo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipotransaccionmodulo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipotransaccionmodulo.setIsDeletedAuxiliar(false);	
			tipotransaccionmodulo.setIsNewAuxiliar(false);	
			tipotransaccionmodulo.setIsChangedAuxiliar(false);
			
			tipotransaccionmodulo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTransaccionModulos(List<TipoTransaccionModulo> tipotransaccionmodulos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoTransaccionModulo tipotransaccionmodulo : tipotransaccionmodulos) {
			if(conAsignarBase && tipotransaccionmodulo.getConCambioAuxiliar()) {
				tipotransaccionmodulo.setIsDeleted(tipotransaccionmodulo.getIsDeletedAuxiliar());	
				tipotransaccionmodulo.setIsNew(tipotransaccionmodulo.getIsNewAuxiliar());	
				tipotransaccionmodulo.setIsChanged(tipotransaccionmodulo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipotransaccionmodulo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipotransaccionmodulo.setIsDeletedAuxiliar(false);	
				tipotransaccionmodulo.setIsNewAuxiliar(false);	
				tipotransaccionmodulo.setIsChangedAuxiliar(false);
				
				tipotransaccionmodulo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoTransaccionModulo(TipoTransaccionModulo tipotransaccionmodulo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoTransaccionModulos(List<TipoTransaccionModulo> tipotransaccionmodulos,Boolean conEnteros) throws Exception  {
		
		for(TipoTransaccionModulo tipotransaccionmodulo: tipotransaccionmodulos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoTransaccionModulo(List<TipoTransaccionModulo> tipotransaccionmodulos,TipoTransaccionModulo tipotransaccionmoduloAux) throws Exception  {
		TipoTransaccionModuloConstantesFunciones.InicializarValoresTipoTransaccionModulo(tipotransaccionmoduloAux,true);
		
		for(TipoTransaccionModulo tipotransaccionmodulo: tipotransaccionmodulos) {
			if(tipotransaccionmodulo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTransaccionModulo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoTransaccionModuloConstantesFunciones.getArrayColumnasGlobalesTipoTransaccionModulo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTransaccionModulo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoTransaccionModuloConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoTransaccionModuloConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoTransaccionModulo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(TipoTransaccionModuloConstantesFunciones.IDMODULO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoTransaccionModulo> tipotransaccionmodulos,TipoTransaccionModulo tipotransaccionmodulo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoTransaccionModulo tipotransaccionmoduloAux: tipotransaccionmodulos) {
			if(tipotransaccionmoduloAux!=null && tipotransaccionmodulo!=null) {
				if((tipotransaccionmoduloAux.getId()==null && tipotransaccionmodulo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipotransaccionmoduloAux.getId()!=null && tipotransaccionmodulo.getId()!=null){
					if(tipotransaccionmoduloAux.getId().equals(tipotransaccionmodulo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoTransaccionModulo(List<TipoTransaccionModulo> tipotransaccionmodulos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoTransaccionModulo tipotransaccionmodulo: tipotransaccionmodulos) {			
			if(tipotransaccionmodulo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoTransaccionModulo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoTransaccionModuloConstantesFunciones.LABEL_ID, TipoTransaccionModuloConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTransaccionModuloConstantesFunciones.LABEL_VERSIONROW, TipoTransaccionModuloConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTransaccionModuloConstantesFunciones.LABEL_IDMODULO, TipoTransaccionModuloConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTransaccionModuloConstantesFunciones.LABEL_NOMBRE, TipoTransaccionModuloConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTransaccionModuloConstantesFunciones.LABEL_SIGLAS, TipoTransaccionModuloConstantesFunciones.SIGLAS,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoTransaccionModulo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoTransaccionModuloConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTransaccionModuloConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTransaccionModuloConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTransaccionModuloConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTransaccionModuloConstantesFunciones.SIGLAS;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTransaccionModulo() throws Exception  {
		return TipoTransaccionModuloConstantesFunciones.getTiposSeleccionarTipoTransaccionModulo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTransaccionModulo(Boolean conFk) throws Exception  {
		return TipoTransaccionModuloConstantesFunciones.getTiposSeleccionarTipoTransaccionModulo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTransaccionModulo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTransaccionModuloConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(TipoTransaccionModuloConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTransaccionModuloConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoTransaccionModuloConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTransaccionModuloConstantesFunciones.LABEL_SIGLAS);
			reporte.setsDescripcion(TipoTransaccionModuloConstantesFunciones.LABEL_SIGLAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoTransaccionModulo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTransaccionModulo(TipoTransaccionModulo tipotransaccionmoduloAux) throws Exception {
		
			tipotransaccionmoduloAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(tipotransaccionmoduloAux.getModulo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTransaccionModulo(List<TipoTransaccionModulo> tipotransaccionmodulosTemp) throws Exception {
		for(TipoTransaccionModulo tipotransaccionmoduloAux:tipotransaccionmodulosTemp) {
			
			tipotransaccionmoduloAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(tipotransaccionmoduloAux.getModulo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoTransaccionModulo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Modulo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoTransaccionModulo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTransaccionModulo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTransaccionModuloConstantesFunciones.getClassesRelationshipsOfTipoTransaccionModulo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTransaccionModulo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTransaccionModulo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTransaccionModuloConstantesFunciones.getClassesRelationshipsFromStringsOfTipoTransaccionModulo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTransaccionModulo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoTransaccionModulo tipotransaccionmodulo,List<TipoTransaccionModulo> tipotransaccionmodulos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoTransaccionModulo tipotransaccionmoduloEncontrado=null;
			
			for(TipoTransaccionModulo tipotransaccionmoduloLocal:tipotransaccionmodulos) {
				if(tipotransaccionmoduloLocal.getId().equals(tipotransaccionmodulo.getId())) {
					tipotransaccionmoduloEncontrado=tipotransaccionmoduloLocal;
					
					tipotransaccionmoduloLocal.setIsChanged(tipotransaccionmodulo.getIsChanged());
					tipotransaccionmoduloLocal.setIsNew(tipotransaccionmodulo.getIsNew());
					tipotransaccionmoduloLocal.setIsDeleted(tipotransaccionmodulo.getIsDeleted());
					
					tipotransaccionmoduloLocal.setGeneralEntityOriginal(tipotransaccionmodulo.getGeneralEntityOriginal());
					
					tipotransaccionmoduloLocal.setId(tipotransaccionmodulo.getId());	
					tipotransaccionmoduloLocal.setVersionRow(tipotransaccionmodulo.getVersionRow());	
					tipotransaccionmoduloLocal.setid_modulo(tipotransaccionmodulo.getid_modulo());	
					tipotransaccionmoduloLocal.setnombre(tipotransaccionmodulo.getnombre());	
					tipotransaccionmoduloLocal.setsiglas(tipotransaccionmodulo.getsiglas());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipotransaccionmodulo.getIsDeleted()) {
				if(!existe) {
					tipotransaccionmodulos.add(tipotransaccionmodulo);
				}
			} else {
				if(tipotransaccionmoduloEncontrado!=null && permiteQuitar)  {
					tipotransaccionmodulos.remove(tipotransaccionmoduloEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoTransaccionModulo tipotransaccionmodulo,List<TipoTransaccionModulo> tipotransaccionmodulos) throws Exception {
		try	{			
			for(TipoTransaccionModulo tipotransaccionmoduloLocal:tipotransaccionmodulos) {
				if(tipotransaccionmoduloLocal.getId().equals(tipotransaccionmodulo.getId())) {
					tipotransaccionmoduloLocal.setIsSelected(tipotransaccionmodulo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoTransaccionModulo(List<TipoTransaccionModulo> tipotransaccionmodulosAux) throws Exception {
		//this.tipotransaccionmodulosAux=tipotransaccionmodulosAux;
		
		for(TipoTransaccionModulo tipotransaccionmoduloAux:tipotransaccionmodulosAux) {
			if(tipotransaccionmoduloAux.getIsChanged()) {
				tipotransaccionmoduloAux.setIsChanged(false);
			}		
			
			if(tipotransaccionmoduloAux.getIsNew()) {
				tipotransaccionmoduloAux.setIsNew(false);
			}	
			
			if(tipotransaccionmoduloAux.getIsDeleted()) {
				tipotransaccionmoduloAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoTransaccionModulo(TipoTransaccionModulo tipotransaccionmoduloAux) throws Exception {
		//this.tipotransaccionmoduloAux=tipotransaccionmoduloAux;
		
			if(tipotransaccionmoduloAux.getIsChanged()) {
				tipotransaccionmoduloAux.setIsChanged(false);
			}		
			
			if(tipotransaccionmoduloAux.getIsNew()) {
				tipotransaccionmoduloAux.setIsNew(false);
			}	
			
			if(tipotransaccionmoduloAux.getIsDeleted()) {
				tipotransaccionmoduloAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoTransaccionModulo tipotransaccionmoduloAsignar,TipoTransaccionModulo tipotransaccionmodulo) throws Exception {
		tipotransaccionmoduloAsignar.setId(tipotransaccionmodulo.getId());	
		tipotransaccionmoduloAsignar.setVersionRow(tipotransaccionmodulo.getVersionRow());	
		tipotransaccionmoduloAsignar.setid_modulo(tipotransaccionmodulo.getid_modulo());
		tipotransaccionmoduloAsignar.setmodulo_descripcion(tipotransaccionmodulo.getmodulo_descripcion());	
		tipotransaccionmoduloAsignar.setnombre(tipotransaccionmodulo.getnombre());	
		tipotransaccionmoduloAsignar.setsiglas(tipotransaccionmodulo.getsiglas());	
	}
	
	public static void inicializarTipoTransaccionModulo(TipoTransaccionModulo tipotransaccionmodulo) throws Exception {
		try {
				tipotransaccionmodulo.setId(0L);	
					
				tipotransaccionmodulo.setid_modulo(-1L);	
				tipotransaccionmodulo.setnombre("");	
				tipotransaccionmodulo.setsiglas("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoTransaccionModulo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTransaccionModuloConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTransaccionModuloConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTransaccionModuloConstantesFunciones.LABEL_SIGLAS);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoTransaccionModulo(String sTipo,Row row,Workbook workbook,TipoTransaccionModulo tipotransaccionmodulo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotransaccionmodulo.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotransaccionmodulo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotransaccionmodulo.getsiglas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoTransaccionModulo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoTransaccionModulo() {
		return this.sFinalQueryTipoTransaccionModulo;
	}
	
	public void setsFinalQueryTipoTransaccionModulo(String sFinalQueryTipoTransaccionModulo) {
		this.sFinalQueryTipoTransaccionModulo= sFinalQueryTipoTransaccionModulo;
	}
	
	public Border resaltarSeleccionarTipoTransaccionModulo=null;
	
	public Border setResaltarSeleccionarTipoTransaccionModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTransaccionModuloBeanSwingJInternalFrame tipotransaccionmoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipotransaccionmoduloBeanSwingJInternalFrame.jTtoolBarTipoTransaccionModulo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoTransaccionModulo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoTransaccionModulo() {
		return this.resaltarSeleccionarTipoTransaccionModulo;
	}
	
	public void setResaltarSeleccionarTipoTransaccionModulo(Border borderResaltarSeleccionarTipoTransaccionModulo) {
		this.resaltarSeleccionarTipoTransaccionModulo= borderResaltarSeleccionarTipoTransaccionModulo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoTransaccionModulo=null;
	public Boolean mostraridTipoTransaccionModulo=true;
	public Boolean activaridTipoTransaccionModulo=true;

	public Border resaltarid_moduloTipoTransaccionModulo=null;
	public Boolean mostrarid_moduloTipoTransaccionModulo=true;
	public Boolean activarid_moduloTipoTransaccionModulo=true;
	public Boolean cargarid_moduloTipoTransaccionModulo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloTipoTransaccionModulo=false;//ConEventDepend=true

	public Border resaltarnombreTipoTransaccionModulo=null;
	public Boolean mostrarnombreTipoTransaccionModulo=true;
	public Boolean activarnombreTipoTransaccionModulo=true;

	public Border resaltarsiglasTipoTransaccionModulo=null;
	public Boolean mostrarsiglasTipoTransaccionModulo=true;
	public Boolean activarsiglasTipoTransaccionModulo=true;

	
	

	public Border setResaltaridTipoTransaccionModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTransaccionModuloBeanSwingJInternalFrame tipotransaccionmoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotransaccionmoduloBeanSwingJInternalFrame.jTtoolBarTipoTransaccionModulo.setBorder(borderResaltar);
		
		this.resaltaridTipoTransaccionModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoTransaccionModulo() {
		return this.resaltaridTipoTransaccionModulo;
	}

	public void setResaltaridTipoTransaccionModulo(Border borderResaltar) {
		this.resaltaridTipoTransaccionModulo= borderResaltar;
	}

	public Boolean getMostraridTipoTransaccionModulo() {
		return this.mostraridTipoTransaccionModulo;
	}

	public void setMostraridTipoTransaccionModulo(Boolean mostraridTipoTransaccionModulo) {
		this.mostraridTipoTransaccionModulo= mostraridTipoTransaccionModulo;
	}

	public Boolean getActivaridTipoTransaccionModulo() {
		return this.activaridTipoTransaccionModulo;
	}

	public void setActivaridTipoTransaccionModulo(Boolean activaridTipoTransaccionModulo) {
		this.activaridTipoTransaccionModulo= activaridTipoTransaccionModulo;
	}

	public Border setResaltarid_moduloTipoTransaccionModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTransaccionModuloBeanSwingJInternalFrame tipotransaccionmoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotransaccionmoduloBeanSwingJInternalFrame.jTtoolBarTipoTransaccionModulo.setBorder(borderResaltar);
		
		this.resaltarid_moduloTipoTransaccionModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloTipoTransaccionModulo() {
		return this.resaltarid_moduloTipoTransaccionModulo;
	}

	public void setResaltarid_moduloTipoTransaccionModulo(Border borderResaltar) {
		this.resaltarid_moduloTipoTransaccionModulo= borderResaltar;
	}

	public Boolean getMostrarid_moduloTipoTransaccionModulo() {
		return this.mostrarid_moduloTipoTransaccionModulo;
	}

	public void setMostrarid_moduloTipoTransaccionModulo(Boolean mostrarid_moduloTipoTransaccionModulo) {
		this.mostrarid_moduloTipoTransaccionModulo= mostrarid_moduloTipoTransaccionModulo;
	}

	public Boolean getActivarid_moduloTipoTransaccionModulo() {
		return this.activarid_moduloTipoTransaccionModulo;
	}

	public void setActivarid_moduloTipoTransaccionModulo(Boolean activarid_moduloTipoTransaccionModulo) {
		this.activarid_moduloTipoTransaccionModulo= activarid_moduloTipoTransaccionModulo;
	}

	public Boolean getCargarid_moduloTipoTransaccionModulo() {
		return this.cargarid_moduloTipoTransaccionModulo;
	}

	public void setCargarid_moduloTipoTransaccionModulo(Boolean cargarid_moduloTipoTransaccionModulo) {
		this.cargarid_moduloTipoTransaccionModulo= cargarid_moduloTipoTransaccionModulo;
	}

	public Border setResaltarnombreTipoTransaccionModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTransaccionModuloBeanSwingJInternalFrame tipotransaccionmoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotransaccionmoduloBeanSwingJInternalFrame.jTtoolBarTipoTransaccionModulo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoTransaccionModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoTransaccionModulo() {
		return this.resaltarnombreTipoTransaccionModulo;
	}

	public void setResaltarnombreTipoTransaccionModulo(Border borderResaltar) {
		this.resaltarnombreTipoTransaccionModulo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoTransaccionModulo() {
		return this.mostrarnombreTipoTransaccionModulo;
	}

	public void setMostrarnombreTipoTransaccionModulo(Boolean mostrarnombreTipoTransaccionModulo) {
		this.mostrarnombreTipoTransaccionModulo= mostrarnombreTipoTransaccionModulo;
	}

	public Boolean getActivarnombreTipoTransaccionModulo() {
		return this.activarnombreTipoTransaccionModulo;
	}

	public void setActivarnombreTipoTransaccionModulo(Boolean activarnombreTipoTransaccionModulo) {
		this.activarnombreTipoTransaccionModulo= activarnombreTipoTransaccionModulo;
	}

	public Border setResaltarsiglasTipoTransaccionModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTransaccionModuloBeanSwingJInternalFrame tipotransaccionmoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotransaccionmoduloBeanSwingJInternalFrame.jTtoolBarTipoTransaccionModulo.setBorder(borderResaltar);
		
		this.resaltarsiglasTipoTransaccionModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsiglasTipoTransaccionModulo() {
		return this.resaltarsiglasTipoTransaccionModulo;
	}

	public void setResaltarsiglasTipoTransaccionModulo(Border borderResaltar) {
		this.resaltarsiglasTipoTransaccionModulo= borderResaltar;
	}

	public Boolean getMostrarsiglasTipoTransaccionModulo() {
		return this.mostrarsiglasTipoTransaccionModulo;
	}

	public void setMostrarsiglasTipoTransaccionModulo(Boolean mostrarsiglasTipoTransaccionModulo) {
		this.mostrarsiglasTipoTransaccionModulo= mostrarsiglasTipoTransaccionModulo;
	}

	public Boolean getActivarsiglasTipoTransaccionModulo() {
		return this.activarsiglasTipoTransaccionModulo;
	}

	public void setActivarsiglasTipoTransaccionModulo(Boolean activarsiglasTipoTransaccionModulo) {
		this.activarsiglasTipoTransaccionModulo= activarsiglasTipoTransaccionModulo;
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
		
		
		this.setMostraridTipoTransaccionModulo(esInicial);
		this.setMostrarid_moduloTipoTransaccionModulo(esInicial);
		this.setMostrarnombreTipoTransaccionModulo(esInicial);
		this.setMostrarsiglasTipoTransaccionModulo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTransaccionModuloConstantesFunciones.ID)) {
				this.setMostraridTipoTransaccionModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTransaccionModuloConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloTipoTransaccionModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTransaccionModuloConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoTransaccionModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTransaccionModuloConstantesFunciones.SIGLAS)) {
				this.setMostrarsiglasTipoTransaccionModulo(esAsigna);
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
		
		
		this.setActivaridTipoTransaccionModulo(esInicial);
		this.setActivarid_moduloTipoTransaccionModulo(esInicial);
		this.setActivarnombreTipoTransaccionModulo(esInicial);
		this.setActivarsiglasTipoTransaccionModulo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTransaccionModuloConstantesFunciones.ID)) {
				this.setActivaridTipoTransaccionModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTransaccionModuloConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloTipoTransaccionModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTransaccionModuloConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoTransaccionModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTransaccionModuloConstantesFunciones.SIGLAS)) {
				this.setActivarsiglasTipoTransaccionModulo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTransaccionModuloBeanSwingJInternalFrame tipotransaccionmoduloBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoTransaccionModulo(esInicial);
		this.setResaltarid_moduloTipoTransaccionModulo(esInicial);
		this.setResaltarnombreTipoTransaccionModulo(esInicial);
		this.setResaltarsiglasTipoTransaccionModulo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTransaccionModuloConstantesFunciones.ID)) {
				this.setResaltaridTipoTransaccionModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTransaccionModuloConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloTipoTransaccionModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTransaccionModuloConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoTransaccionModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTransaccionModuloConstantesFunciones.SIGLAS)) {
				this.setResaltarsiglasTipoTransaccionModulo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTransaccionModuloBeanSwingJInternalFrame tipotransaccionmoduloBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdModuloPorNombreTipoTransaccionModulo=true;

	public Boolean getMostrarBusquedaPorIdModuloPorNombreTipoTransaccionModulo() {
		return this.mostrarBusquedaPorIdModuloPorNombreTipoTransaccionModulo;
	}

	public void setMostrarBusquedaPorIdModuloPorNombreTipoTransaccionModulo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdModuloPorNombreTipoTransaccionModulo= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoTransaccionModulo=true;

	public Boolean getMostrarBusquedaPorNombreTipoTransaccionModulo() {
		return this.mostrarBusquedaPorNombreTipoTransaccionModulo;
	}

	public void setMostrarBusquedaPorNombreTipoTransaccionModulo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoTransaccionModulo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloTipoTransaccionModulo=true;

	public Boolean getMostrarFK_IdModuloTipoTransaccionModulo() {
		return this.mostrarFK_IdModuloTipoTransaccionModulo;
	}

	public void setMostrarFK_IdModuloTipoTransaccionModulo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloTipoTransaccionModulo= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdModuloPorNombreTipoTransaccionModulo=true;

	public Boolean getActivarBusquedaPorIdModuloPorNombreTipoTransaccionModulo() {
		return this.activarBusquedaPorIdModuloPorNombreTipoTransaccionModulo;
	}

	public void setActivarBusquedaPorIdModuloPorNombreTipoTransaccionModulo(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdModuloPorNombreTipoTransaccionModulo= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoTransaccionModulo=true;

	public Boolean getActivarBusquedaPorNombreTipoTransaccionModulo() {
		return this.activarBusquedaPorNombreTipoTransaccionModulo;
	}

	public void setActivarBusquedaPorNombreTipoTransaccionModulo(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoTransaccionModulo= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloTipoTransaccionModulo=true;

	public Boolean getActivarFK_IdModuloTipoTransaccionModulo() {
		return this.activarFK_IdModuloTipoTransaccionModulo;
	}

	public void setActivarFK_IdModuloTipoTransaccionModulo(Boolean habilitarResaltar) {
		this.activarFK_IdModuloTipoTransaccionModulo= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdModuloPorNombreTipoTransaccionModulo=null;

	public Border getResaltarBusquedaPorIdModuloPorNombreTipoTransaccionModulo() {
		return this.resaltarBusquedaPorIdModuloPorNombreTipoTransaccionModulo;
	}

	public void setResaltarBusquedaPorIdModuloPorNombreTipoTransaccionModulo(Border borderResaltar) {
		this.resaltarBusquedaPorIdModuloPorNombreTipoTransaccionModulo= borderResaltar;
	}

	public void setResaltarBusquedaPorIdModuloPorNombreTipoTransaccionModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTransaccionModuloBeanSwingJInternalFrame tipotransaccionmoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdModuloPorNombreTipoTransaccionModulo= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoTransaccionModulo=null;

	public Border getResaltarBusquedaPorNombreTipoTransaccionModulo() {
		return this.resaltarBusquedaPorNombreTipoTransaccionModulo;
	}

	public void setResaltarBusquedaPorNombreTipoTransaccionModulo(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoTransaccionModulo= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoTransaccionModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTransaccionModuloBeanSwingJInternalFrame tipotransaccionmoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoTransaccionModulo= borderResaltar;
	}

	public Border resaltarFK_IdModuloTipoTransaccionModulo=null;

	public Border getResaltarFK_IdModuloTipoTransaccionModulo() {
		return this.resaltarFK_IdModuloTipoTransaccionModulo;
	}

	public void setResaltarFK_IdModuloTipoTransaccionModulo(Border borderResaltar) {
		this.resaltarFK_IdModuloTipoTransaccionModulo= borderResaltar;
	}

	public void setResaltarFK_IdModuloTipoTransaccionModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTransaccionModuloBeanSwingJInternalFrame tipotransaccionmoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloTipoTransaccionModulo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}