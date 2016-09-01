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


import com.bydan.erp.facturacion.util.DetalleDescuenPoliVentaConstantesFunciones;
import com.bydan.erp.facturacion.util.DetalleDescuenPoliVentaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetalleDescuenPoliVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleDescuenPoliVentaConstantesFunciones extends DetalleDescuenPoliVentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleDescuenPoliVenta";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleDescuenPoliVenta"+DetalleDescuenPoliVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleDescuenPoliVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleDescuenPoliVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"_"+DetalleDescuenPoliVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleDescuenPoliVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"_"+DetalleDescuenPoliVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"_"+DetalleDescuenPoliVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleDescuenPoliVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"_"+DetalleDescuenPoliVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleDescuenPoliVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleDescuenPoliVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleDescuenPoliVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleDescuenPoliVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleDescuenPoliVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleDescuenPoliVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleDescuenPoliVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleDescuenPoliVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleDescuenPoliVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleDescuenPoliVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Descuen Poli Ventas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Descuen Poli Venta";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Descuen Poli Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleDescuenPoliVenta";
	public static final String OBJECTNAME="detalledescuenpoliventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="detalle_descuen_poli_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalledescuenpoliventa from "+DetalleDescuenPoliVentaConstantesFunciones.SPERSISTENCENAME+" detalledescuenpoliventa";
	public static String QUERYSELECTNATIVE="select "+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".id,"+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".version_row,"+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".id_empresa,"+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".id_cliente,"+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".valor,"+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".descripcion from "+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME;//+" as "+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleDescuenPoliVentaConstantesFuncionesAdditional detalledescuenpoliventaConstantesFuncionesAdditional=null;
	
	public DetalleDescuenPoliVentaConstantesFuncionesAdditional getDetalleDescuenPoliVentaConstantesFuncionesAdditional() {
		return this.detalledescuenpoliventaConstantesFuncionesAdditional;
	}
	
	public void setDetalleDescuenPoliVentaConstantesFuncionesAdditional(DetalleDescuenPoliVentaConstantesFuncionesAdditional detalledescuenpoliventaConstantesFuncionesAdditional) {
		try {
			this.detalledescuenpoliventaConstantesFuncionesAdditional=detalledescuenpoliventaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String VALOR= "valor";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleDescuenPoliVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleDescuenPoliVentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleDescuenPoliVentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleDescuenPoliVentaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleDescuenPoliVentaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleDescuenPoliVentaConstantesFunciones.IDCLIENTE)) {sLabelColumna=DetalleDescuenPoliVentaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(DetalleDescuenPoliVentaConstantesFunciones.VALOR)) {sLabelColumna=DetalleDescuenPoliVentaConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(DetalleDescuenPoliVentaConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleDescuenPoliVentaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getDetalleDescuenPoliVentaDescripcion(DetalleDescuenPoliVenta detalledescuenpoliventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalledescuenpoliventa !=null/* && detalledescuenpoliventa.getId()!=0*/) {
			if(detalledescuenpoliventa.getId()!=null) {
				sDescripcion=detalledescuenpoliventa.getId().toString();
			}//detalledescuenpoliventadetalledescuenpoliventa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleDescuenPoliVentaDescripcionDetallado(DetalleDescuenPoliVenta detalledescuenpoliventa) {
		String sDescripcion="";
			
		sDescripcion+=DetalleDescuenPoliVentaConstantesFunciones.ID+"=";
		sDescripcion+=detalledescuenpoliventa.getId().toString()+",";
		sDescripcion+=DetalleDescuenPoliVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalledescuenpoliventa.getVersionRow().toString()+",";
		sDescripcion+=DetalleDescuenPoliVentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalledescuenpoliventa.getid_empresa().toString()+",";
		sDescripcion+=DetalleDescuenPoliVentaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalledescuenpoliventa.getid_sucursal().toString()+",";
		sDescripcion+=DetalleDescuenPoliVentaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=detalledescuenpoliventa.getid_cliente().toString()+",";
		sDescripcion+=DetalleDescuenPoliVentaConstantesFunciones.VALOR+"=";
		sDescripcion+=detalledescuenpoliventa.getvalor().toString()+",";
		sDescripcion+=DetalleDescuenPoliVentaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detalledescuenpoliventa.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleDescuenPoliVentaDescripcion(DetalleDescuenPoliVenta detalledescuenpoliventa,String sValor) throws Exception {			
		if(detalledescuenpoliventa !=null) {
			//detalledescuenpoliventadetalledescuenpoliventa.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleDescuenPoliVenta(DetalleDescuenPoliVenta detalledescuenpoliventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalledescuenpoliventa.setdescripcion(detalledescuenpoliventa.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetalleDescuenPoliVentas(List<DetalleDescuenPoliVenta> detalledescuenpoliventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleDescuenPoliVenta detalledescuenpoliventa: detalledescuenpoliventas) {
			detalledescuenpoliventa.setdescripcion(detalledescuenpoliventa.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleDescuenPoliVenta(DetalleDescuenPoliVenta detalledescuenpoliventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalledescuenpoliventa.getConCambioAuxiliar()) {
			detalledescuenpoliventa.setIsDeleted(detalledescuenpoliventa.getIsDeletedAuxiliar());	
			detalledescuenpoliventa.setIsNew(detalledescuenpoliventa.getIsNewAuxiliar());	
			detalledescuenpoliventa.setIsChanged(detalledescuenpoliventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalledescuenpoliventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalledescuenpoliventa.setIsDeletedAuxiliar(false);	
			detalledescuenpoliventa.setIsNewAuxiliar(false);	
			detalledescuenpoliventa.setIsChangedAuxiliar(false);
			
			detalledescuenpoliventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleDescuenPoliVentas(List<DetalleDescuenPoliVenta> detalledescuenpoliventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleDescuenPoliVenta detalledescuenpoliventa : detalledescuenpoliventas) {
			if(conAsignarBase && detalledescuenpoliventa.getConCambioAuxiliar()) {
				detalledescuenpoliventa.setIsDeleted(detalledescuenpoliventa.getIsDeletedAuxiliar());	
				detalledescuenpoliventa.setIsNew(detalledescuenpoliventa.getIsNewAuxiliar());	
				detalledescuenpoliventa.setIsChanged(detalledescuenpoliventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalledescuenpoliventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalledescuenpoliventa.setIsDeletedAuxiliar(false);	
				detalledescuenpoliventa.setIsNewAuxiliar(false);	
				detalledescuenpoliventa.setIsChangedAuxiliar(false);
				
				detalledescuenpoliventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleDescuenPoliVenta(DetalleDescuenPoliVenta detalledescuenpoliventa,Boolean conEnteros) throws Exception  {
		detalledescuenpoliventa.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleDescuenPoliVentas(List<DetalleDescuenPoliVenta> detalledescuenpoliventas,Boolean conEnteros) throws Exception  {
		
		for(DetalleDescuenPoliVenta detalledescuenpoliventa: detalledescuenpoliventas) {
			detalledescuenpoliventa.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleDescuenPoliVenta(List<DetalleDescuenPoliVenta> detalledescuenpoliventas,DetalleDescuenPoliVenta detalledescuenpoliventaAux) throws Exception  {
		DetalleDescuenPoliVentaConstantesFunciones.InicializarValoresDetalleDescuenPoliVenta(detalledescuenpoliventaAux,true);
		
		for(DetalleDescuenPoliVenta detalledescuenpoliventa: detalledescuenpoliventas) {
			if(detalledescuenpoliventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalledescuenpoliventaAux.setvalor(detalledescuenpoliventaAux.getvalor()+detalledescuenpoliventa.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleDescuenPoliVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleDescuenPoliVentaConstantesFunciones.getArrayColumnasGlobalesDetalleDescuenPoliVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleDescuenPoliVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleDescuenPoliVentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleDescuenPoliVentaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleDescuenPoliVentaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleDescuenPoliVentaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleDescuenPoliVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleDescuenPoliVenta> detalledescuenpoliventas,DetalleDescuenPoliVenta detalledescuenpoliventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleDescuenPoliVenta detalledescuenpoliventaAux: detalledescuenpoliventas) {
			if(detalledescuenpoliventaAux!=null && detalledescuenpoliventa!=null) {
				if((detalledescuenpoliventaAux.getId()==null && detalledescuenpoliventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalledescuenpoliventaAux.getId()!=null && detalledescuenpoliventa.getId()!=null){
					if(detalledescuenpoliventaAux.getId().equals(detalledescuenpoliventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleDescuenPoliVenta(List<DetalleDescuenPoliVenta> detalledescuenpoliventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(DetalleDescuenPoliVenta detalledescuenpoliventa: detalledescuenpoliventas) {			
			if(detalledescuenpoliventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=detalledescuenpoliventa.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleDescuenPoliVentaConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(DetalleDescuenPoliVentaConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleDescuenPoliVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleDescuenPoliVentaConstantesFunciones.LABEL_ID, DetalleDescuenPoliVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleDescuenPoliVentaConstantesFunciones.LABEL_VERSIONROW, DetalleDescuenPoliVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleDescuenPoliVentaConstantesFunciones.LABEL_IDEMPRESA, DetalleDescuenPoliVentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleDescuenPoliVentaConstantesFunciones.LABEL_IDSUCURSAL, DetalleDescuenPoliVentaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleDescuenPoliVentaConstantesFunciones.LABEL_IDCLIENTE, DetalleDescuenPoliVentaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleDescuenPoliVentaConstantesFunciones.LABEL_VALOR, DetalleDescuenPoliVentaConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleDescuenPoliVentaConstantesFunciones.LABEL_DESCRIPCION, DetalleDescuenPoliVentaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleDescuenPoliVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleDescuenPoliVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleDescuenPoliVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleDescuenPoliVentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleDescuenPoliVentaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleDescuenPoliVentaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleDescuenPoliVentaConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleDescuenPoliVentaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleDescuenPoliVenta() throws Exception  {
		return DetalleDescuenPoliVentaConstantesFunciones.getTiposSeleccionarDetalleDescuenPoliVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleDescuenPoliVenta(Boolean conFk) throws Exception  {
		return DetalleDescuenPoliVentaConstantesFunciones.getTiposSeleccionarDetalleDescuenPoliVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleDescuenPoliVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleDescuenPoliVentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleDescuenPoliVentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleDescuenPoliVentaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleDescuenPoliVentaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleDescuenPoliVentaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(DetalleDescuenPoliVentaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleDescuenPoliVentaConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(DetalleDescuenPoliVentaConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleDescuenPoliVentaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleDescuenPoliVentaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleDescuenPoliVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(DetalleDescuenPoliVenta detalledescuenpoliventaAux) throws Exception {
		
			detalledescuenpoliventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalledescuenpoliventaAux.getEmpresa()));
			detalledescuenpoliventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalledescuenpoliventaAux.getSucursal()));
			detalledescuenpoliventaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(detalledescuenpoliventaAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleDescuenPoliVenta(List<DetalleDescuenPoliVenta> detalledescuenpoliventasTemp) throws Exception {
		for(DetalleDescuenPoliVenta detalledescuenpoliventaAux:detalledescuenpoliventasTemp) {
			
			detalledescuenpoliventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalledescuenpoliventaAux.getEmpresa()));
			detalledescuenpoliventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalledescuenpoliventaAux.getSucursal()));
			detalledescuenpoliventaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(detalledescuenpoliventaAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleDescuenPoliVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleDescuenPoliVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleDescuenPoliVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleDescuenPoliVentaConstantesFunciones.getClassesRelationshipsOfDetalleDescuenPoliVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleDescuenPoliVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleDescuenPoliVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleDescuenPoliVentaConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleDescuenPoliVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleDescuenPoliVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleDescuenPoliVenta detalledescuenpoliventa,List<DetalleDescuenPoliVenta> detalledescuenpoliventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleDescuenPoliVenta detalledescuenpoliventaEncontrado=null;
			
			for(DetalleDescuenPoliVenta detalledescuenpoliventaLocal:detalledescuenpoliventas) {
				if(detalledescuenpoliventaLocal.getId().equals(detalledescuenpoliventa.getId())) {
					detalledescuenpoliventaEncontrado=detalledescuenpoliventaLocal;
					
					detalledescuenpoliventaLocal.setIsChanged(detalledescuenpoliventa.getIsChanged());
					detalledescuenpoliventaLocal.setIsNew(detalledescuenpoliventa.getIsNew());
					detalledescuenpoliventaLocal.setIsDeleted(detalledescuenpoliventa.getIsDeleted());
					
					detalledescuenpoliventaLocal.setGeneralEntityOriginal(detalledescuenpoliventa.getGeneralEntityOriginal());
					
					detalledescuenpoliventaLocal.setId(detalledescuenpoliventa.getId());	
					detalledescuenpoliventaLocal.setVersionRow(detalledescuenpoliventa.getVersionRow());	
					detalledescuenpoliventaLocal.setid_empresa(detalledescuenpoliventa.getid_empresa());	
					detalledescuenpoliventaLocal.setid_sucursal(detalledescuenpoliventa.getid_sucursal());	
					detalledescuenpoliventaLocal.setid_cliente(detalledescuenpoliventa.getid_cliente());	
					detalledescuenpoliventaLocal.setvalor(detalledescuenpoliventa.getvalor());	
					detalledescuenpoliventaLocal.setdescripcion(detalledescuenpoliventa.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalledescuenpoliventa.getIsDeleted()) {
				if(!existe) {
					detalledescuenpoliventas.add(detalledescuenpoliventa);
				}
			} else {
				if(detalledescuenpoliventaEncontrado!=null && permiteQuitar)  {
					detalledescuenpoliventas.remove(detalledescuenpoliventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleDescuenPoliVenta detalledescuenpoliventa,List<DetalleDescuenPoliVenta> detalledescuenpoliventas) throws Exception {
		try	{			
			for(DetalleDescuenPoliVenta detalledescuenpoliventaLocal:detalledescuenpoliventas) {
				if(detalledescuenpoliventaLocal.getId().equals(detalledescuenpoliventa.getId())) {
					detalledescuenpoliventaLocal.setIsSelected(detalledescuenpoliventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleDescuenPoliVenta(List<DetalleDescuenPoliVenta> detalledescuenpoliventasAux) throws Exception {
		//this.detalledescuenpoliventasAux=detalledescuenpoliventasAux;
		
		for(DetalleDescuenPoliVenta detalledescuenpoliventaAux:detalledescuenpoliventasAux) {
			if(detalledescuenpoliventaAux.getIsChanged()) {
				detalledescuenpoliventaAux.setIsChanged(false);
			}		
			
			if(detalledescuenpoliventaAux.getIsNew()) {
				detalledescuenpoliventaAux.setIsNew(false);
			}	
			
			if(detalledescuenpoliventaAux.getIsDeleted()) {
				detalledescuenpoliventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleDescuenPoliVenta(DetalleDescuenPoliVenta detalledescuenpoliventaAux) throws Exception {
		//this.detalledescuenpoliventaAux=detalledescuenpoliventaAux;
		
			if(detalledescuenpoliventaAux.getIsChanged()) {
				detalledescuenpoliventaAux.setIsChanged(false);
			}		
			
			if(detalledescuenpoliventaAux.getIsNew()) {
				detalledescuenpoliventaAux.setIsNew(false);
			}	
			
			if(detalledescuenpoliventaAux.getIsDeleted()) {
				detalledescuenpoliventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleDescuenPoliVenta detalledescuenpoliventaAsignar,DetalleDescuenPoliVenta detalledescuenpoliventa) throws Exception {
		detalledescuenpoliventaAsignar.setId(detalledescuenpoliventa.getId());	
		detalledescuenpoliventaAsignar.setVersionRow(detalledescuenpoliventa.getVersionRow());	
		detalledescuenpoliventaAsignar.setid_empresa(detalledescuenpoliventa.getid_empresa());
		detalledescuenpoliventaAsignar.setempresa_descripcion(detalledescuenpoliventa.getempresa_descripcion());	
		detalledescuenpoliventaAsignar.setid_sucursal(detalledescuenpoliventa.getid_sucursal());
		detalledescuenpoliventaAsignar.setsucursal_descripcion(detalledescuenpoliventa.getsucursal_descripcion());	
		detalledescuenpoliventaAsignar.setid_cliente(detalledescuenpoliventa.getid_cliente());
		detalledescuenpoliventaAsignar.setcliente_descripcion(detalledescuenpoliventa.getcliente_descripcion());	
		detalledescuenpoliventaAsignar.setvalor(detalledescuenpoliventa.getvalor());	
		detalledescuenpoliventaAsignar.setdescripcion(detalledescuenpoliventa.getdescripcion());	
	}
	
	public static void inicializarDetalleDescuenPoliVenta(DetalleDescuenPoliVenta detalledescuenpoliventa) throws Exception {
		try {
				detalledescuenpoliventa.setId(0L);	
					
				detalledescuenpoliventa.setid_empresa(-1L);	
				detalledescuenpoliventa.setid_sucursal(-1L);	
				detalledescuenpoliventa.setid_cliente(-1L);	
				detalledescuenpoliventa.setvalor(0.0);	
				detalledescuenpoliventa.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleDescuenPoliVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleDescuenPoliVentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleDescuenPoliVentaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleDescuenPoliVentaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleDescuenPoliVentaConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleDescuenPoliVentaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleDescuenPoliVenta(String sTipo,Row row,Workbook workbook,DetalleDescuenPoliVenta detalledescuenpoliventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalledescuenpoliventa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalledescuenpoliventa.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalledescuenpoliventa.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalledescuenpoliventa.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalledescuenpoliventa.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleDescuenPoliVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleDescuenPoliVenta() {
		return this.sFinalQueryDetalleDescuenPoliVenta;
	}
	
	public void setsFinalQueryDetalleDescuenPoliVenta(String sFinalQueryDetalleDescuenPoliVenta) {
		this.sFinalQueryDetalleDescuenPoliVenta= sFinalQueryDetalleDescuenPoliVenta;
	}
	
	public Border resaltarSeleccionarDetalleDescuenPoliVenta=null;
	
	public Border setResaltarSeleccionarDetalleDescuenPoliVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDescuenPoliVentaBeanSwingJInternalFrame detalledescuenpoliventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalledescuenpoliventaBeanSwingJInternalFrame.jTtoolBarDetalleDescuenPoliVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleDescuenPoliVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleDescuenPoliVenta() {
		return this.resaltarSeleccionarDetalleDescuenPoliVenta;
	}
	
	public void setResaltarSeleccionarDetalleDescuenPoliVenta(Border borderResaltarSeleccionarDetalleDescuenPoliVenta) {
		this.resaltarSeleccionarDetalleDescuenPoliVenta= borderResaltarSeleccionarDetalleDescuenPoliVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleDescuenPoliVenta=null;
	public Boolean mostraridDetalleDescuenPoliVenta=true;
	public Boolean activaridDetalleDescuenPoliVenta=true;

	public Border resaltarid_empresaDetalleDescuenPoliVenta=null;
	public Boolean mostrarid_empresaDetalleDescuenPoliVenta=true;
	public Boolean activarid_empresaDetalleDescuenPoliVenta=true;
	public Boolean cargarid_empresaDetalleDescuenPoliVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleDescuenPoliVenta=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleDescuenPoliVenta=null;
	public Boolean mostrarid_sucursalDetalleDescuenPoliVenta=true;
	public Boolean activarid_sucursalDetalleDescuenPoliVenta=true;
	public Boolean cargarid_sucursalDetalleDescuenPoliVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleDescuenPoliVenta=false;//ConEventDepend=true

	public Border resaltarid_clienteDetalleDescuenPoliVenta=null;
	public Boolean mostrarid_clienteDetalleDescuenPoliVenta=true;
	public Boolean activarid_clienteDetalleDescuenPoliVenta=true;
	public Boolean cargarid_clienteDetalleDescuenPoliVenta=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteDetalleDescuenPoliVenta=false;//ConEventDepend=true

	public Border resaltarvalorDetalleDescuenPoliVenta=null;
	public Boolean mostrarvalorDetalleDescuenPoliVenta=true;
	public Boolean activarvalorDetalleDescuenPoliVenta=true;

	public Border resaltardescripcionDetalleDescuenPoliVenta=null;
	public Boolean mostrardescripcionDetalleDescuenPoliVenta=true;
	public Boolean activardescripcionDetalleDescuenPoliVenta=true;

	
	

	public Border setResaltaridDetalleDescuenPoliVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDescuenPoliVentaBeanSwingJInternalFrame detalledescuenpoliventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalledescuenpoliventaBeanSwingJInternalFrame.jTtoolBarDetalleDescuenPoliVenta.setBorder(borderResaltar);
		
		this.resaltaridDetalleDescuenPoliVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleDescuenPoliVenta() {
		return this.resaltaridDetalleDescuenPoliVenta;
	}

	public void setResaltaridDetalleDescuenPoliVenta(Border borderResaltar) {
		this.resaltaridDetalleDescuenPoliVenta= borderResaltar;
	}

	public Boolean getMostraridDetalleDescuenPoliVenta() {
		return this.mostraridDetalleDescuenPoliVenta;
	}

	public void setMostraridDetalleDescuenPoliVenta(Boolean mostraridDetalleDescuenPoliVenta) {
		this.mostraridDetalleDescuenPoliVenta= mostraridDetalleDescuenPoliVenta;
	}

	public Boolean getActivaridDetalleDescuenPoliVenta() {
		return this.activaridDetalleDescuenPoliVenta;
	}

	public void setActivaridDetalleDescuenPoliVenta(Boolean activaridDetalleDescuenPoliVenta) {
		this.activaridDetalleDescuenPoliVenta= activaridDetalleDescuenPoliVenta;
	}

	public Border setResaltarid_empresaDetalleDescuenPoliVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDescuenPoliVentaBeanSwingJInternalFrame detalledescuenpoliventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalledescuenpoliventaBeanSwingJInternalFrame.jTtoolBarDetalleDescuenPoliVenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleDescuenPoliVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleDescuenPoliVenta() {
		return this.resaltarid_empresaDetalleDescuenPoliVenta;
	}

	public void setResaltarid_empresaDetalleDescuenPoliVenta(Border borderResaltar) {
		this.resaltarid_empresaDetalleDescuenPoliVenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleDescuenPoliVenta() {
		return this.mostrarid_empresaDetalleDescuenPoliVenta;
	}

	public void setMostrarid_empresaDetalleDescuenPoliVenta(Boolean mostrarid_empresaDetalleDescuenPoliVenta) {
		this.mostrarid_empresaDetalleDescuenPoliVenta= mostrarid_empresaDetalleDescuenPoliVenta;
	}

	public Boolean getActivarid_empresaDetalleDescuenPoliVenta() {
		return this.activarid_empresaDetalleDescuenPoliVenta;
	}

	public void setActivarid_empresaDetalleDescuenPoliVenta(Boolean activarid_empresaDetalleDescuenPoliVenta) {
		this.activarid_empresaDetalleDescuenPoliVenta= activarid_empresaDetalleDescuenPoliVenta;
	}

	public Boolean getCargarid_empresaDetalleDescuenPoliVenta() {
		return this.cargarid_empresaDetalleDescuenPoliVenta;
	}

	public void setCargarid_empresaDetalleDescuenPoliVenta(Boolean cargarid_empresaDetalleDescuenPoliVenta) {
		this.cargarid_empresaDetalleDescuenPoliVenta= cargarid_empresaDetalleDescuenPoliVenta;
	}

	public Border setResaltarid_sucursalDetalleDescuenPoliVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDescuenPoliVentaBeanSwingJInternalFrame detalledescuenpoliventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalledescuenpoliventaBeanSwingJInternalFrame.jTtoolBarDetalleDescuenPoliVenta.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleDescuenPoliVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleDescuenPoliVenta() {
		return this.resaltarid_sucursalDetalleDescuenPoliVenta;
	}

	public void setResaltarid_sucursalDetalleDescuenPoliVenta(Border borderResaltar) {
		this.resaltarid_sucursalDetalleDescuenPoliVenta= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleDescuenPoliVenta() {
		return this.mostrarid_sucursalDetalleDescuenPoliVenta;
	}

	public void setMostrarid_sucursalDetalleDescuenPoliVenta(Boolean mostrarid_sucursalDetalleDescuenPoliVenta) {
		this.mostrarid_sucursalDetalleDescuenPoliVenta= mostrarid_sucursalDetalleDescuenPoliVenta;
	}

	public Boolean getActivarid_sucursalDetalleDescuenPoliVenta() {
		return this.activarid_sucursalDetalleDescuenPoliVenta;
	}

	public void setActivarid_sucursalDetalleDescuenPoliVenta(Boolean activarid_sucursalDetalleDescuenPoliVenta) {
		this.activarid_sucursalDetalleDescuenPoliVenta= activarid_sucursalDetalleDescuenPoliVenta;
	}

	public Boolean getCargarid_sucursalDetalleDescuenPoliVenta() {
		return this.cargarid_sucursalDetalleDescuenPoliVenta;
	}

	public void setCargarid_sucursalDetalleDescuenPoliVenta(Boolean cargarid_sucursalDetalleDescuenPoliVenta) {
		this.cargarid_sucursalDetalleDescuenPoliVenta= cargarid_sucursalDetalleDescuenPoliVenta;
	}

	public Border setResaltarid_clienteDetalleDescuenPoliVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDescuenPoliVentaBeanSwingJInternalFrame detalledescuenpoliventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalledescuenpoliventaBeanSwingJInternalFrame.jTtoolBarDetalleDescuenPoliVenta.setBorder(borderResaltar);
		
		this.resaltarid_clienteDetalleDescuenPoliVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteDetalleDescuenPoliVenta() {
		return this.resaltarid_clienteDetalleDescuenPoliVenta;
	}

	public void setResaltarid_clienteDetalleDescuenPoliVenta(Border borderResaltar) {
		this.resaltarid_clienteDetalleDescuenPoliVenta= borderResaltar;
	}

	public Boolean getMostrarid_clienteDetalleDescuenPoliVenta() {
		return this.mostrarid_clienteDetalleDescuenPoliVenta;
	}

	public void setMostrarid_clienteDetalleDescuenPoliVenta(Boolean mostrarid_clienteDetalleDescuenPoliVenta) {
		this.mostrarid_clienteDetalleDescuenPoliVenta= mostrarid_clienteDetalleDescuenPoliVenta;
	}

	public Boolean getActivarid_clienteDetalleDescuenPoliVenta() {
		return this.activarid_clienteDetalleDescuenPoliVenta;
	}

	public void setActivarid_clienteDetalleDescuenPoliVenta(Boolean activarid_clienteDetalleDescuenPoliVenta) {
		this.activarid_clienteDetalleDescuenPoliVenta= activarid_clienteDetalleDescuenPoliVenta;
	}

	public Boolean getCargarid_clienteDetalleDescuenPoliVenta() {
		return this.cargarid_clienteDetalleDescuenPoliVenta;
	}

	public void setCargarid_clienteDetalleDescuenPoliVenta(Boolean cargarid_clienteDetalleDescuenPoliVenta) {
		this.cargarid_clienteDetalleDescuenPoliVenta= cargarid_clienteDetalleDescuenPoliVenta;
	}

	public Border setResaltarvalorDetalleDescuenPoliVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDescuenPoliVentaBeanSwingJInternalFrame detalledescuenpoliventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalledescuenpoliventaBeanSwingJInternalFrame.jTtoolBarDetalleDescuenPoliVenta.setBorder(borderResaltar);
		
		this.resaltarvalorDetalleDescuenPoliVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorDetalleDescuenPoliVenta() {
		return this.resaltarvalorDetalleDescuenPoliVenta;
	}

	public void setResaltarvalorDetalleDescuenPoliVenta(Border borderResaltar) {
		this.resaltarvalorDetalleDescuenPoliVenta= borderResaltar;
	}

	public Boolean getMostrarvalorDetalleDescuenPoliVenta() {
		return this.mostrarvalorDetalleDescuenPoliVenta;
	}

	public void setMostrarvalorDetalleDescuenPoliVenta(Boolean mostrarvalorDetalleDescuenPoliVenta) {
		this.mostrarvalorDetalleDescuenPoliVenta= mostrarvalorDetalleDescuenPoliVenta;
	}

	public Boolean getActivarvalorDetalleDescuenPoliVenta() {
		return this.activarvalorDetalleDescuenPoliVenta;
	}

	public void setActivarvalorDetalleDescuenPoliVenta(Boolean activarvalorDetalleDescuenPoliVenta) {
		this.activarvalorDetalleDescuenPoliVenta= activarvalorDetalleDescuenPoliVenta;
	}

	public Border setResaltardescripcionDetalleDescuenPoliVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDescuenPoliVentaBeanSwingJInternalFrame detalledescuenpoliventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalledescuenpoliventaBeanSwingJInternalFrame.jTtoolBarDetalleDescuenPoliVenta.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleDescuenPoliVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleDescuenPoliVenta() {
		return this.resaltardescripcionDetalleDescuenPoliVenta;
	}

	public void setResaltardescripcionDetalleDescuenPoliVenta(Border borderResaltar) {
		this.resaltardescripcionDetalleDescuenPoliVenta= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleDescuenPoliVenta() {
		return this.mostrardescripcionDetalleDescuenPoliVenta;
	}

	public void setMostrardescripcionDetalleDescuenPoliVenta(Boolean mostrardescripcionDetalleDescuenPoliVenta) {
		this.mostrardescripcionDetalleDescuenPoliVenta= mostrardescripcionDetalleDescuenPoliVenta;
	}

	public Boolean getActivardescripcionDetalleDescuenPoliVenta() {
		return this.activardescripcionDetalleDescuenPoliVenta;
	}

	public void setActivardescripcionDetalleDescuenPoliVenta(Boolean activardescripcionDetalleDescuenPoliVenta) {
		this.activardescripcionDetalleDescuenPoliVenta= activardescripcionDetalleDescuenPoliVenta;
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
		
		
		this.setMostraridDetalleDescuenPoliVenta(esInicial);
		this.setMostrarid_empresaDetalleDescuenPoliVenta(esInicial);
		this.setMostrarid_sucursalDetalleDescuenPoliVenta(esInicial);
		this.setMostrarid_clienteDetalleDescuenPoliVenta(esInicial);
		this.setMostrarvalorDetalleDescuenPoliVenta(esInicial);
		this.setMostrardescripcionDetalleDescuenPoliVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.ID)) {
				this.setMostraridDetalleDescuenPoliVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleDescuenPoliVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleDescuenPoliVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteDetalleDescuenPoliVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.VALOR)) {
				this.setMostrarvalorDetalleDescuenPoliVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleDescuenPoliVenta(esAsigna);
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
		
		
		this.setActivaridDetalleDescuenPoliVenta(esInicial);
		this.setActivarid_empresaDetalleDescuenPoliVenta(esInicial);
		this.setActivarid_sucursalDetalleDescuenPoliVenta(esInicial);
		this.setActivarid_clienteDetalleDescuenPoliVenta(esInicial);
		this.setActivarvalorDetalleDescuenPoliVenta(esInicial);
		this.setActivardescripcionDetalleDescuenPoliVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.ID)) {
				this.setActivaridDetalleDescuenPoliVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleDescuenPoliVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleDescuenPoliVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteDetalleDescuenPoliVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.VALOR)) {
				this.setActivarvalorDetalleDescuenPoliVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleDescuenPoliVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleDescuenPoliVentaBeanSwingJInternalFrame detalledescuenpoliventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleDescuenPoliVenta(esInicial);
		this.setResaltarid_empresaDetalleDescuenPoliVenta(esInicial);
		this.setResaltarid_sucursalDetalleDescuenPoliVenta(esInicial);
		this.setResaltarid_clienteDetalleDescuenPoliVenta(esInicial);
		this.setResaltarvalorDetalleDescuenPoliVenta(esInicial);
		this.setResaltardescripcionDetalleDescuenPoliVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.ID)) {
				this.setResaltaridDetalleDescuenPoliVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleDescuenPoliVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleDescuenPoliVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteDetalleDescuenPoliVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.VALOR)) {
				this.setResaltarvalorDetalleDescuenPoliVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDescuenPoliVentaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleDescuenPoliVenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleDescuenPoliVentaBeanSwingJInternalFrame detalledescuenpoliventaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteDetalleDescuenPoliVenta=true;

	public Boolean getMostrarFK_IdClienteDetalleDescuenPoliVenta() {
		return this.mostrarFK_IdClienteDetalleDescuenPoliVenta;
	}

	public void setMostrarFK_IdClienteDetalleDescuenPoliVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteDetalleDescuenPoliVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleDescuenPoliVenta=true;

	public Boolean getMostrarFK_IdEmpresaDetalleDescuenPoliVenta() {
		return this.mostrarFK_IdEmpresaDetalleDescuenPoliVenta;
	}

	public void setMostrarFK_IdEmpresaDetalleDescuenPoliVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleDescuenPoliVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleDescuenPoliVenta=true;

	public Boolean getMostrarFK_IdSucursalDetalleDescuenPoliVenta() {
		return this.mostrarFK_IdSucursalDetalleDescuenPoliVenta;
	}

	public void setMostrarFK_IdSucursalDetalleDescuenPoliVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleDescuenPoliVenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteDetalleDescuenPoliVenta=true;

	public Boolean getActivarFK_IdClienteDetalleDescuenPoliVenta() {
		return this.activarFK_IdClienteDetalleDescuenPoliVenta;
	}

	public void setActivarFK_IdClienteDetalleDescuenPoliVenta(Boolean habilitarResaltar) {
		this.activarFK_IdClienteDetalleDescuenPoliVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleDescuenPoliVenta=true;

	public Boolean getActivarFK_IdEmpresaDetalleDescuenPoliVenta() {
		return this.activarFK_IdEmpresaDetalleDescuenPoliVenta;
	}

	public void setActivarFK_IdEmpresaDetalleDescuenPoliVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleDescuenPoliVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleDescuenPoliVenta=true;

	public Boolean getActivarFK_IdSucursalDetalleDescuenPoliVenta() {
		return this.activarFK_IdSucursalDetalleDescuenPoliVenta;
	}

	public void setActivarFK_IdSucursalDetalleDescuenPoliVenta(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleDescuenPoliVenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteDetalleDescuenPoliVenta=null;

	public Border getResaltarFK_IdClienteDetalleDescuenPoliVenta() {
		return this.resaltarFK_IdClienteDetalleDescuenPoliVenta;
	}

	public void setResaltarFK_IdClienteDetalleDescuenPoliVenta(Border borderResaltar) {
		this.resaltarFK_IdClienteDetalleDescuenPoliVenta= borderResaltar;
	}

	public void setResaltarFK_IdClienteDetalleDescuenPoliVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDescuenPoliVentaBeanSwingJInternalFrame detalledescuenpoliventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteDetalleDescuenPoliVenta= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleDescuenPoliVenta=null;

	public Border getResaltarFK_IdEmpresaDetalleDescuenPoliVenta() {
		return this.resaltarFK_IdEmpresaDetalleDescuenPoliVenta;
	}

	public void setResaltarFK_IdEmpresaDetalleDescuenPoliVenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleDescuenPoliVenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleDescuenPoliVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDescuenPoliVentaBeanSwingJInternalFrame detalledescuenpoliventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleDescuenPoliVenta= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleDescuenPoliVenta=null;

	public Border getResaltarFK_IdSucursalDetalleDescuenPoliVenta() {
		return this.resaltarFK_IdSucursalDetalleDescuenPoliVenta;
	}

	public void setResaltarFK_IdSucursalDetalleDescuenPoliVenta(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleDescuenPoliVenta= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleDescuenPoliVenta(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDescuenPoliVentaBeanSwingJInternalFrame detalledescuenpoliventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleDescuenPoliVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}