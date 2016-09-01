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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.DetalleRecapConstantesFunciones;
import com.bydan.erp.cartera.util.DetalleRecapParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DetalleRecapParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleRecapConstantesFunciones extends DetalleRecapConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleRecap";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleRecap"+DetalleRecapConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleRecapHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleRecapHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleRecapConstantesFunciones.SCHEMA+"_"+DetalleRecapConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleRecapHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleRecapConstantesFunciones.SCHEMA+"_"+DetalleRecapConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleRecapConstantesFunciones.SCHEMA+"_"+DetalleRecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleRecapHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleRecapConstantesFunciones.SCHEMA+"_"+DetalleRecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRecapConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleRecapHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRecapConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleRecapHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleRecapConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleRecapConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleRecapConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleRecapConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Recapes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Detalle Recap";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Recap";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleRecap";
	public static final String OBJECTNAME="detallerecap";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="detalle_recap";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallerecap from "+DetalleRecapConstantesFunciones.SPERSISTENCENAME+" detallerecap";
	public static String QUERYSELECTNATIVE="select "+DetalleRecapConstantesFunciones.SCHEMA+"."+DetalleRecapConstantesFunciones.TABLENAME+".id,"+DetalleRecapConstantesFunciones.SCHEMA+"."+DetalleRecapConstantesFunciones.TABLENAME+".version_row,"+DetalleRecapConstantesFunciones.SCHEMA+"."+DetalleRecapConstantesFunciones.TABLENAME+".id_recap,"+DetalleRecapConstantesFunciones.SCHEMA+"."+DetalleRecapConstantesFunciones.TABLENAME+".id_empresa,"+DetalleRecapConstantesFunciones.SCHEMA+"."+DetalleRecapConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleRecapConstantesFunciones.SCHEMA+"."+DetalleRecapConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleRecapConstantesFunciones.SCHEMA+"."+DetalleRecapConstantesFunciones.TABLENAME+".id_detalle_cliente,"+DetalleRecapConstantesFunciones.SCHEMA+"."+DetalleRecapConstantesFunciones.TABLENAME+".id_cliente,"+DetalleRecapConstantesFunciones.SCHEMA+"."+DetalleRecapConstantesFunciones.TABLENAME+".valor,"+DetalleRecapConstantesFunciones.SCHEMA+"."+DetalleRecapConstantesFunciones.TABLENAME+".iva_porcentaje,"+DetalleRecapConstantesFunciones.SCHEMA+"."+DetalleRecapConstantesFunciones.TABLENAME+".total from "+DetalleRecapConstantesFunciones.SCHEMA+"."+DetalleRecapConstantesFunciones.TABLENAME;//+" as "+DetalleRecapConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleRecapConstantesFuncionesAdditional detallerecapConstantesFuncionesAdditional=null;
	
	public DetalleRecapConstantesFuncionesAdditional getDetalleRecapConstantesFuncionesAdditional() {
		return this.detallerecapConstantesFuncionesAdditional;
	}
	
	public void setDetalleRecapConstantesFuncionesAdditional(DetalleRecapConstantesFuncionesAdditional detallerecapConstantesFuncionesAdditional) {
		try {
			this.detallerecapConstantesFuncionesAdditional=detallerecapConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDRECAP= "id_recap";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDDETALLECLIENTE= "id_detalle_cliente";
    public static final String IDCLIENTE= "id_cliente";
    public static final String VALOR= "valor";
    public static final String IVAPORCENTAJE= "iva_porcentaje";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDRECAP= "Recap";
		public static final String LABEL_IDRECAP_LOWER= "Recap";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDDETALLECLIENTE= "Detalle Cliente";
		public static final String LABEL_IDDETALLECLIENTE_LOWER= "Detalle Cliente";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_IVAPORCENTAJE= "Iva Porcentaje";
		public static final String LABEL_IVAPORCENTAJE_LOWER= "Iva Porcentaje";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getDetalleRecapLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleRecapConstantesFunciones.IDRECAP)) {sLabelColumna=DetalleRecapConstantesFunciones.LABEL_IDRECAP;}
		if(sNombreColumna.equals(DetalleRecapConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleRecapConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleRecapConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleRecapConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleRecapConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleRecapConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleRecapConstantesFunciones.IDDETALLECLIENTE)) {sLabelColumna=DetalleRecapConstantesFunciones.LABEL_IDDETALLECLIENTE;}
		if(sNombreColumna.equals(DetalleRecapConstantesFunciones.IDCLIENTE)) {sLabelColumna=DetalleRecapConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(DetalleRecapConstantesFunciones.VALOR)) {sLabelColumna=DetalleRecapConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(DetalleRecapConstantesFunciones.IVAPORCENTAJE)) {sLabelColumna=DetalleRecapConstantesFunciones.LABEL_IVAPORCENTAJE;}
		if(sNombreColumna.equals(DetalleRecapConstantesFunciones.TOTAL)) {sLabelColumna=DetalleRecapConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleRecapDescripcion(DetalleRecap detallerecap) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallerecap !=null/* && detallerecap.getId()!=0*/) {
			if(detallerecap.getId()!=null) {
				sDescripcion=detallerecap.getId().toString();
			}//detallerecapdetallerecap.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleRecapDescripcionDetallado(DetalleRecap detallerecap) {
		String sDescripcion="";
			
		sDescripcion+=DetalleRecapConstantesFunciones.ID+"=";
		sDescripcion+=detallerecap.getId().toString()+",";
		sDescripcion+=DetalleRecapConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallerecap.getVersionRow().toString()+",";
		sDescripcion+=DetalleRecapConstantesFunciones.IDRECAP+"=";
		sDescripcion+=detallerecap.getid_recap().toString()+",";
		sDescripcion+=DetalleRecapConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallerecap.getid_empresa().toString()+",";
		sDescripcion+=DetalleRecapConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallerecap.getid_sucursal().toString()+",";
		sDescripcion+=DetalleRecapConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallerecap.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleRecapConstantesFunciones.IDDETALLECLIENTE+"=";
		sDescripcion+=detallerecap.getid_detalle_cliente().toString()+",";
		sDescripcion+=DetalleRecapConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=detallerecap.getid_cliente().toString()+",";
		sDescripcion+=DetalleRecapConstantesFunciones.VALOR+"=";
		sDescripcion+=detallerecap.getvalor().toString()+",";
		sDescripcion+=DetalleRecapConstantesFunciones.IVAPORCENTAJE+"=";
		sDescripcion+=detallerecap.getiva_porcentaje().toString()+",";
		sDescripcion+=DetalleRecapConstantesFunciones.TOTAL+"=";
		sDescripcion+=detallerecap.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleRecapDescripcion(DetalleRecap detallerecap,String sValor) throws Exception {			
		if(detallerecap !=null) {
			//detallerecapdetallerecap.getId().toString();
		}		
	}
	
		

	public static String getRecapDescripcion(Recap recap) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(recap!=null/*&&recap.getId()>0*/) {
			sDescripcion=RecapConstantesFunciones.getRecapDescripcion(recap);
		}

		return sDescripcion;
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getDetalleClienteDescripcion(DetalleCliente detallecliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detallecliente!=null/*&&detallecliente.getId()>0*/) {
			sDescripcion=DetalleClienteConstantesFunciones.getDetalleClienteDescripcion(detallecliente);
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
		} else if(sNombreIndice.equals("FK_IdDetalleCliente")) {
			sNombreIndice="Tipo=  Por Detalle Cliente";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdRecap")) {
			sNombreIndice="Tipo=  Por Recap";
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

	public static String getDetalleIndiceFK_IdDetalleCliente(Long id_detalle_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_cliente!=null) {sDetalleIndice+=" Codigo Unico De Detalle Cliente="+id_detalle_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRecap(Long id_recap) {
		String sDetalleIndice=" Parametros->";
		if(id_recap!=null) {sDetalleIndice+=" Codigo Unico De Recap="+id_recap.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleRecap(DetalleRecap detallerecap,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosDetalleRecaps(List<DetalleRecap> detallerecaps,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleRecap detallerecap: detallerecaps) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleRecap(DetalleRecap detallerecap,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallerecap.getConCambioAuxiliar()) {
			detallerecap.setIsDeleted(detallerecap.getIsDeletedAuxiliar());	
			detallerecap.setIsNew(detallerecap.getIsNewAuxiliar());	
			detallerecap.setIsChanged(detallerecap.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallerecap.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallerecap.setIsDeletedAuxiliar(false);	
			detallerecap.setIsNewAuxiliar(false);	
			detallerecap.setIsChangedAuxiliar(false);
			
			detallerecap.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleRecaps(List<DetalleRecap> detallerecaps,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleRecap detallerecap : detallerecaps) {
			if(conAsignarBase && detallerecap.getConCambioAuxiliar()) {
				detallerecap.setIsDeleted(detallerecap.getIsDeletedAuxiliar());	
				detallerecap.setIsNew(detallerecap.getIsNewAuxiliar());	
				detallerecap.setIsChanged(detallerecap.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallerecap.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallerecap.setIsDeletedAuxiliar(false);	
				detallerecap.setIsNewAuxiliar(false);	
				detallerecap.setIsChangedAuxiliar(false);
				
				detallerecap.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleRecap(DetalleRecap detallerecap,Boolean conEnteros) throws Exception  {
		detallerecap.setvalor(0.0);
		detallerecap.setiva_porcentaje(0.0);
		detallerecap.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleRecaps(List<DetalleRecap> detallerecaps,Boolean conEnteros) throws Exception  {
		
		for(DetalleRecap detallerecap: detallerecaps) {
			detallerecap.setvalor(0.0);
			detallerecap.setiva_porcentaje(0.0);
			detallerecap.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleRecap(List<DetalleRecap> detallerecaps,DetalleRecap detallerecapAux) throws Exception  {
		DetalleRecapConstantesFunciones.InicializarValoresDetalleRecap(detallerecapAux,true);
		
		for(DetalleRecap detallerecap: detallerecaps) {
			if(detallerecap.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallerecapAux.setvalor(detallerecapAux.getvalor()+detallerecap.getvalor());			
			detallerecapAux.setiva_porcentaje(detallerecapAux.getiva_porcentaje()+detallerecap.getiva_porcentaje());			
			detallerecapAux.settotal(detallerecapAux.gettotal()+detallerecap.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleRecap(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleRecapConstantesFunciones.getArrayColumnasGlobalesDetalleRecap(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleRecap(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleRecapConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleRecapConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleRecapConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleRecapConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleRecapConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleRecapConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleRecap(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleRecap> detallerecaps,DetalleRecap detallerecap,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleRecap detallerecapAux: detallerecaps) {
			if(detallerecapAux!=null && detallerecap!=null) {
				if((detallerecapAux.getId()==null && detallerecap.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallerecapAux.getId()!=null && detallerecap.getId()!=null){
					if(detallerecapAux.getId().equals(detallerecap.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleRecap(List<DetalleRecap> detallerecaps) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double iva_porcentajeTotal=0.0;
		Double totalTotal=0.0;
	
		for(DetalleRecap detallerecap: detallerecaps) {			
			if(detallerecap.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=detallerecap.getvalor();
			iva_porcentajeTotal+=detallerecap.getiva_porcentaje();
			totalTotal+=detallerecap.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleRecapConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(DetalleRecapConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleRecapConstantesFunciones.IVAPORCENTAJE);
		datoGeneral.setsDescripcion(DetalleRecapConstantesFunciones.LABEL_IVAPORCENTAJE);
		datoGeneral.setdValorDouble(iva_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleRecapConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DetalleRecapConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleRecap() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleRecapConstantesFunciones.LABEL_ID, DetalleRecapConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRecapConstantesFunciones.LABEL_VERSIONROW, DetalleRecapConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRecapConstantesFunciones.LABEL_IDRECAP, DetalleRecapConstantesFunciones.IDRECAP,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRecapConstantesFunciones.LABEL_IDEMPRESA, DetalleRecapConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRecapConstantesFunciones.LABEL_IDSUCURSAL, DetalleRecapConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRecapConstantesFunciones.LABEL_IDEJERCICIO, DetalleRecapConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRecapConstantesFunciones.LABEL_IDDETALLECLIENTE, DetalleRecapConstantesFunciones.IDDETALLECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRecapConstantesFunciones.LABEL_IDCLIENTE, DetalleRecapConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRecapConstantesFunciones.LABEL_VALOR, DetalleRecapConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRecapConstantesFunciones.LABEL_IVAPORCENTAJE, DetalleRecapConstantesFunciones.IVAPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRecapConstantesFunciones.LABEL_TOTAL, DetalleRecapConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleRecap() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleRecapConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRecapConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRecapConstantesFunciones.IDRECAP;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRecapConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRecapConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRecapConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRecapConstantesFunciones.IDDETALLECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRecapConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRecapConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRecapConstantesFunciones.IVAPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRecapConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleRecap() throws Exception  {
		return DetalleRecapConstantesFunciones.getTiposSeleccionarDetalleRecap(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleRecap(Boolean conFk) throws Exception  {
		return DetalleRecapConstantesFunciones.getTiposSeleccionarDetalleRecap(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleRecap(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRecapConstantesFunciones.LABEL_IDRECAP);
			reporte.setsDescripcion(DetalleRecapConstantesFunciones.LABEL_IDRECAP);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRecapConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleRecapConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRecapConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleRecapConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRecapConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleRecapConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRecapConstantesFunciones.LABEL_IDDETALLECLIENTE);
			reporte.setsDescripcion(DetalleRecapConstantesFunciones.LABEL_IDDETALLECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRecapConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(DetalleRecapConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRecapConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(DetalleRecapConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRecapConstantesFunciones.LABEL_IVAPORCENTAJE);
			reporte.setsDescripcion(DetalleRecapConstantesFunciones.LABEL_IVAPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRecapConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DetalleRecapConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleRecap(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleRecap(DetalleRecap detallerecapAux) throws Exception {
		
			detallerecapAux.setrecap_descripcion(RecapConstantesFunciones.getRecapDescripcion(detallerecapAux.getRecap()));
			detallerecapAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallerecapAux.getEmpresa()));
			detallerecapAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallerecapAux.getSucursal()));
			detallerecapAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallerecapAux.getEjercicio()));
			detallerecapAux.setdetallecliente_descripcion(DetalleClienteConstantesFunciones.getDetalleClienteDescripcion(detallerecapAux.getDetalleCliente()));
			detallerecapAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(detallerecapAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleRecap(List<DetalleRecap> detallerecapsTemp) throws Exception {
		for(DetalleRecap detallerecapAux:detallerecapsTemp) {
			
			detallerecapAux.setrecap_descripcion(RecapConstantesFunciones.getRecapDescripcion(detallerecapAux.getRecap()));
			detallerecapAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallerecapAux.getEmpresa()));
			detallerecapAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallerecapAux.getSucursal()));
			detallerecapAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallerecapAux.getEjercicio()));
			detallerecapAux.setdetallecliente_descripcion(DetalleClienteConstantesFunciones.getDetalleClienteDescripcion(detallerecapAux.getDetalleCliente()));
			detallerecapAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(detallerecapAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Recap.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(DetalleCliente.class));
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Recap.class)) {
						classes.add(new Classe(Recap.class));
					}
				}

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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleCliente.class)) {
						classes.add(new Classe(DetalleCliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleRecap(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Recap.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Recap.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(DetalleCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCliente.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Recap.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Recap.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(DetalleCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleRecapConstantesFunciones.getClassesRelationshipsOfDetalleRecap(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleRecap(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleRecapConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleRecap(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleRecap(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleRecap detallerecap,List<DetalleRecap> detallerecaps,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleRecap detallerecapEncontrado=null;
			
			for(DetalleRecap detallerecapLocal:detallerecaps) {
				if(detallerecapLocal.getId().equals(detallerecap.getId())) {
					detallerecapEncontrado=detallerecapLocal;
					
					detallerecapLocal.setIsChanged(detallerecap.getIsChanged());
					detallerecapLocal.setIsNew(detallerecap.getIsNew());
					detallerecapLocal.setIsDeleted(detallerecap.getIsDeleted());
					
					detallerecapLocal.setGeneralEntityOriginal(detallerecap.getGeneralEntityOriginal());
					
					detallerecapLocal.setId(detallerecap.getId());	
					detallerecapLocal.setVersionRow(detallerecap.getVersionRow());	
					detallerecapLocal.setid_recap(detallerecap.getid_recap());	
					detallerecapLocal.setid_empresa(detallerecap.getid_empresa());	
					detallerecapLocal.setid_sucursal(detallerecap.getid_sucursal());	
					detallerecapLocal.setid_ejercicio(detallerecap.getid_ejercicio());	
					detallerecapLocal.setid_detalle_cliente(detallerecap.getid_detalle_cliente());	
					detallerecapLocal.setid_cliente(detallerecap.getid_cliente());	
					detallerecapLocal.setvalor(detallerecap.getvalor());	
					detallerecapLocal.setiva_porcentaje(detallerecap.getiva_porcentaje());	
					detallerecapLocal.settotal(detallerecap.gettotal());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallerecap.getIsDeleted()) {
				if(!existe) {
					detallerecaps.add(detallerecap);
				}
			} else {
				if(detallerecapEncontrado!=null && permiteQuitar)  {
					detallerecaps.remove(detallerecapEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleRecap detallerecap,List<DetalleRecap> detallerecaps) throws Exception {
		try	{			
			for(DetalleRecap detallerecapLocal:detallerecaps) {
				if(detallerecapLocal.getId().equals(detallerecap.getId())) {
					detallerecapLocal.setIsSelected(detallerecap.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleRecap(List<DetalleRecap> detallerecapsAux) throws Exception {
		//this.detallerecapsAux=detallerecapsAux;
		
		for(DetalleRecap detallerecapAux:detallerecapsAux) {
			if(detallerecapAux.getIsChanged()) {
				detallerecapAux.setIsChanged(false);
			}		
			
			if(detallerecapAux.getIsNew()) {
				detallerecapAux.setIsNew(false);
			}	
			
			if(detallerecapAux.getIsDeleted()) {
				detallerecapAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleRecap(DetalleRecap detallerecapAux) throws Exception {
		//this.detallerecapAux=detallerecapAux;
		
			if(detallerecapAux.getIsChanged()) {
				detallerecapAux.setIsChanged(false);
			}		
			
			if(detallerecapAux.getIsNew()) {
				detallerecapAux.setIsNew(false);
			}	
			
			if(detallerecapAux.getIsDeleted()) {
				detallerecapAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleRecap detallerecapAsignar,DetalleRecap detallerecap) throws Exception {
		detallerecapAsignar.setId(detallerecap.getId());	
		detallerecapAsignar.setVersionRow(detallerecap.getVersionRow());	
		detallerecapAsignar.setid_recap(detallerecap.getid_recap());
		detallerecapAsignar.setrecap_descripcion(detallerecap.getrecap_descripcion());	
		detallerecapAsignar.setid_empresa(detallerecap.getid_empresa());
		detallerecapAsignar.setempresa_descripcion(detallerecap.getempresa_descripcion());	
		detallerecapAsignar.setid_sucursal(detallerecap.getid_sucursal());
		detallerecapAsignar.setsucursal_descripcion(detallerecap.getsucursal_descripcion());	
		detallerecapAsignar.setid_ejercicio(detallerecap.getid_ejercicio());
		detallerecapAsignar.setejercicio_descripcion(detallerecap.getejercicio_descripcion());	
		detallerecapAsignar.setid_detalle_cliente(detallerecap.getid_detalle_cliente());
		detallerecapAsignar.setdetallecliente_descripcion(detallerecap.getdetallecliente_descripcion());	
		detallerecapAsignar.setid_cliente(detallerecap.getid_cliente());
		detallerecapAsignar.setcliente_descripcion(detallerecap.getcliente_descripcion());	
		detallerecapAsignar.setvalor(detallerecap.getvalor());	
		detallerecapAsignar.setiva_porcentaje(detallerecap.getiva_porcentaje());	
		detallerecapAsignar.settotal(detallerecap.gettotal());	
	}
	
	public static void inicializarDetalleRecap(DetalleRecap detallerecap) throws Exception {
		try {
				detallerecap.setId(0L);	
					
				detallerecap.setid_recap(-1L);	
				detallerecap.setid_empresa(-1L);	
				detallerecap.setid_sucursal(-1L);	
				detallerecap.setid_ejercicio(-1L);	
				detallerecap.setid_detalle_cliente(-1L);	
				detallerecap.setid_cliente(-1L);	
				detallerecap.setvalor(0.0);	
				detallerecap.setiva_porcentaje(0.0);	
				detallerecap.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleRecap(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRecapConstantesFunciones.LABEL_IDRECAP);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRecapConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRecapConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRecapConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRecapConstantesFunciones.LABEL_IDDETALLECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRecapConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRecapConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRecapConstantesFunciones.LABEL_IVAPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRecapConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleRecap(String sTipo,Row row,Workbook workbook,DetalleRecap detallerecap,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerecap.getrecap_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerecap.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerecap.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerecap.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerecap.getdetallecliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerecap.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerecap.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerecap.getiva_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerecap.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleRecap=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleRecap() {
		return this.sFinalQueryDetalleRecap;
	}
	
	public void setsFinalQueryDetalleRecap(String sFinalQueryDetalleRecap) {
		this.sFinalQueryDetalleRecap= sFinalQueryDetalleRecap;
	}
	
	public Border resaltarSeleccionarDetalleRecap=null;
	
	public Border setResaltarSeleccionarDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallerecapBeanSwingJInternalFrame.jTtoolBarDetalleRecap.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleRecap= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleRecap() {
		return this.resaltarSeleccionarDetalleRecap;
	}
	
	public void setResaltarSeleccionarDetalleRecap(Border borderResaltarSeleccionarDetalleRecap) {
		this.resaltarSeleccionarDetalleRecap= borderResaltarSeleccionarDetalleRecap;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleRecap=null;
	public Boolean mostraridDetalleRecap=true;
	public Boolean activaridDetalleRecap=true;

	public Border resaltarid_recapDetalleRecap=null;
	public Boolean mostrarid_recapDetalleRecap=true;
	public Boolean activarid_recapDetalleRecap=true;
	public Boolean cargarid_recapDetalleRecap=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_recapDetalleRecap=false;//ConEventDepend=true

	public Border resaltarid_empresaDetalleRecap=null;
	public Boolean mostrarid_empresaDetalleRecap=true;
	public Boolean activarid_empresaDetalleRecap=true;
	public Boolean cargarid_empresaDetalleRecap=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleRecap=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleRecap=null;
	public Boolean mostrarid_sucursalDetalleRecap=true;
	public Boolean activarid_sucursalDetalleRecap=true;
	public Boolean cargarid_sucursalDetalleRecap=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleRecap=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleRecap=null;
	public Boolean mostrarid_ejercicioDetalleRecap=true;
	public Boolean activarid_ejercicioDetalleRecap=true;
	public Boolean cargarid_ejercicioDetalleRecap=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleRecap=false;//ConEventDepend=true

	public Border resaltarid_detalle_clienteDetalleRecap=null;
	public Boolean mostrarid_detalle_clienteDetalleRecap=true;
	public Boolean activarid_detalle_clienteDetalleRecap=true;
	public Boolean cargarid_detalle_clienteDetalleRecap=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_clienteDetalleRecap=false;//ConEventDepend=true

	public Border resaltarid_clienteDetalleRecap=null;
	public Boolean mostrarid_clienteDetalleRecap=true;
	public Boolean activarid_clienteDetalleRecap=true;
	public Boolean cargarid_clienteDetalleRecap=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteDetalleRecap=false;//ConEventDepend=true

	public Border resaltarvalorDetalleRecap=null;
	public Boolean mostrarvalorDetalleRecap=true;
	public Boolean activarvalorDetalleRecap=true;

	public Border resaltariva_porcentajeDetalleRecap=null;
	public Boolean mostrariva_porcentajeDetalleRecap=true;
	public Boolean activariva_porcentajeDetalleRecap=true;

	public Border resaltartotalDetalleRecap=null;
	public Boolean mostrartotalDetalleRecap=true;
	public Boolean activartotalDetalleRecap=true;

	
	

	public Border setResaltaridDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerecapBeanSwingJInternalFrame.jTtoolBarDetalleRecap.setBorder(borderResaltar);
		
		this.resaltaridDetalleRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleRecap() {
		return this.resaltaridDetalleRecap;
	}

	public void setResaltaridDetalleRecap(Border borderResaltar) {
		this.resaltaridDetalleRecap= borderResaltar;
	}

	public Boolean getMostraridDetalleRecap() {
		return this.mostraridDetalleRecap;
	}

	public void setMostraridDetalleRecap(Boolean mostraridDetalleRecap) {
		this.mostraridDetalleRecap= mostraridDetalleRecap;
	}

	public Boolean getActivaridDetalleRecap() {
		return this.activaridDetalleRecap;
	}

	public void setActivaridDetalleRecap(Boolean activaridDetalleRecap) {
		this.activaridDetalleRecap= activaridDetalleRecap;
	}

	public Border setResaltarid_recapDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerecapBeanSwingJInternalFrame.jTtoolBarDetalleRecap.setBorder(borderResaltar);
		
		this.resaltarid_recapDetalleRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_recapDetalleRecap() {
		return this.resaltarid_recapDetalleRecap;
	}

	public void setResaltarid_recapDetalleRecap(Border borderResaltar) {
		this.resaltarid_recapDetalleRecap= borderResaltar;
	}

	public Boolean getMostrarid_recapDetalleRecap() {
		return this.mostrarid_recapDetalleRecap;
	}

	public void setMostrarid_recapDetalleRecap(Boolean mostrarid_recapDetalleRecap) {
		this.mostrarid_recapDetalleRecap= mostrarid_recapDetalleRecap;
	}

	public Boolean getActivarid_recapDetalleRecap() {
		return this.activarid_recapDetalleRecap;
	}

	public void setActivarid_recapDetalleRecap(Boolean activarid_recapDetalleRecap) {
		this.activarid_recapDetalleRecap= activarid_recapDetalleRecap;
	}

	public Boolean getCargarid_recapDetalleRecap() {
		return this.cargarid_recapDetalleRecap;
	}

	public void setCargarid_recapDetalleRecap(Boolean cargarid_recapDetalleRecap) {
		this.cargarid_recapDetalleRecap= cargarid_recapDetalleRecap;
	}

	public Border setResaltarid_empresaDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerecapBeanSwingJInternalFrame.jTtoolBarDetalleRecap.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleRecap() {
		return this.resaltarid_empresaDetalleRecap;
	}

	public void setResaltarid_empresaDetalleRecap(Border borderResaltar) {
		this.resaltarid_empresaDetalleRecap= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleRecap() {
		return this.mostrarid_empresaDetalleRecap;
	}

	public void setMostrarid_empresaDetalleRecap(Boolean mostrarid_empresaDetalleRecap) {
		this.mostrarid_empresaDetalleRecap= mostrarid_empresaDetalleRecap;
	}

	public Boolean getActivarid_empresaDetalleRecap() {
		return this.activarid_empresaDetalleRecap;
	}

	public void setActivarid_empresaDetalleRecap(Boolean activarid_empresaDetalleRecap) {
		this.activarid_empresaDetalleRecap= activarid_empresaDetalleRecap;
	}

	public Boolean getCargarid_empresaDetalleRecap() {
		return this.cargarid_empresaDetalleRecap;
	}

	public void setCargarid_empresaDetalleRecap(Boolean cargarid_empresaDetalleRecap) {
		this.cargarid_empresaDetalleRecap= cargarid_empresaDetalleRecap;
	}

	public Border setResaltarid_sucursalDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerecapBeanSwingJInternalFrame.jTtoolBarDetalleRecap.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleRecap() {
		return this.resaltarid_sucursalDetalleRecap;
	}

	public void setResaltarid_sucursalDetalleRecap(Border borderResaltar) {
		this.resaltarid_sucursalDetalleRecap= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleRecap() {
		return this.mostrarid_sucursalDetalleRecap;
	}

	public void setMostrarid_sucursalDetalleRecap(Boolean mostrarid_sucursalDetalleRecap) {
		this.mostrarid_sucursalDetalleRecap= mostrarid_sucursalDetalleRecap;
	}

	public Boolean getActivarid_sucursalDetalleRecap() {
		return this.activarid_sucursalDetalleRecap;
	}

	public void setActivarid_sucursalDetalleRecap(Boolean activarid_sucursalDetalleRecap) {
		this.activarid_sucursalDetalleRecap= activarid_sucursalDetalleRecap;
	}

	public Boolean getCargarid_sucursalDetalleRecap() {
		return this.cargarid_sucursalDetalleRecap;
	}

	public void setCargarid_sucursalDetalleRecap(Boolean cargarid_sucursalDetalleRecap) {
		this.cargarid_sucursalDetalleRecap= cargarid_sucursalDetalleRecap;
	}

	public Border setResaltarid_ejercicioDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerecapBeanSwingJInternalFrame.jTtoolBarDetalleRecap.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleRecap() {
		return this.resaltarid_ejercicioDetalleRecap;
	}

	public void setResaltarid_ejercicioDetalleRecap(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleRecap= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleRecap() {
		return this.mostrarid_ejercicioDetalleRecap;
	}

	public void setMostrarid_ejercicioDetalleRecap(Boolean mostrarid_ejercicioDetalleRecap) {
		this.mostrarid_ejercicioDetalleRecap= mostrarid_ejercicioDetalleRecap;
	}

	public Boolean getActivarid_ejercicioDetalleRecap() {
		return this.activarid_ejercicioDetalleRecap;
	}

	public void setActivarid_ejercicioDetalleRecap(Boolean activarid_ejercicioDetalleRecap) {
		this.activarid_ejercicioDetalleRecap= activarid_ejercicioDetalleRecap;
	}

	public Boolean getCargarid_ejercicioDetalleRecap() {
		return this.cargarid_ejercicioDetalleRecap;
	}

	public void setCargarid_ejercicioDetalleRecap(Boolean cargarid_ejercicioDetalleRecap) {
		this.cargarid_ejercicioDetalleRecap= cargarid_ejercicioDetalleRecap;
	}

	public Border setResaltarid_detalle_clienteDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerecapBeanSwingJInternalFrame.jTtoolBarDetalleRecap.setBorder(borderResaltar);
		
		this.resaltarid_detalle_clienteDetalleRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_clienteDetalleRecap() {
		return this.resaltarid_detalle_clienteDetalleRecap;
	}

	public void setResaltarid_detalle_clienteDetalleRecap(Border borderResaltar) {
		this.resaltarid_detalle_clienteDetalleRecap= borderResaltar;
	}

	public Boolean getMostrarid_detalle_clienteDetalleRecap() {
		return this.mostrarid_detalle_clienteDetalleRecap;
	}

	public void setMostrarid_detalle_clienteDetalleRecap(Boolean mostrarid_detalle_clienteDetalleRecap) {
		this.mostrarid_detalle_clienteDetalleRecap= mostrarid_detalle_clienteDetalleRecap;
	}

	public Boolean getActivarid_detalle_clienteDetalleRecap() {
		return this.activarid_detalle_clienteDetalleRecap;
	}

	public void setActivarid_detalle_clienteDetalleRecap(Boolean activarid_detalle_clienteDetalleRecap) {
		this.activarid_detalle_clienteDetalleRecap= activarid_detalle_clienteDetalleRecap;
	}

	public Boolean getCargarid_detalle_clienteDetalleRecap() {
		return this.cargarid_detalle_clienteDetalleRecap;
	}

	public void setCargarid_detalle_clienteDetalleRecap(Boolean cargarid_detalle_clienteDetalleRecap) {
		this.cargarid_detalle_clienteDetalleRecap= cargarid_detalle_clienteDetalleRecap;
	}

	public Border setResaltarid_clienteDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerecapBeanSwingJInternalFrame.jTtoolBarDetalleRecap.setBorder(borderResaltar);
		
		this.resaltarid_clienteDetalleRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteDetalleRecap() {
		return this.resaltarid_clienteDetalleRecap;
	}

	public void setResaltarid_clienteDetalleRecap(Border borderResaltar) {
		this.resaltarid_clienteDetalleRecap= borderResaltar;
	}

	public Boolean getMostrarid_clienteDetalleRecap() {
		return this.mostrarid_clienteDetalleRecap;
	}

	public void setMostrarid_clienteDetalleRecap(Boolean mostrarid_clienteDetalleRecap) {
		this.mostrarid_clienteDetalleRecap= mostrarid_clienteDetalleRecap;
	}

	public Boolean getActivarid_clienteDetalleRecap() {
		return this.activarid_clienteDetalleRecap;
	}

	public void setActivarid_clienteDetalleRecap(Boolean activarid_clienteDetalleRecap) {
		this.activarid_clienteDetalleRecap= activarid_clienteDetalleRecap;
	}

	public Boolean getCargarid_clienteDetalleRecap() {
		return this.cargarid_clienteDetalleRecap;
	}

	public void setCargarid_clienteDetalleRecap(Boolean cargarid_clienteDetalleRecap) {
		this.cargarid_clienteDetalleRecap= cargarid_clienteDetalleRecap;
	}

	public Border setResaltarvalorDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerecapBeanSwingJInternalFrame.jTtoolBarDetalleRecap.setBorder(borderResaltar);
		
		this.resaltarvalorDetalleRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorDetalleRecap() {
		return this.resaltarvalorDetalleRecap;
	}

	public void setResaltarvalorDetalleRecap(Border borderResaltar) {
		this.resaltarvalorDetalleRecap= borderResaltar;
	}

	public Boolean getMostrarvalorDetalleRecap() {
		return this.mostrarvalorDetalleRecap;
	}

	public void setMostrarvalorDetalleRecap(Boolean mostrarvalorDetalleRecap) {
		this.mostrarvalorDetalleRecap= mostrarvalorDetalleRecap;
	}

	public Boolean getActivarvalorDetalleRecap() {
		return this.activarvalorDetalleRecap;
	}

	public void setActivarvalorDetalleRecap(Boolean activarvalorDetalleRecap) {
		this.activarvalorDetalleRecap= activarvalorDetalleRecap;
	}

	public Border setResaltariva_porcentajeDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerecapBeanSwingJInternalFrame.jTtoolBarDetalleRecap.setBorder(borderResaltar);
		
		this.resaltariva_porcentajeDetalleRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariva_porcentajeDetalleRecap() {
		return this.resaltariva_porcentajeDetalleRecap;
	}

	public void setResaltariva_porcentajeDetalleRecap(Border borderResaltar) {
		this.resaltariva_porcentajeDetalleRecap= borderResaltar;
	}

	public Boolean getMostrariva_porcentajeDetalleRecap() {
		return this.mostrariva_porcentajeDetalleRecap;
	}

	public void setMostrariva_porcentajeDetalleRecap(Boolean mostrariva_porcentajeDetalleRecap) {
		this.mostrariva_porcentajeDetalleRecap= mostrariva_porcentajeDetalleRecap;
	}

	public Boolean getActivariva_porcentajeDetalleRecap() {
		return this.activariva_porcentajeDetalleRecap;
	}

	public void setActivariva_porcentajeDetalleRecap(Boolean activariva_porcentajeDetalleRecap) {
		this.activariva_porcentajeDetalleRecap= activariva_porcentajeDetalleRecap;
	}

	public Border setResaltartotalDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerecapBeanSwingJInternalFrame.jTtoolBarDetalleRecap.setBorder(borderResaltar);
		
		this.resaltartotalDetalleRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDetalleRecap() {
		return this.resaltartotalDetalleRecap;
	}

	public void setResaltartotalDetalleRecap(Border borderResaltar) {
		this.resaltartotalDetalleRecap= borderResaltar;
	}

	public Boolean getMostrartotalDetalleRecap() {
		return this.mostrartotalDetalleRecap;
	}

	public void setMostrartotalDetalleRecap(Boolean mostrartotalDetalleRecap) {
		this.mostrartotalDetalleRecap= mostrartotalDetalleRecap;
	}

	public Boolean getActivartotalDetalleRecap() {
		return this.activartotalDetalleRecap;
	}

	public void setActivartotalDetalleRecap(Boolean activartotalDetalleRecap) {
		this.activartotalDetalleRecap= activartotalDetalleRecap;
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
		
		
		this.setMostraridDetalleRecap(esInicial);
		this.setMostrarid_recapDetalleRecap(esInicial);
		this.setMostrarid_empresaDetalleRecap(esInicial);
		this.setMostrarid_sucursalDetalleRecap(esInicial);
		this.setMostrarid_ejercicioDetalleRecap(esInicial);
		this.setMostrarid_detalle_clienteDetalleRecap(esInicial);
		this.setMostrarid_clienteDetalleRecap(esInicial);
		this.setMostrarvalorDetalleRecap(esInicial);
		this.setMostrariva_porcentajeDetalleRecap(esInicial);
		this.setMostrartotalDetalleRecap(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleRecapConstantesFunciones.ID)) {
				this.setMostraridDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDRECAP)) {
				this.setMostrarid_recapDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDDETALLECLIENTE)) {
				this.setMostrarid_detalle_clienteDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.VALOR)) {
				this.setMostrarvalorDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IVAPORCENTAJE)) {
				this.setMostrariva_porcentajeDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.TOTAL)) {
				this.setMostrartotalDetalleRecap(esAsigna);
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
		
		
		this.setActivaridDetalleRecap(esInicial);
		this.setActivarid_recapDetalleRecap(esInicial);
		this.setActivarid_empresaDetalleRecap(esInicial);
		this.setActivarid_sucursalDetalleRecap(esInicial);
		this.setActivarid_ejercicioDetalleRecap(esInicial);
		this.setActivarid_detalle_clienteDetalleRecap(esInicial);
		this.setActivarid_clienteDetalleRecap(esInicial);
		this.setActivarvalorDetalleRecap(esInicial);
		this.setActivariva_porcentajeDetalleRecap(esInicial);
		this.setActivartotalDetalleRecap(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleRecapConstantesFunciones.ID)) {
				this.setActivaridDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDRECAP)) {
				this.setActivarid_recapDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDDETALLECLIENTE)) {
				this.setActivarid_detalle_clienteDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.VALOR)) {
				this.setActivarvalorDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IVAPORCENTAJE)) {
				this.setActivariva_porcentajeDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.TOTAL)) {
				this.setActivartotalDetalleRecap(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleRecap(esInicial);
		this.setResaltarid_recapDetalleRecap(esInicial);
		this.setResaltarid_empresaDetalleRecap(esInicial);
		this.setResaltarid_sucursalDetalleRecap(esInicial);
		this.setResaltarid_ejercicioDetalleRecap(esInicial);
		this.setResaltarid_detalle_clienteDetalleRecap(esInicial);
		this.setResaltarid_clienteDetalleRecap(esInicial);
		this.setResaltarvalorDetalleRecap(esInicial);
		this.setResaltariva_porcentajeDetalleRecap(esInicial);
		this.setResaltartotalDetalleRecap(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleRecapConstantesFunciones.ID)) {
				this.setResaltaridDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDRECAP)) {
				this.setResaltarid_recapDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDDETALLECLIENTE)) {
				this.setResaltarid_detalle_clienteDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.VALOR)) {
				this.setResaltarvalorDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.IVAPORCENTAJE)) {
				this.setResaltariva_porcentajeDetalleRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRecapConstantesFunciones.TOTAL)) {
				this.setResaltartotalDetalleRecap(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteDetalleRecap=true;

	public Boolean getMostrarFK_IdClienteDetalleRecap() {
		return this.mostrarFK_IdClienteDetalleRecap;
	}

	public void setMostrarFK_IdClienteDetalleRecap(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteDetalleRecap= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleClienteDetalleRecap=true;

	public Boolean getMostrarFK_IdDetalleClienteDetalleRecap() {
		return this.mostrarFK_IdDetalleClienteDetalleRecap;
	}

	public void setMostrarFK_IdDetalleClienteDetalleRecap(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleClienteDetalleRecap= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleRecap=true;

	public Boolean getMostrarFK_IdEjercicioDetalleRecap() {
		return this.mostrarFK_IdEjercicioDetalleRecap;
	}

	public void setMostrarFK_IdEjercicioDetalleRecap(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleRecap= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleRecap=true;

	public Boolean getMostrarFK_IdEmpresaDetalleRecap() {
		return this.mostrarFK_IdEmpresaDetalleRecap;
	}

	public void setMostrarFK_IdEmpresaDetalleRecap(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleRecap= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRecapDetalleRecap=true;

	public Boolean getMostrarFK_IdRecapDetalleRecap() {
		return this.mostrarFK_IdRecapDetalleRecap;
	}

	public void setMostrarFK_IdRecapDetalleRecap(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRecapDetalleRecap= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleRecap=true;

	public Boolean getMostrarFK_IdSucursalDetalleRecap() {
		return this.mostrarFK_IdSucursalDetalleRecap;
	}

	public void setMostrarFK_IdSucursalDetalleRecap(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleRecap= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteDetalleRecap=true;

	public Boolean getActivarFK_IdClienteDetalleRecap() {
		return this.activarFK_IdClienteDetalleRecap;
	}

	public void setActivarFK_IdClienteDetalleRecap(Boolean habilitarResaltar) {
		this.activarFK_IdClienteDetalleRecap= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleClienteDetalleRecap=true;

	public Boolean getActivarFK_IdDetalleClienteDetalleRecap() {
		return this.activarFK_IdDetalleClienteDetalleRecap;
	}

	public void setActivarFK_IdDetalleClienteDetalleRecap(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleClienteDetalleRecap= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleRecap=true;

	public Boolean getActivarFK_IdEjercicioDetalleRecap() {
		return this.activarFK_IdEjercicioDetalleRecap;
	}

	public void setActivarFK_IdEjercicioDetalleRecap(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleRecap= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleRecap=true;

	public Boolean getActivarFK_IdEmpresaDetalleRecap() {
		return this.activarFK_IdEmpresaDetalleRecap;
	}

	public void setActivarFK_IdEmpresaDetalleRecap(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleRecap= habilitarResaltar;
	}

	public Boolean activarFK_IdRecapDetalleRecap=true;

	public Boolean getActivarFK_IdRecapDetalleRecap() {
		return this.activarFK_IdRecapDetalleRecap;
	}

	public void setActivarFK_IdRecapDetalleRecap(Boolean habilitarResaltar) {
		this.activarFK_IdRecapDetalleRecap= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleRecap=true;

	public Boolean getActivarFK_IdSucursalDetalleRecap() {
		return this.activarFK_IdSucursalDetalleRecap;
	}

	public void setActivarFK_IdSucursalDetalleRecap(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleRecap= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteDetalleRecap=null;

	public Border getResaltarFK_IdClienteDetalleRecap() {
		return this.resaltarFK_IdClienteDetalleRecap;
	}

	public void setResaltarFK_IdClienteDetalleRecap(Border borderResaltar) {
		this.resaltarFK_IdClienteDetalleRecap= borderResaltar;
	}

	public void setResaltarFK_IdClienteDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteDetalleRecap= borderResaltar;
	}

	public Border resaltarFK_IdDetalleClienteDetalleRecap=null;

	public Border getResaltarFK_IdDetalleClienteDetalleRecap() {
		return this.resaltarFK_IdDetalleClienteDetalleRecap;
	}

	public void setResaltarFK_IdDetalleClienteDetalleRecap(Border borderResaltar) {
		this.resaltarFK_IdDetalleClienteDetalleRecap= borderResaltar;
	}

	public void setResaltarFK_IdDetalleClienteDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleClienteDetalleRecap= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleRecap=null;

	public Border getResaltarFK_IdEjercicioDetalleRecap() {
		return this.resaltarFK_IdEjercicioDetalleRecap;
	}

	public void setResaltarFK_IdEjercicioDetalleRecap(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleRecap= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleRecap= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleRecap=null;

	public Border getResaltarFK_IdEmpresaDetalleRecap() {
		return this.resaltarFK_IdEmpresaDetalleRecap;
	}

	public void setResaltarFK_IdEmpresaDetalleRecap(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleRecap= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleRecap= borderResaltar;
	}

	public Border resaltarFK_IdRecapDetalleRecap=null;

	public Border getResaltarFK_IdRecapDetalleRecap() {
		return this.resaltarFK_IdRecapDetalleRecap;
	}

	public void setResaltarFK_IdRecapDetalleRecap(Border borderResaltar) {
		this.resaltarFK_IdRecapDetalleRecap= borderResaltar;
	}

	public void setResaltarFK_IdRecapDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRecapDetalleRecap= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleRecap=null;

	public Border getResaltarFK_IdSucursalDetalleRecap() {
		return this.resaltarFK_IdSucursalDetalleRecap;
	}

	public void setResaltarFK_IdSucursalDetalleRecap(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleRecap= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleRecap(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRecapBeanSwingJInternalFrame detallerecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleRecap= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}